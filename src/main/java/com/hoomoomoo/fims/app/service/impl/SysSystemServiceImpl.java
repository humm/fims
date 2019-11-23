package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.FimsApplication;
import com.hoomoomoo.fims.app.config.RunDataConfig;
import com.hoomoomoo.fims.app.config.bean.DatasourceConfigBean;
import com.hoomoomoo.fims.app.config.bean.FimsConfigBean;
import com.hoomoomoo.fims.app.dao.SysDictionaryDao;
import com.hoomoomoo.fims.app.dao.SysUserDao;
import com.hoomoomoo.fims.app.dao.SysSystemDao;
import com.hoomoomoo.fims.app.model.*;
import com.hoomoomoo.fims.app.model.common.BaseModel;
import com.hoomoomoo.fims.app.model.common.SessionBean;
import com.hoomoomoo.fims.app.model.common.ViewData;
import com.hoomoomoo.fims.app.service.SysParameterService;
import com.hoomoomoo.fims.app.service.SysSystemService;
import com.hoomoomoo.fims.app.util.SysBeanUtils;
import com.hoomoomoo.fims.app.util.SysDateUtils;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import com.hoomoomoo.fims.app.util.SystemSessionUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.hoomoomoo.fims.app.config.RunDataConfig.*;
import static com.hoomoomoo.fims.app.consts.DictionaryConst.*;
import static com.hoomoomoo.fims.app.consts.ParameterConst.*;
import static com.hoomoomoo.fims.app.consts.ParameterConst.MIND_FILL;
import static com.hoomoomoo.fims.app.consts.SystemConst.*;
import static com.hoomoomoo.fims.app.consts.TipConst.*;
import static com.hoomoomoo.fims.app.consts.BusinessConst.*;

/**
 * @author humm23693
 * @description 系统级别公用服务
 * @package com.hoomoomoo.fims.app.service.common.imp
 * @date 2019/08/04
 */

@Service
@Transactional
public class SysSystemServiceImpl implements SysSystemService {

    private static final Logger logger = LoggerFactory.getLogger(SysSystemServiceImpl.class);

    @Autowired
    private FimsConfigBean fimsConfigBean;

    @Autowired
    private DatasourceConfigBean datasourceConfigBean;

    @Autowired
    private Environment environment;

    @Autowired
    private SysSystemDao sysSystemDao;

    @Autowired
    private SysDictionaryDao sysDictionaryDao;

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysParameterService sysParameterService;

    /**
     * 控制台输出应用配置参数
     */
    @Override
    public void outputConfigParameter() {
        if (!sysParameterService.getParameterBoolean(START_CONSOLE_OUTPUT)) {
            return;
        }
        Properties properties = new OrderedProperties();
        SysLogUtils.configStart(logger, LOG_BUSINESS_TYPE_PARAMETER_CONFIG);
        try {
            InputStream inputStream =
                    FimsApplication.class.getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES.split(COLON)[1]);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            SysLogUtils.exception(logger, LOG_BUSINESS_TYPE_PARAMETER_CONFIG, e);
        } catch (IOException e) {
            SysLogUtils.exception(logger, LOG_BUSINESS_TYPE_PARAMETER_CONFIG, e);
        }
        Iterator iterator = properties.stringPropertyNames().iterator();
        while (iterator.hasNext()) {
            StringBuffer singleProperty = new StringBuffer();
            String key = String.valueOf(iterator.next());
            singleProperty.append(key).append(EQUAL_SIGN).append(convertValue(key));
            boolean isIgnore = false;
            String ruleConfig = fimsConfigBean.getIgnoreOutputKeyword();
            if (StringUtils.isNotBlank(ruleConfig)) {
                String[] rules = ruleConfig.split(COMMA);
                for (String rule : rules) {
                    if (key.startsWith(rule) || key.endsWith(rule)) {
                        isIgnore = true;
                        break;
                    }
                }
            }
            if (!isIgnore) {
                SysLogUtils.info(logger, singleProperty);
            }
        }
        SysLogUtils.configEnd(logger, LOG_BUSINESS_TYPE_PARAMETER_CONFIG);
    }

    /**
     * 加载业务ID
     *
     * @return
     */
    @Override
    public void loadBusinessId() {
        SysLogUtils.functionStart(logger, LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_LOAD);
        List<String> businessIdList = sysSystemDao.loadBusinessId();
        if (CollectionUtils.isNotEmpty(businessIdList)) {
            for (String businessId : businessIdList) {
                if (businessId.split(MINUS).length != 2) {
                    continue;
                }
                String businessKey = businessId.split(MINUS)[0];
                String businessValue = businessId.split(MINUS)[1];
                BUSINESS_SERIAL_NO.put(businessKey, businessValue);
            }
        }
        SysLogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_LOAD);
    }

    /**
     * 根据业务类型获取业务ID
     *
     * @param businessType
     * @return
     */
    @Override
    public String getBusinessSerialNo(String businessType) {
        SysLogUtils.functionStart(logger, LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_GET);
        if (StringUtils.isBlank(businessType)) {
            SysLogUtils.fail(logger, LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_GET, BUSINESS_TYPE_NOT_EMPTY);
            SysLogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_GET);
            return null;
        }
        String businessId = null;
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            businessId = BUSINESS_SERIAL_NO.get(businessType);
            // 业务ID不存在 设置默认值
            if (StringUtils.isBlank(businessId)) {
                businessId = SysDateUtils.yyyy() + BUSINESS_ID_DEFAULT;
            } else {
                String businessYear = businessId.substring(0, 4);
                String businessNo = businessId.substring(4);
                // 业务ID时间不是当前时间 设置默认值
                if (!SysDateUtils.yyyy().equals(businessYear)) {
                    businessId = SysDateUtils.yyyy() + BUSINESS_ID_DEFAULT;
                } else {
                    // 去除多去的0 获取序列号
                    while (businessNo.startsWith(STR_0)) {
                        businessNo = businessNo.substring(1);
                    }
                    // 序列号加1
                    businessNo = String.valueOf(Long.valueOf(businessNo) + 1);
                    // 序列号补0
                    while (businessNo.length() < 10) {
                        businessNo = STR_0 + businessNo;
                    }
                    businessId = businessYear + businessNo;
                }
            }
            // 更新内存数据序列号值
            BUSINESS_SERIAL_NO.put(businessType, businessId);
            SysLogUtils.success(logger, LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_GET, businessType + MINUS + businessId);
        } catch (Exception e) {
            SysLogUtils.exception(logger, LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_GET, e);
        } finally {
            lock.unlock();
        }
        SysLogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_GET);
        return businessId;
    }

    /**
     * 字典转义
     *
     * @param list
     * @param clazz
     * @return
     */
    @Override
    public List transferData(List list, Class clazz) {
        SysLogUtils.functionStart(logger, LOG_BUSINESS_TYPE_DICTIONARY_TRANSFER);
        List<BaseModel> baseModelList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(list)) {
            // 本次查询缓存数据
            Map dictionaryCache = new HashMap(16);
            for (Object obj : list) {
                baseModelList.add(transfer(dictionaryCache, SysBeanUtils.beanToMap(obj), clazz));
            }
        }
        SysLogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_DICTIONARY_TRANSFER);
        return baseModelList;
    }

    /**
     * 字典转义
     *
     * @param baseModel
     * @return
     */
    @Override
    public void transferData(BaseModel baseModel, Class clazz) {
        SysLogUtils.functionStart(logger, LOG_BUSINESS_TYPE_DICTIONARY_TRANSFER);
        if (baseModel != null) {
            BaseModel baseModelTransfer = transfer(new HashMap(16), SysBeanUtils.beanToMap(baseModel), clazz);
            BeanUtils.copyProperties(baseModelTransfer, baseModel);
        }
        SysLogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_DICTIONARY_TRANSFER);
    }

    /**
     * 加载所有字典查询条件
     *
     * @return
     */
    @Override
    public void loadSysDictionaryCondition() {
        Map<String, Boolean> userDataAuthority = new HashMap(16);
        SysLogUtils.functionStart(logger, LOG_BUSINESS_TYPE_DICTIONARY_LOAD);
        DICTIONARY_CONDITION.clear();
        // 查询用户信息
        List<SysUserModel> sysUserList = sysUserDao.selectSysUser(null);
        // 查询字典信息
        List<SysDictionaryModel> sysDictionaryList = sysDictionaryDao.selectSysDictionaryCondition();
        // 拼装数据
        for (SysUserModel sysUserModel : sysUserList) {
            for (SysDictionaryModel sysDictionaryModel : sysDictionaryList) {
                String dictionaryCode = sysDictionaryModel.getDictionaryCode();
                // 用户不存在
                if (DICTIONARY_CONDITION.get(sysUserModel.getUserId()) == null) {
                    setDictionaryItem(sysUserModel, sysDictionaryModel, userDataAuthority,
                            new ConcurrentHashMap(), new ConcurrentHashMap());
                } else {
                    // 用户存在 字典不存在
                    if (DICTIONARY_CONDITION.get(sysUserModel.getUserId()).get(dictionaryCode) == null) {
                        setDictionaryItem(sysUserModel, sysDictionaryModel, userDataAuthority,
                                DICTIONARY_CONDITION.get(sysUserModel.getUserId()),
                                DICTIONARY_CONDITION.get(new StringBuffer(sysUserModel.getUserId()).append(BLANK).toString()));
                    } else {
                        // 用户存在 字典存在
                        if (isUserDictionary(sysUserModel, sysDictionaryModel, userDataAuthority)) {
                            DICTIONARY_CONDITION.get(sysUserModel.getUserId()).get(dictionaryCode).add(sysDictionaryModel);
                            DICTIONARY_CONDITION.get(new StringBuffer(sysUserModel.getUserId()).append(BLANK).toString()).get(dictionaryCode).add(sysDictionaryModel);
                        }
                    }
                }
            }
        }
        SysLogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_DICTIONARY_LOAD);
    }

    /**
     * 获取用户ID
     *
     * @return
     */
    @Override
    public String getUserId() {
        SysLogUtils.functionStart(logger, LOG_BUSINESS_TYPE_USER_ID_SELECT);
        String userId = STR_EMPTY;
        SessionBean sessionBean = SystemSessionUtils.getSession();
        if (sessionBean != null) {
            userId = sessionBean.getUserId();
        } else {
            SysUserQueryModel sysUserQueryModel = new SysUserQueryModel();
            sysUserQueryModel.setUserCode(ADMIN_CODE);
            List<SysUserModel> sysUserModelList = sysUserDao.selectSysUser(sysUserQueryModel);
            if (CollectionUtils.isNotEmpty(sysUserModelList)) {
                SysUserModel sysUserModel = sysUserModelList.get(0);
                if (sysUserModel != null) {
                    userId = sysUserModel.getUserId();
                }
            }
        }
        SysLogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_USER_ID_SELECT);
        return userId;
    }

    /**
     * 设置查询条件
     *
     * @param viewData
     */
    @Override
    public void setCondition(ViewData viewData) {
        SysLogUtils.functionStart(logger, LOG_BUSINESS_TYPE_CONDITION_SET);
        // 智能填充
        viewData.setMindFill(RunDataConfig.MIND_FILL);
        // 设置登录用户信息
        viewData.setSessionBean(SystemSessionUtils.getSession());
        String userId = getUserId();
        // 获取查询条件
        switch (viewData.getViewType()) {
            case BUSINESS_TYPE_INCOME:
                viewData.getCondition().put(SELECT_USER_ID,
                        DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D000));
                viewData.getCondition().put(SELECT_INCOME_COMPANY,
                        DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D005));
                viewData.getCondition().put(SELECT_INCOME_TYPE,
                        DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D003));
                break;
            case BUSINESS_TYPE_GIFT:
                viewData.getCondition().put(SELECT_GIFT_TYPE,
                        DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D004));
                viewData.getCondition().put(SELECT_GIFT_SENDER,
                        DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D009));
                viewData.getCondition().put(SELECT_GIFT_RECEIVER,
                        DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D009));
                break;
            case BUSINESS_TYPE_USER:
                viewData.getCondition().put(SELECT_USER_STATUS,
                        DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D001));
                break;
            case BUSINESS_TYPE_LOGIN_LOG:
                viewData.getCondition().put(SELECT_USER_ID,
                        DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D000));
                viewData.getCondition().put(SELECT_LOGIN_STATUS,
                        DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D002));
                break;
            case BUSINESS_TYPE_NOTICE:
                viewData.getCondition().put(SELECT_USER_ID,
                        DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D000));
                viewData.getCondition().put(SELECT_NOTICE_TYPE,
                        DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D008));
                viewData.getCondition().put(SELECT_NOTICE_STATUS,
                        DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D007));
                viewData.getCondition().put(SELECT_READ_STATUS,
                        DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D012));
                viewData.getCondition().put(SELECT_BUSINESS_TYPE,
                        DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D011));
                viewData.getCondition().put(SELECT_BUSINESS_SUB_TYPE,
                        DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D003));
                viewData.getCondition().get(SELECT_BUSINESS_SUB_TYPE).addAll(DICTIONARY_CONDITION.get(userId).get(D004));
                break;
            default:
                break;
        }
        SysLogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_CONDITION_SET);
    }

    /**
     * 查询按钮权限
     *
     * @param menuId
     * @return
     */
    @Override
    public Boolean selectButtonAuthority(String menuId) {
        Boolean hasAuthority = false;
        SysLogUtils.functionStart(logger, LOG_BUSINESS_TYPE_BUTTON_AUTHORITY_SELECT);
        SessionBean sessionBean = SystemSessionUtils.getSession();
        if (sessionBean != null) {
            if (ADMIN_CODE.equals(sessionBean.getUserCode())) {
                hasAuthority = true;
            } else {
                // 获取按钮权限
                SysSystemQueryModel sysSystemQueryModel = new SysSystemQueryModel();
                sysSystemQueryModel.setMenuId(menuId);
                sysSystemQueryModel.setUserId(sessionBean.getUserId());
                hasAuthority = sysSystemDao.selectButtonAuthority(sysSystemQueryModel);
            }
        }
        SysLogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_BUTTON_AUTHORITY_SELECT);
        return hasAuthority;
    }

    /**
     * 获取用户密码
     *
     * @return
     */
    @Override
    public String selectUserPassword() {
        String password = STR_EMPTY;
        SessionBean sessionBean = SystemSessionUtils.getSession();
        if (sessionBean != null) {
            SysUserQueryModel sysUserQueryModel = new SysUserQueryModel();
            sysUserQueryModel.setUserId(sessionBean.getUserId());
            List<SysUserModel> sysUserModelList = sysUserDao.selectSysUser(sysUserQueryModel);
            if (CollectionUtils.isNotEmpty(sysUserModelList)) {
                password = new StringBuffer(sysUserModelList.get(0).getUserPassword()).reverse().toString();
            }
        }
        return password;
    }

    /**
     * 系统初始化
     */
    @Override
    public void initSystem() {
        // 初始化模式  1:不初始化 2:强制初始化 3:弱校验初始化 4:强校验初始化
        String initMode = fimsConfigBean.getInitMode();
        switch (initMode) {
            case STR_2:
                initData();
                break;
            case STR_3:
                // 有表不存在则初始化
                int num = SYSTEM_TABLE.split(COMMA).length;
                int tableNum = sysSystemDao.selectTableNum(SYSTEM_TABLE.toLowerCase());
                if (num > tableNum) {
                    initData();
                }
                break;
            case STR_4:
                // 所有表不存在则初始化
                tableNum = sysSystemDao.selectTableNum(SYSTEM_TABLE.toLowerCase());
                if (tableNum == 0) {
                    initData();
                }
                break;
            default:
                break;
        }
    }

    /**
     * 参数初始化
     */
    @Override
    public void initParameter() {
        // 控制台输出请求标记
        RunDataConfig.LOG_REQUEST_TAG = sysParameterService.getParameterBoolean(CONSOLE_OUTPUT_LOG_REQUEST_TAG);
        // 控制台输出请求入参
        RunDataConfig.LOG_REQUEST_PARAMETER = sysParameterService.getParameterBoolean(CONSOLE_OUTPUT_LOG_REQUEST_PARAMETER);
        // 智能填充
        RunDataConfig.MIND_FILL = sysParameterService.getParameterBoolean(MIND_FILL);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        SysLogUtils.functionStart(logger, LOG_BUSINESS_TYPE_INIT_SYSTEM);
        try {
            Connection connection = getConnection();
            if (connection != null) {
                // 初始化存储过程
                File file = ResourceUtils.getFile(INIT_SYSTEM_PROCEDURE);
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                StringBuffer content = new StringBuffer();
                String temp = null;
                while((temp = bufferedReader.readLine()) != null){
                    content.append(temp);
                }
                if (StringUtils.isNotBlank(content.toString())) {
                    Statement statement = connection.createStatement();
                    String[] procedure = content.toString().split(INIT_SYSTEM_PROCEDURE_SPLIT);
                    for (int i=0; i<procedure.length; i++) {
                        if (i == 0) {
                            // 文件描述内容不执行
                            continue;
                        }
                        statement.execute(procedure[i]);
                    }
                }
                // 初始化数据
                ScriptRunner runner = new ScriptRunner(connection);
                Resources.setCharset(Charset.forName(UTF8));
                runner.setLogWriter(null);
                Reader reader = Resources.getResourceAsReader(INIT_SYSTEM_TABLE);
                runner.runScript(reader);

                // 关闭资源连接
                bufferedReader.close();
                reader.close();
                runner.closeConnection();
                connection.close();
            }
        } catch (IOException e) {
            SysLogUtils.exception(logger, LOG_BUSINESS_TYPE_INIT_SYSTEM, e);
        } catch (SQLException e) {
            SysLogUtils.exception(logger, LOG_BUSINESS_TYPE_INIT_SYSTEM, e);
        }
        SysLogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_INIT_SYSTEM);
    }


    /**
     * 获取数据库连接驱动
     * @return
     */
    private Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    datasourceConfigBean.getUrl(),
                    datasourceConfigBean.getUsername(),
                    datasourceConfigBean.getPassword());
        } catch (SQLException e) {
            SysLogUtils.exception(logger, LOG_BUSINESS_TYPE_INIT_SYSTEM, e);
        }
        return connection;
    }

    /**
     * 设置字典项
     *
     * @param sysUserModel
     * @param sysDictionaryModel
     * @param codeMap
     * @param codeMapBlank
     */
    private void setDictionaryItem(SysUserModel sysUserModel, SysDictionaryModel sysDictionaryModel,
                                   Map<String, Boolean> userDataAuthority,
                                   ConcurrentHashMap<String, List<SysDictionaryModel>> codeMap,
                                   ConcurrentHashMap<String, List<SysDictionaryModel>> codeMapBlank) {
        // 字典不存在
        if (codeMap.get(sysDictionaryModel.getDictionaryCode()) == null) {
            List<SysDictionaryModel> item = new ArrayList<>();
            List<SysDictionaryModel> itemBlank = new ArrayList<>();
            // 设置请选择选项
            SysDictionaryModel select = new SysDictionaryModel();
            BeanUtils.copyProperties(sysDictionaryModel, select);
            select.setDictionaryItem(STR_EMPTY);
            select.setDictionaryCaption(SELECT);
            select.setItemOrder(STR_0);
            itemBlank.add(select);

            if (isUserDictionary(sysUserModel, sysDictionaryModel, userDataAuthority)) {
                item.add(sysDictionaryModel);
                itemBlank.add(sysDictionaryModel);
            }

            codeMap.put(sysDictionaryModel.getDictionaryCode(), item);
            codeMapBlank.put(sysDictionaryModel.getDictionaryCode(), itemBlank);
        } else {
            // 字典存在
            if (isUserDictionary(sysUserModel, sysDictionaryModel, userDataAuthority)) {
                codeMap.get(sysDictionaryModel.getDictionaryCode()).add(sysDictionaryModel);
                codeMapBlank.get(sysDictionaryModel.getDictionaryCode()).add(sysDictionaryModel);
            }
        }
        DICTIONARY_CONDITION.put(sysUserModel.getUserId(), codeMap);
        DICTIONARY_CONDITION.put(new StringBuffer(sysUserModel.getUserId()).append(BLANK).toString(), codeMapBlank);
    }

    /**
     * 是否用户字典信息
     *
     * @param sysUserModel
     * @param sysDictionaryModel
     * @return
     */
    private Boolean isUserDictionary(SysUserModel sysUserModel, SysDictionaryModel sysDictionaryModel,
                                     Map<String, Boolean> userDataAuthority) {
        boolean flag =
                D000.equals(sysDictionaryModel.getDictionaryCode()) || D005.equals(sysDictionaryModel.getDictionaryCode())
                        || D009.equals(sysDictionaryModel.getDictionaryCode());
        if (!selectDataAuthority(sysUserModel, userDataAuthority) && flag) {
            return sysUserModel.getUserId().equals(sysDictionaryModel.getUserId());
        }
        return true;
    }

    private Boolean selectDataAuthority(SysUserModel sysUserModel, Map<String, Boolean> userDataAuthority) {
        if (userDataAuthority.containsKey(sysUserModel.getUserId())) {
            return userDataAuthority.get(sysUserModel.getUserId());
        }
        if (ADMIN_CODE.equals(sysUserModel.getUserCode())) {
            userDataAuthority.put(sysUserModel.getUserId(), true);
            return true;
        } else {
            SysSystemQueryModel sysSystemQueryModel = new SysSystemQueryModel();
            sysSystemQueryModel.setUserId(sysUserModel.getUserId());
            Boolean hasDataAuthority = sysSystemDao.selectDataAuthority(sysSystemQueryModel);
            userDataAuthority.put(sysUserModel.getUserId(), hasDataAuthority);
            return hasDataAuthority;
        }
    }

    /**
     * 转义
     *
     * @param dictionaryCache
     * @param ele
     */
    private BaseModel transfer(Map dictionaryCache, Map ele, Class clazz) {
        Iterator<String> iterator = ele.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (ele.get(key) == null) {
                continue;
            }
            String value = String.valueOf(ele.get(key));
            // 字典项转义
            if (StringUtils.isNotBlank(value) && value.split(MINUS).length == 2) {
                if (dictionaryCache.get(value) != null) {
                    ele.put(key, dictionaryCache.get(value));
                } else {
                    String dictionaryCode = value.split(MINUS)[0];
                    String dictionaryItem = value.split(MINUS)[1];
                    SysDictionaryQueryModel sysDictionaryQueryModel = new SysDictionaryQueryModel();
                    sysDictionaryQueryModel.setDictionaryCode(dictionaryCode);
                    sysDictionaryQueryModel.setDictionaryItem(dictionaryItem);
                    List<SysDictionaryModel> dictionaryList =
                            sysDictionaryDao.selectSysDictionary(sysDictionaryQueryModel);
                    if (CollectionUtils.isNotEmpty(dictionaryList)) {
                        ele.put(key, dictionaryList.get(0).getDictionaryCaption());
                        dictionaryCache.put(value, dictionaryList.get(0).getDictionaryCaption());
                    }
                }
                continue;
            }

            // 配置key转义
            int index = -1;
            String[] keys = TRANSFER_KEY.split(COMMA);
            for (int i = 0; i < keys.length; i++) {
                if (keys[i].equalsIgnoreCase(key) || key.toLowerCase().contains(keys[i].toLowerCase())) {
                    index = i;
                }
            }
            if (index == -1) {
                continue;
            }
            if (dictionaryCache.get(value) != null) {
                ele.put(key, dictionaryCache.get(value));
            } else {
                switch (index) {
                    case 0:
                        // 用户信息userId不转义
                        if (!clazz.equals(SysUserModel.class)) {
                            // 转义 userId
                            SysUserQueryModel sysUserQueryModel = new SysUserQueryModel();
                            sysUserQueryModel.setUserId(value);
                            List<SysUserModel> sysUserList = sysUserDao.selectSysUser(sysUserQueryModel);
                            if (CollectionUtils.isNotEmpty(sysUserList)) {
                                ele.put(key, sysUserList.get(0).getUserName());
                                dictionaryCache.put(value, sysUserList.get(0).getUserName());
                            }
                        }

                        break;
                    default:
                        break;
                }
            }
            // 金额格式化
            if (key.toLowerCase().contains(AMOUNT) && Double.valueOf(value) >= 1) {
                DecimalFormat decimalFormat = new DecimalFormat(FORMAT_TEMPLATE);
                ele.put(key, decimalFormat.format(Double.valueOf(value)));
            }
        }
        return SysBeanUtils.mapToBean(clazz, ele);
    }

    /**
     * 自定义排序
     */
    private class OrderedProperties extends Properties {

        private static final long serialVersionUID = -4627607243846121965L;

        private final LinkedHashSet<Object> keys = new LinkedHashSet<>();

        @Override
        public Enumeration<Object> keys() {
            return Collections.<Object>enumeration(keys);
        }

        @Override
        public Object put(Object key, Object value) {
            keys.add(key);
            return super.put(key, value);
        }

        @Override
        public Set<Object> keySet() {
            return keys;
        }

        @Override
        public Set<String> stringPropertyNames() {
            Set<String> set = new LinkedHashSet<>();
            for (Object key : this.keys) {
                set.add((String) key);
            }
            return set;
        }
    }

    /**
     * 配置参数过滤转换
     *
     * @param key
     * @return
     */
    private String convertValue(String key) {
        if (StringUtils.isNotBlank(fimsConfigBean.getConvertOutputKeyword()) && StringUtils.isNotBlank(key)) {
            String[] keywords = fimsConfigBean.getConvertOutputKeyword().split(COMMA);
            for (String word : keywords) {
                if (key.contains(word)) {
                    return ASTERISK_SIX;
                }
            }
        }
        return environment.getProperty(key);
    }
}
