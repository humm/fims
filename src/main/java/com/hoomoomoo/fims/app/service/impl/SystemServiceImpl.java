package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.FimsApplication;
import com.hoomoomoo.fims.app.config.bean.FimsConfigBean;
import com.hoomoomoo.fims.app.config.bean.MailConfigBean;
import com.hoomoomoo.fims.app.dao.SysDictionaryDao;
import com.hoomoomoo.fims.app.dao.SysUserDao;
import com.hoomoomoo.fims.app.dao.SystemDao;
import com.hoomoomoo.fims.app.model.*;
import com.hoomoomoo.fims.app.model.common.BaseModel;
import com.hoomoomoo.fims.app.service.SystemService;
import com.hoomoomoo.fims.app.util.BeanMapUtils;
import com.hoomoomoo.fims.app.util.DateUtils;
import com.hoomoomoo.fims.app.util.LogUtils;
import com.sun.mail.imap.IMAPFolder;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.hoomoomoo.fims.app.config.RunData.BUSINESS_SERIAL_NO;
import static com.hoomoomoo.fims.app.consts.SystemConst.APPLICATION_PROPERTIES;
import static com.hoomoomoo.fims.app.consts.TipConst.*;
import static com.hoomoomoo.fims.app.consts.BusinessConst.*;

/**
 * @author humm23693
 * @description 系统级别公用服务
 * @package com.hoomoomoo.fims.app.service.common.imp
 * @date 2019/08/04
 */

@Service
public class SystemServiceImpl implements SystemService {

    private static final Logger logger = LoggerFactory.getLogger(SystemServiceImpl.class);

    @Autowired
    private FimsConfigBean fimsConfigBean;

    @Autowired
    private Environment environment;

    @Autowired
    private MailConfigBean mailConfigBean;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SystemDao systemDao;

    @Autowired
    private SysDictionaryDao sysDictionaryDao;

    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 控制台输出应用配置参数
     */
    @Override
    public void outputConfigParameter() {
        if (!fimsConfigBean.getConsoleOutput()){
            return;
        }
        Properties properties = new OrderedProperties();
        LogUtils.configStart(logger, LOG_BUSINESS_TYPE_PARAMETER_CONFIG);
        try {
            InputStream inputStream =
                    FimsApplication.class.getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES.split(COLON)[1]);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
            if (!isIgnore && fimsConfigBean.getConsoleOutput()) {
                LogUtils.info(logger, singleProperty);
            }
        }
        LogUtils.configEnd(logger, LOG_BUSINESS_TYPE_PARAMETER_CONFIG);
    }

    /**
     * 发送邮件
     *
     * @param mailModel
     * @return
     */
    @Override
    public Boolean sendMail(MailModel mailModel) {
        LogUtils.functionStart(logger, LOG_BUSINESS_TYPE_MAIL_SEND);
        boolean isSend = true;
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setTo(mailConfigBean.getTo());
            mimeMessageHelper.setFrom(mailConfigBean.getFrom());
            mimeMessage.setSubject(mailModel.getSubject());
            mimeMessageHelper.setText(mailModel.getText(), true);
            javaMailSender.send(mimeMessage);
            LogUtils.success(logger, LOG_BUSINESS_TYPE_MAIL_SEND);
        } catch (MessagingException e) {
            isSend = false;
            LogUtils.exception(logger, LOG_BUSINESS_TYPE_MAIL_SEND, e);
        }
        LogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_MAIL_SEND);
        return isSend;
    }

    /**
     * 接收指定主题邮件
     *
     * @param mailModel
     * @return
     */
    @Override
    public List<Map<String, Message>> receiveMail(MailModel mailModel) {
        LogUtils.functionStart(logger, LOG_BUSINESS_TYPE_MAIL_RECEIVE);
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties);
        session.setDebug(mailConfigBean.getDebug());
        List<Map<String, Message>> subjectMessage = new ArrayList<>();
        try {
            Store store = session.getStore(mailConfigBean.getReceiveProtocol());
            store.connect(mailConfigBean.getReceiveHost(), mailConfigBean.getReceiveUsername(), mailConfigBean.getReceivePassword());
            Folder folder = store.getFolder(mailConfigBean.getReceiveFolder());
            // 设置对邮件帐户的访问权限可以读写
            folder.open(Folder.READ_WRITE);
            Message[] messages = folder.getMessages();
            for (Message message : messages) {
                if (StringUtils.isBlank(mailModel.getSubject()) || mailModel.getSubject().equals(message.getSubject())) {
                    Map msg = new HashMap(1);
                    String mailId = mailConfigBean.getReceiveHost() + MINUS + ((IMAPFolder) folder).getUID(message);
                    msg.put(mailId, message);
                    subjectMessage.add(msg);
                    // 邮件状态置为已读
                    message.setFlag(Flags.Flag.SEEN, true);
                }
            }
            LogUtils.success(logger, LOG_BUSINESS_TYPE_MAIL_RECEIVE);
        } catch (Exception e) {
            LogUtils.exception(logger, LOG_BUSINESS_TYPE_MAIL_RECEIVE, e);
        }
        LogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_MAIL_RECEIVE);
        return subjectMessage;
    }

    /**
     * 处理邮件内容
     *
     * @param messages
     */
    @Override
    public List<MailModel> handleMailData(List<Map<String, Message>> messages) {
        LogUtils.functionStart(logger, LOG_BUSINESS_TYPE_MAIL_HANDLE);
        List<MailModel> mailDtoList = new ArrayList<>();
        for (Map<String, Message> messageMap : messages) {
            Iterator<String> iterator = messageMap.keySet().iterator();
            String mailId = STR_0;
            Message message = null;
            while (iterator.hasNext()) {
                mailId = iterator.next();
                message = messageMap.get(mailId);
                break;
            }
            MimeMessage mimeMessage = (MimeMessage) message;
            try {
                Object content = mimeMessage.getContent();
                if (content instanceof String) {
                    mailDtoList.add(new MailModel(mimeMessage.getSubject(), String.valueOf(content), mailId));
                } else if (content instanceof MimeMultipart) {
                    MimeMultipart mimeMultipart = (MimeMultipart) mimeMessage.getContent();
                    inner:
                    for (int i = 0; i < mimeMultipart.getCount(); i++) {
                        BodyPart bodyPart = mimeMultipart.getBodyPart(i);
                        if (bodyPart.isMimeType(TEXT_PLAIN)) {
                            // 文本内容
                            mailDtoList.add(new MailModel(mimeMessage.getSubject(),
                                    String.valueOf(bodyPart.getContent()), mailId));
                            break inner;
                        } else if (bodyPart.isMimeType(TEXT_HTML)) {
                            // 超文本内容
                        } else if (bodyPart.isMimeType(MULTIPART)) {
                            // 附件
                        }
                    }
                } else {
                    LogUtils.fail(logger, LOG_BUSINESS_TYPE_MAIL_HANDLE, MAIL_CONTENT_NOT_SUPPORT);
                }
            } catch (Exception e) {
                LogUtils.exception(logger, LOG_BUSINESS_TYPE_MAIL_HANDLE, e);
            }
        }
        LogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_MAIL_HANDLE);
        return mailDtoList;
    }

    /**
     * 加载业务ID
     *
     * @return
     */
    @Override
    public void loadBusinessId() {
        LogUtils.functionStart(logger, LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_LOAD);
        List<String> businessIdList = systemDao.loadBusinessId();
        if (CollectionUtils.isNotEmpty(businessIdList)) {
            for (String businessId : businessIdList) {
                String businessKey = businessId.split(MINUS)[0];
                String businessValue = businessId.split(MINUS)[1];
                BUSINESS_SERIAL_NO.put(businessKey, businessValue);
            }
        }
        LogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_LOAD);
    }

    /**
     * 根据业务类型获取业务ID
     *
     * @param businessType
     * @return
     */
    @Override
    public String getBusinessSerialNo(String businessType) {
        LogUtils.functionStart(logger, LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_GET);
        if (StringUtils.isBlank(businessType)) {
            LogUtils.fail(logger, LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_GET, BUSINESS_TYPE_NOT_EMPTY);
            LogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_GET);
            return null;
        }
        String businessId = null;
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            businessId = BUSINESS_SERIAL_NO.get(businessType);
            // 业务ID不存在 设置默认值
            if (StringUtils.isBlank(businessId)) {
                businessId = DateUtils.yyyyMMdd() + BUSINESS_ID_DEFAULT;
            } else {
                String businessDate = businessId.substring(0, 8);
                String businessNo = businessId.substring(8);
                // 业务ID时间不是当前时间 设置默认值
                if (!DateUtils.yyyyMMdd().equals(businessDate)) {
                    businessId = DateUtils.yyyyMMdd() + BUSINESS_ID_DEFAULT;
                } else {
                    // 去除多去的0 获取序列号
                    while (businessNo.startsWith(STR_0)) {
                        businessNo = businessNo.substring(1);
                    }
                    // 序列号加1
                    businessNo = String.valueOf(Long.valueOf(businessNo) + 1);
                    // 序列号补0
                    while (businessNo.length() < 6) {
                        businessNo = STR_0 + businessNo;
                    }
                    businessId = businessDate + businessNo;
                }
            }
            // 更新内存数据序列号值
            BUSINESS_SERIAL_NO.put(businessType, businessId);
            LogUtils.success(logger, LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_GET, businessType + MINUS + businessId);
        } catch (Exception e) {
            LogUtils.exception(logger, LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_GET, e);
        } finally {
            lock.unlock();
        }
        LogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_GET);
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
        LogUtils.functionStart(logger, LOG_BUSINESS_TYPE_DICTIONARY_TRANSFER);
        if (CollectionUtils.isNotEmpty(list)) {
            // 本次查询缓存数据
            Map dictionaryCache = new HashMap(16);
            List<Map<String, Object>> mapList = BeanMapUtils.beanToMap(list);
            for (Map<String, Object> ele : mapList) {
                transfer(dictionaryCache, ele);
            }
            try {
                list = BeanMapUtils.mapToBean(mapList, clazz);
            } catch (Exception e) {
                LogUtils.exception(logger, LOG_BUSINESS_TYPE_DICTIONARY_TRANSFER, e);
            }
        }
        LogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_DICTIONARY_TRANSFER);
        return list;
    }

    /**
     * 字典转义
     *
     * @param baseModel
     * @return
     */
    @Override
    public BaseModel transferData(BaseModel baseModel) {
        LogUtils.functionStart(logger, LOG_BUSINESS_TYPE_DICTIONARY_TRANSFER);
        if(baseModel != null){
            Map dictionaryCache = new HashMap(16);
            Map ele = BeanMapUtils.beanToMap(baseModel);
            transfer(dictionaryCache, ele);
            baseModel = BeanMapUtils.mapToBean(ele, baseModel);
        }
        LogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_DICTIONARY_TRANSFER);
        return baseModel;
    }

    /**
     * 转义
     * @param dictionaryCache
     * @param ele
     */
    private void transfer(Map dictionaryCache, Map ele){
        Iterator<String> iterator = ele.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if(ele.get(key) == null){
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
            for(int i=0; i<keys.length; i++){
                if(keys[i].equals(key)){
                    index = i;
                }
            }
            if (index == -1) {
                continue;
            }
            if (dictionaryCache.get(value) != null) {
                ele.put(key, dictionaryCache.get(value));
            }else{
                switch (index) {
                    case 0:
                        // 转义 userId
                        SysUserQueryModel sysUserQueryModel = new SysUserQueryModel();
                        sysUserQueryModel.setUserId(value);
                        List<SysUserModel> sysUserList = sysUserDao.selectSysUser(sysUserQueryModel);
                        if(CollectionUtils.isNotEmpty(sysUserList)){
                            ele.put(key, sysUserList.get(0).getUserName());
                            dictionaryCache.put(value, sysUserList.get(0).getUserName());
                        }
                        break;
                    default:
                        break;
                }
            }
        }
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
     * 数值过滤转换
     *
     * @param key
     * @return
     */
    private String convertValue(String key) {
        if (StringUtils.isNotBlank(fimsConfigBean.getConvertOutputKeyword()) && StringUtils.isNotBlank(key)) {
            String[] keywords = fimsConfigBean.getConvertOutputKeyword().split(SEMICOLON);
            for (String word : keywords) {
                if (key.contains(word)) {
                    return ASTERISK_SIX;
                }
            }
        }
        return environment.getProperty(key);
    }
}
