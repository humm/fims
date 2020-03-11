package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.config.WebSocketServerConfig;
import com.hoomoomoo.fims.app.dao.SysConfigDao;
import com.hoomoomoo.fims.app.dao.SysConsoleDao;
import com.hoomoomoo.fims.app.dao.SysMenuDao;
import com.hoomoomoo.fims.app.dao.SysWeChatUserDao;
import com.hoomoomoo.fims.app.model.*;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.model.common.SessionBean;
import com.hoomoomoo.fims.app.service.SysConsoleService;
import com.hoomoomoo.fims.app.service.SysNoticeService;
import com.hoomoomoo.fims.app.service.SysParameterService;
import com.hoomoomoo.fims.app.util.SysBeanUtils;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import com.hoomoomoo.fims.app.util.SysSessionUtils;
import com.hoomoomoo.fims.app.util.SysCommonUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.hoomoomoo.fims.app.config.RunDataConfig.DICTIONARY_CONDITION;
import static com.hoomoomoo.fims.app.consts.BusinessConst.*;
import static com.hoomoomoo.fims.app.consts.DictionaryConst.D000;
import static com.hoomoomoo.fims.app.consts.DictionaryConst.D012;
import static com.hoomoomoo.fims.app.consts.ParameterConst.*;
import static com.hoomoomoo.fims.app.consts.CueConst.*;

/**
 * @author humm23693
 * @description 首页信息服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/10/27
 */

@Service
@Transactional
public class SysConsoleServiceImpl implements SysConsoleService {

    private static final Logger logger = LoggerFactory.getLogger(SysConsoleServiceImpl.class);

    @Autowired
    private SysParameterService sysParameterService;

    @Autowired
    private SysConsoleDao sysConsoleDao;

    @Autowired
    private SysMenuDao sysMenuDao;

    @Autowired
    private SysNoticeService sysNoticeService;

    @Autowired
    private SysConfigDao sysConfigDao;

    @Autowired
    private SysWeChatUserDao sysWeChatUserDao;

    /**
     * 查询首页信息
     *
     * @return
     */
    @Override
    public ResultData selectConsoleData(HttpServletRequest httpServletRequest) {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_CONSOLE, LOG_OPERATE_TYPE_SELECT);
        SysConsoleModel sysConsoleModel = new SysConsoleModel();
        SessionBean sessionBean = SysSessionUtils.getSession();
        // 设置统计开始时间
        String yearStartDate = sysParameterService.getParameterString(YEAR_START_DATE);
        SysConsoleQueryModel sysConsoleQueryModel = new SysConsoleQueryModel();
        sysConsoleQueryModel.setYearStartDate(yearStartDate);
        // 查询未读消息通知
        sysConsoleModel.setReadNum(selectReadNoticeNum());
        // 查询模块配置信息
        sysConsoleModel.setSysConfig(selectConfigModule());
        Map<String, String> menu = getMenuInfo();
        if (sessionBean != null) {
            String loginUserId = sessionBean.getUserId();
            sysConsoleQueryModel.setUserName(FAMILY_TITLE);
            if (sessionBean.getIsAdminData()) {
                // 查询业务统计信息
                setBusinessInfo(sysConsoleModel, sysConsoleQueryModel, menu);
                // 查询登入统计信息
                sysConsoleQueryModel.setUserId(sessionBean.getUserId());
                setLoginInfo(sysConsoleModel, sysConsoleQueryModel, menu);
                // 获取用户信息
                List<SysDictionaryModel> userList = DICTIONARY_CONDITION.get(loginUserId).get(D000);
                if (CollectionUtils.isNotEmpty(userList)) {
                    for (SysDictionaryModel sysDictionaryModel : userList) {
                        sysConsoleQueryModel.setUserId(sysDictionaryModel.getDictionaryItem());
                        sysConsoleQueryModel.setUserName(SysCommonUtils.getDictionaryCaption(sysDictionaryModel.getDictionaryCaption()));
                        // 查询业务统计信息
                        setBusinessInfo(sysConsoleModel, sysConsoleQueryModel, menu);
                    }
                }
            } else {
                sysConsoleQueryModel.setUserId(sessionBean.getUserId());
                sysConsoleQueryModel.setUserName(sessionBean.getUserName());
                // 查询业务统计信息
                setBusinessInfo(sysConsoleModel, sysConsoleQueryModel, menu);
                // 查询登入统计信息
                setLoginInfo(sysConsoleModel, sysConsoleQueryModel, menu);
            }
        }
        // 设置版本信息
        setVersionInfo(sysConsoleModel, menu);
        // 设置提示信息
        setTipsInfo(sysConsoleModel, sysConsoleQueryModel, menu);
        // 设置注册用户信息
        setRegisterInfo(sysConsoleModel, menu);
        // 首页用户数据处理
        if (sysConsoleModel.getUser() != null && sysConsoleModel.getUser().size() == 2) {
            // 系统当前只有一个用户
            sysConsoleModel.getUser().remove(0);
        }
        SysLogUtils.parameter(logger, sessionBean == null ? new SessionBean() : sessionBean);
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_CONSOLE, LOG_OPERATE_TYPE_SELECT);
        return new ResultData(true, SELECT_SUCCESS, sysConsoleModel);
    }

    /**
     * 设置提示信息
     * @param sysConsoleModel
     * @param sysConsoleQueryModel
     * @param menu
     */
    private void setTipsInfo(SysConsoleModel sysConsoleModel, SysConsoleQueryModel sysConsoleQueryModel, Map<String,
            String> menu) {
        setTipsValue(sysConsoleModel, CONSOLE_VERSION_TIPS, CONSOLE_VERSION_TIPS, null);
        setTipsValue(sysConsoleModel, CONSOLE_YEAR_START_DATE, sysConsoleQueryModel.getYearStartDate(), menu.get(MENU_ID_PARAMETER));
    }

    /**
     * 设置版本信息
     *
     * @param sysConsoleModel
     * @param menu
     */
    private void setVersionInfo(SysConsoleModel sysConsoleModel, Map<String, String> menu) {
        setVersionValue(sysConsoleModel, CONSOLE_VERSION_TITLE, CONSOLE_VERSION_TITLE, null);
        setVersionValue(sysConsoleModel, CONSOLE_VERSION_CODE, sysParameterService.getParameterString(VERSION),
                menu.get(MENU_ID_VERSION));
    }

    /**
     * 设置注册信息
     *
     * @param sysConsoleModel
     * @param menu
     */
    private void setRegisterInfo(SysConsoleModel sysConsoleModel, Map<String, String> menu) {
        SessionBean sessionBean = SysSessionUtils.getSession();
        if (sessionBean != null) {
            setRegisterValue(sysConsoleModel, CONSOLE_REGISTER_TIPS, CONSOLE_REGISTER_TIPS, null);
            // 设置注册用户数
            setRegisterValue(sysConsoleModel, CONSOLE_REGISTER_NUM,
                    String.valueOf(DICTIONARY_CONDITION.get(sessionBean.getUserId()).get(D000).size()),
                    menu.get(MENU_ID_USER));
            SysWeChatUserQueryModel sysWeChatUserQueryModel = new SysWeChatUserQueryModel();
            if (!sessionBean.getIsAdminData()) {
                sysWeChatUserQueryModel.setUserId(sessionBean.getUserId());
            }
            // 设置微信注册用户数
            setRegisterValue(sysConsoleModel, CONSOLE_REGISTER_WECHAT_NUM,
                    String.valueOf(sysWeChatUserDao.selectList(sysWeChatUserQueryModel).size()),
                    null);

        }
    }

    /**
     * 设置登入统计信息
     *
     * @param sysConsoleModel
     * @param sysConsoleQueryModel
     */
    private void setLoginInfo(SysConsoleModel sysConsoleModel, SysConsoleQueryModel sysConsoleQueryModel, Map<String,
            String> menu) {
        // 设置标题
        setLoginLogValue(sysConsoleModel, CONSOLE_LOGIN_TITLE, CONSOLE_LOGIN_TITLE, null, false);
        // 查询最后一次登入时间
        String console = sysConsoleDao.selectLoginLast(sysConsoleQueryModel);
        setLoginLogValue(sysConsoleModel, CONSOLE_LOGIN_LAST_DATE, console, menu.get(MENU_ID_LOGIN), false);
        // 查询本月登入次数
        console = sysConsoleDao.selectLoginMonthTime(sysConsoleQueryModel);
        setLoginLogValue(sysConsoleModel, CONSOLE_LOGIN_MONTH_TIME, console, menu.get(MENU_ID_LOGIN), true);
        // 查询本年登入次数
        console = sysConsoleDao.selectLoginYearTime(sysConsoleQueryModel);
        setLoginLogValue(sysConsoleModel, CONSOLE_LOGIN_YEAR_TIME, console, menu.get(MENU_ID_LOGIN), true);
        // 查询总登入次数
        console = sysConsoleDao.selectLoginTotalTime(sysConsoleQueryModel);
        setLoginLogValue(sysConsoleModel, CONSOLE_LOGIN_TOTAL_TIME, console, menu.get(MENU_ID_LOGIN), true);
    }

    /**
     * 设置业务数据
     *
     * @param sysConsoleModel
     * @param sysConsoleQueryModel
     * @param menu
     */
    private void setBusinessInfo(SysConsoleModel sysConsoleModel, SysConsoleQueryModel sysConsoleQueryModel,
                                 Map<String, String> menu) {
        String incomeMonth = STR_0;
        SysBusinessModel sysBusinessModel = new SysBusinessModel();
        sysConsoleModel.getUser().add(sysBusinessModel);
        sysBusinessModel.setTitle(sysConsoleQueryModel.getUserName());
        // 查询最近一笔收入
        String console = sysConsoleDao.selectIncomeLast(sysConsoleQueryModel);
        setIncomeBusinessValue(sysBusinessModel, CONSOLE_INCOME_LAST, console, menu.get(MENU_ID_INCOME));
        // 查询月度收入
        console = sysConsoleDao.selectIncomeMonth(sysConsoleQueryModel);
        incomeMonth = formatValue(console, true, false);
        setIncomeBusinessValue(sysBusinessModel, CONSOLE_INCOME_MONTH, console, menu.get(MENU_ID_INCOME));
        // 设置同比收入
        console = sysConsoleDao.selectIncomePreviousYearMonth(sysConsoleQueryModel);
        double incomeRatio =
                Double.valueOf(incomeMonth) - Double.valueOf(formatValue(console, true, false));
        setIncomeBusinessValue(sysBusinessModel, CONSOLE_INCOME_RATIO, String.valueOf(incomeRatio), menu.get(MENU_ID_INCOME));
        // 设置环比收入
        console = sysConsoleDao.selectIncomePreviousMonth(sysConsoleQueryModel);
        double incomeChainRatio =
                Double.valueOf(incomeMonth) - Double.valueOf(formatValue(console, true, false));
        setIncomeBusinessValue(sysBusinessModel, CONSOLE_INCOME_CHAIN_RATIO, String.valueOf(incomeChainRatio), menu.get(MENU_ID_INCOME));
        // 查询年度收入
        console = sysConsoleDao.selectIncomeYear(sysConsoleQueryModel);
        setIncomeBusinessValue(sysBusinessModel, CONSOLE_INCOME_YEAR, console, menu.get(MENU_ID_INCOME));
        // 查询总收入
        console = sysConsoleDao.selectIncomeTotal(sysConsoleQueryModel);
        setIncomeBusinessValue(sysBusinessModel, CONSOLE_INCOME_TOTAL, console, menu.get(MENU_ID_INCOME));
        // 查询最近一笔送礼
        console = sysConsoleDao.selectGiftSendLast(sysConsoleQueryModel);
        setGiftSendBusinessValue(sysBusinessModel, CONSOLE_GIFT_SEND_LAST, console, menu.get(MENU_ID_GIFT));
        // 查询年度送礼
        console = sysConsoleDao.selectGiftSendYear(sysConsoleQueryModel);
        setGiftSendBusinessValue(sysBusinessModel, CONSOLE_GIFT_SEND_YEAR, console, menu.get(MENU_ID_GIFT));
        // 查询总送礼
        console = sysConsoleDao.selectGiftSendTotal(sysConsoleQueryModel);
        setGiftSendBusinessValue(sysBusinessModel, CONSOLE_GIFT_SEND_TOTAL, console, menu.get(MENU_ID_GIFT));
        // 查询最近一笔收礼
        console = sysConsoleDao.selectGiftReceiveLast(sysConsoleQueryModel);
        setGiftReceiveBusinessValue(sysBusinessModel, CONSOLE_GIFT_RECEIVE_LAST, console, menu.get(MENU_ID_GIFT));
        // 查询年度送礼
        console = sysConsoleDao.selectGiftReceiveYear(sysConsoleQueryModel);
        setGiftReceiveBusinessValue(sysBusinessModel, CONSOLE_GIFT_RECEIVE_YEAR, console, menu.get(MENU_ID_GIFT));
        // 查询总送礼
        console = sysConsoleDao.selectGiftReceiveTotal(sysConsoleQueryModel);
        setGiftReceiveBusinessValue(sysBusinessModel, CONSOLE_GIFT_RECEIVE_TOTAL, console, menu.get(MENU_ID_GIFT));
    }

    /**
     * 获取菜单信息
     *
     * @return
     */
    private Map getMenuInfo() {
        Map<String, String> menu = new HashMap(16);
        List<SysMenuModel> sysMenuModelist = sysMenuDao.selectUrlMenu();
        if (CollectionUtils.isNotEmpty(sysMenuModelist)) {
            for (SysMenuModel sysMenuModel : sysMenuModelist) {
                menu.put(sysMenuModel.getMenuId(), sysMenuModel.getMenuUrl());
            }
        }
        return menu;
    }

    /**
     * 设置收入信息值
     *
     * @param sysBusinessModel
     * @param title
     * @param value
     * @param url
     */
    private void setIncomeBusinessValue(SysBusinessModel sysBusinessModel, String title, String value, String url) {
        sysBusinessModel.getIncome().add(new SysItemModel(title, formatValue(value, true, true), url));
    }

    /**
     * 设置送礼信息值
     *
     * @param sysBusinessModel
     * @param title
     * @param value
     * @param url
     */
    private void setGiftSendBusinessValue(SysBusinessModel sysBusinessModel, String title, String value,
                                          String url) {
        sysBusinessModel.getGiftSend().add(new SysItemModel(title, formatValue(value, true, true), url));
    }

    /**
     * 设置收礼信息值
     *
     * @param sysBusinessModel
     * @param title
     * @param value
     * @param url
     */
    private void setGiftReceiveBusinessValue(SysBusinessModel sysBusinessModel, String title, String value,
                                             String url) {
        sysBusinessModel.getGiftReceive().add(new SysItemModel(title, formatValue(value, true, true), url));
    }

    /**
     * 设置登入信息值
     *
     * @param sysConsoleModel
     * @param title
     * @param value
     * @param url
     * @param isZero
     */
    private void setLoginLogValue(SysConsoleModel sysConsoleModel, String title, String value, String url,
                                  boolean isZero) {
        sysConsoleModel.getLogin().add(new SysItemModel(title, formatValue(value, isZero, false), url));
    }

    /**
     * 设置版本信息值
     *
     * @param sysConsoleModel
     * @param title
     * @param value
     * @param url
     */
    private void setVersionValue(SysConsoleModel sysConsoleModel, String title, String value, String url) {
        sysConsoleModel.getVersion().add(new SysItemModel(title, formatValue(value, false, false), url));
    }

    /**
     * 设置注册信息值
     *
     * @param sysConsoleModel
     * @param title
     * @param value
     * @param url
     */
    private void setRegisterValue(SysConsoleModel sysConsoleModel, String title, String value, String url) {
        sysConsoleModel.getRegister().add(new SysItemModel(title, formatValue(value, false, false), url));
    }

    /**
     * 设置提示信息值
     *
     * @param sysConsoleModel
     * @param title
     * @param value
     * @param url
     */
    private void setTipsValue(SysConsoleModel sysConsoleModel, String title, String value, String url) {
        sysConsoleModel.getTips().add(new SysItemModel(title, formatValue(value, false, false), url));
    }

    /**
     * 数值格式化
     *
     * @param value
     * @param isZero
     * @return
     */
    private String formatValue(String value, boolean isZero, boolean isFormat) {
        if (StringUtils.isBlank(value)) {
            return isZero ? STR_0 : STR_EMPTY;
        }
        // 金额格式化
        if (isFormat) {
            return SysCommonUtils.formatValue(value);
        }
        return value;
    }



    /**
     * 查询未读通知消息
     *
     * @return
     */
    private String selectReadNoticeNum() {
        boolean messageTip = sysParameterService.getParameterBoolean(MESSAGE_TIP);
        if (!messageTip) {
            return STR_0;
        }
        SysNoticeQueryModel sysNoticeQueryModel = new SysNoticeQueryModel();
        sysNoticeQueryModel.setPage(1);
        sysNoticeQueryModel.setLimit(10);
        sysNoticeQueryModel.setReadStatus(new StringBuffer(D012).append(MINUS).append(STR_1).toString());
        FimsPage fimsPage = sysNoticeService.selectPage(sysNoticeQueryModel);
        return String.valueOf(fimsPage.getCount());
    }

    /**
     * 查询配置模块信息
     *
     */
    @Override
    public SysModuleModel selectConfigModule(){
        SysConfigQueryModel sysConfigQueryModel = new SysConfigQueryModel();
        sysConfigQueryModel.setModuleGroupCode(MODULE_CONSOLE);
        List<SysConfigModel> sysConfigModelList = sysConfigDao.selectModule(sysConfigQueryModel);
        if (CollectionUtils.isNotEmpty(sysConfigModelList)) {
            Map module = new HashMap(16);
            for (SysConfigModel sysConfigModel : sysConfigModelList) {
                module.put(sysConfigModel.getModuleCode(), sysConfigModel.getModuleStatus());
            }
            return (SysModuleModel)SysBeanUtils.mapToBean(SysModuleModel.class, module);
        }
        return new SysModuleModel();
    }

    /**
     * 保存模块信息
     *
     * @param sysModuleModel
     * @return
     */
    @Override
    public ResultData save(SysModuleModel sysModuleModel) {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_CONSOLE, LOG_OPERATE_TYPE_UPDATE);
        Map<String, Object> module = SysBeanUtils.beanToMap(sysModuleModel);
        SysConfigModel sysConfigModel = new SysConfigModel();
        Iterator<String> iterator = module.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            sysConfigModel.setModuleGroupCode(MODULE_CONSOLE);
            sysConfigModel.setModuleCode(key);
            String status = SWITCH_ON.equals(String.valueOf(module.get(key))) ? STR_1 : STR_0;
            sysConfigModel.setModuleStatus(status);
            sysConfigDao.save(sysConfigModel);
        }
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_CONSOLE, LOG_OPERATE_TYPE_UPDATE);
        WebSocketServerConfig.sendMessageInfo(WEBSOCKET_TOPIC_NAME_CONSOLE, LOG_BUSINESS_TYPE_CONSOLE);
        return new ResultData(true, UPDATE_SUCCESS, null);

    }
}
