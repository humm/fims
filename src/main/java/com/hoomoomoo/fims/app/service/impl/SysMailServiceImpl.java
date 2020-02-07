package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.config.bean.MailConfigBean;
import com.hoomoomoo.fims.app.model.SysMailModel;
import com.hoomoomoo.fims.app.service.SysMailService;
import com.hoomoomoo.fims.app.util.SysLogUtils;
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
import static com.hoomoomoo.fims.app.consts.CueConst.*;

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
    public Boolean sendMail(SysMailModel mailModel) {
        SysLogUtils.functionStart(logger, LOG_BUSINESS_TYPE_MAIL_SEND);
        boolean isSend = true;
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setTo(mailModel.getTo());
            mimeMessageHelper.setFrom(mailConfigBean.getFrom());
            mimeMessage.setSubject(mailModel.getSubject());
            mimeMessageHelper.setText(mailModel.getContent(), true);
            javaMailSender.send(mimeMessage);
            SysLogUtils.success(logger, LOG_BUSINESS_TYPE_MAIL_SEND);
        } catch (MessagingException e) {
            isSend = false;
            SysLogUtils.exception(logger, LOG_BUSINESS_TYPE_MAIL_SEND, e);
        }
        SysLogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_MAIL_SEND);
        return isSend;
    }

    /**
     * 接收指定主题邮件
     *
     * @param mailModel
     * @return
     */
    @Override
    public List<SysMailModel> receiveMail(SysMailModel mailModel) {
        SysLogUtils.functionStart(logger, LOG_BUSINESS_TYPE_MAIL_RECEIVE);
        List<SysMailModel> mailModelList = new ArrayList<>();
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties);
        session.setDebug(mailConfigBean.getDebug());
        try {
            Store store = session.getStore(mailConfigBean.getReceiveProtocol());
            store.connect(mailConfigBean.getReceiveHost(), mailConfigBean.getReceiveUsername(), mailConfigBean.getReceivePassword());
            Folder folder = store.getFolder(mailConfigBean.getReceiveFolder());
            // 设置对邮件帐户的访问权限可以读写
            folder.open(Folder.READ_WRITE);
            Message[] messages = folder.getMessages();
            for (Message message : messages) {
                if (ASTERISK.equals(mailModel.getSubject()) || mailModel.getSubject().equals(message.getSubject())) {
                    // 邮件状态置为已读
                    message.setFlag(Flags.Flag.SEEN, true);
                    // 处理邮件内容
                    Long uuid = ((IMAPFolder) folder).getUID(message);
                    // todo 邮件ID判断 大于配置邮件ID数据返回
                    String mailId = mailConfigBean.getReceiveHost() + MINUS + uuid;
                    mailModelList.add(handleMailData(mailId, message));
                }
            }
            SysLogUtils.success(logger, LOG_BUSINESS_TYPE_MAIL_RECEIVE);
        } catch (Exception e) {
            SysLogUtils.exception(logger, LOG_BUSINESS_TYPE_MAIL_RECEIVE, e);
        }
        SysLogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_MAIL_RECEIVE);
        return mailModelList;
    }

    /**
     * 处理邮件内容
     *
     * @param mailId
     * @param message
     */
    private SysMailModel handleMailData(String mailId, Message message) {
        SysLogUtils.functionStart(logger, LOG_BUSINESS_TYPE_MAIL_HANDLE);
        MimeMessage mimeMessage = (MimeMessage) message;
        SysMailModel mailModel = new SysMailModel();
        try {
            // 获取发件人地址
            String address = mimeMessage.getSender().toString();
            if (StringUtils.isNotBlank(address)) {
                int indexStart = address.lastIndexOf(LESS_THAN);
                int indexEnd = address.lastIndexOf(GREATER_THAN);
                if (indexEnd >= indexStart) {
                    mailModel.setTo(address.substring(indexStart + 1, indexEnd));
                }
            }
            // 获取邮件内容
            Object content = mimeMessage.getContent();
            if (content instanceof String) {
                mailModel.setSubject(mimeMessage.getSubject());
                mailModel.setContent(String.valueOf(content));
                mailModel.setMailId(mailId);
            } else if (content instanceof MimeMultipart) {
                MimeMultipart mimeMultipart = (MimeMultipart) mimeMessage.getContent();
                inner:
                for (int i = 0; i < mimeMultipart.getCount(); i++) {
                    BodyPart bodyPart = mimeMultipart.getBodyPart(i);
                    if (bodyPart.isMimeType(TEXT_PLAIN)) {
                        // 文本内容
                        mailModel.setSubject(mimeMessage.getSubject());
                        mailModel.setContent(String.valueOf(bodyPart.getContent()));
                        mailModel.setMailId(mailId);
                        break inner;
                    } else if (bodyPart.isMimeType(TEXT_HTML)) {
                        // 超文本内容
                    } else if (bodyPart.isMimeType(MULTIPART)) {
                        // 附件
                    }
                }
            } else {
                SysLogUtils.fail(logger, LOG_BUSINESS_TYPE_MAIL_HANDLE, MAIL_CONTENT_NOT_SUPPORT);
            }
        } catch (Exception e) {
            SysLogUtils.exception(logger, LOG_BUSINESS_TYPE_MAIL_HANDLE, e);
        }
        SysLogUtils.functionEnd(logger, LOG_BUSINESS_TYPE_MAIL_HANDLE);
        return mailModel;
    }

}
