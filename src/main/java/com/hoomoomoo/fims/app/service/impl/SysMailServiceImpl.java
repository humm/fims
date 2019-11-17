package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.config.bean.MailConfigBean;
import com.hoomoomoo.fims.app.model.MailMessageModel;
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
    public List<MailMessageModel> receiveMail(MailModel mailModel) {
        LogUtils.functionStart(logger, LOG_BUSINESS_TYPE_MAIL_RECEIVE);
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties);
        session.setDebug(mailConfigBean.getDebug());
        List<MailMessageModel> subjectMessage = new ArrayList<>();
        try {
            Store store = session.getStore(mailConfigBean.getReceiveProtocol());
            store.connect(mailConfigBean.getReceiveHost(), mailConfigBean.getReceiveUsername(), mailConfigBean.getReceivePassword());
            Folder folder = store.getFolder(mailConfigBean.getReceiveFolder());
            // 设置对邮件帐户的访问权限可以读写
            folder.open(Folder.READ_WRITE);
            Message[] messages = folder.getMessages();
            for (Message message : messages) {
                if (StringUtils.isBlank(mailModel.getSubject()) || mailModel.getSubject().equals(message.getSubject())) {
                    MailMessageModel mailMessageModel = new MailMessageModel();
                    mailMessageModel.setMailId(mailConfigBean.getReceiveHost() + MINUS + ((IMAPFolder) folder).getUID(message));
                    mailMessageModel.setMessage(message);
                    subjectMessage.add(mailMessageModel);
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
    public List<MailModel> handleMailData(List<MailMessageModel> messages) {
        LogUtils.functionStart(logger, LOG_BUSINESS_TYPE_MAIL_HANDLE);
        List<MailModel> mailDtoList = new ArrayList<>();
        for (MailMessageModel mailMessageModel : messages) {
            String mailId = mailMessageModel.getMailId();
            Message message = mailMessageModel.getMessage();
            MimeMessage mimeMessage = (MimeMessage) message;
            try {
                Object content = mimeMessage.getContent();
                Address address = mimeMessage.getSender();
                // 获取发件人信息
                if (content instanceof String) {
                    MailModel mailModel = new MailModel();
                    mailModel.setSubject(mimeMessage.getSubject());
                    mailModel.setText(String.valueOf(content));
                    mailModel.setMailId(mailId);
                    mailDtoList.add(mailModel);
                } else if (content instanceof MimeMultipart) {
                    MimeMultipart mimeMultipart = (MimeMultipart) mimeMessage.getContent();
                    inner:
                    for (int i = 0; i < mimeMultipart.getCount(); i++) {
                        BodyPart bodyPart = mimeMultipart.getBodyPart(i);
                        if (bodyPart.isMimeType(TEXT_PLAIN)) {
                            // 文本内容
                            MailModel mailModel = new MailModel();
                            mailModel.setSubject(mimeMessage.getSubject());
                            mailModel.setText(String.valueOf(content));
                            mailModel.setMailId(mailId);
                            // 设置发件人信息
                            mailDtoList.add(mailModel);
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
