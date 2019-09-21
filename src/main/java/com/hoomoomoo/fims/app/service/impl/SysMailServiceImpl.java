package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.config.bean.MailConfigBean;
import com.hoomoomoo.fims.app.model.MailModel;
import com.hoomoomoo.fims.app.service.SysMailService;
import com.hoomoomoo.fims.app.util.LogUtils;
import com.sun.mail.imap.IMAPFolder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.*;

import static com.hoomoomoo.fims.app.consts.BusinessConst.*;
import static com.hoomoomoo.fims.app.consts.TipConst.*;
import static com.hoomoomoo.fims.app.consts.TipConst.LOG_BUSINESS_TYPE_MAIL_HANDLE;

/**
 * @author humm23693
 * @description 邮件服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/09/20
 */

@Service
@Transactional
public class SysMailServiceImpl implements SysMailService {

    private static final Logger logger = LoggerFactory.getLogger(SysMailServiceImpl.class);

    @Autowired
    private MailConfigBean mailConfigBean;

    @Autowired
    private JavaMailSender javaMailSender;

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

}
