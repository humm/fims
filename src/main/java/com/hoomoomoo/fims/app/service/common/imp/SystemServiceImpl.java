package com.hoomoomoo.fims.app.service.common.imp;

import com.hoomoomoo.fims.FimsApplication;
import com.hoomoomoo.fims.app.config.bean.FimsConfigBean;
import com.hoomoomoo.fims.app.config.bean.MailConfigBean;
import com.hoomoomoo.fims.app.dto.MailDto;
import com.hoomoomoo.fims.app.service.common.SystemService;
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
import javax.mail.search.OrTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static com.hoomoomoo.fims.app.consts.SystemConst.APPLICATION_PROPERTIES;
import static com.hoomoomoo.fims.app.consts.TipConst.*;
import static com.hoomoomoo.fims.app.consts.businessConst.*;

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

    /**
     * 控制台输出应用配置参数
     */
    @Override
    public void outputConfigParameter() {
        Properties properties = new OrderedProperties();
        if (fimsConfigBean.getConsoleOutput()) {
            logger.info(String.format(TIP_TEMPLATE, PARAMETER_START));
        }
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
            if (fimsConfigBean.getConsoleOutput()) {
                logger.info(singleProperty.toString());
            }
        }
        if (fimsConfigBean.getConsoleOutput()) {
            logger.info(String.format(TIP_TEMPLATE, PARAMETER_END));
        }


    }

    /**
     * 发送邮件
     *
     * @param mailDto
     * @return
     */
    @Override
    public Boolean sendMail(MailDto mailDto) {
        boolean isSend = true;
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setTo(mailConfigBean.getTo());
            mimeMessageHelper.setFrom(mailConfigBean.getFrom());
            mimeMessage.setSubject(mailDto.getSubject());
            mimeMessageHelper.setText(mailDto.getText(), true);
            javaMailSender.send(mimeMessage);
            logger.info(MAIL_SEND_SUCCESS);
        } catch (MessagingException e) {
            isSend = false;
            logger.error(MAIL_SEND_EXCEPTION, e);
        }
        return isSend;
    }

    /**
     * 接收指定主题邮件
     *
     * @param mailDto
     * @return
     */
    @Override
    public List<Message> receiveMail(MailDto mailDto) {
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties);
        session.setDebug(mailConfigBean.getDebug());
        List<Message> subjectMessage = new ArrayList<>();
        try {
            Store store = session.getStore(mailConfigBean.getReceiveProtocol());
            store.connect(mailConfigBean.getReceiveHost(), mailConfigBean.getReceiveUsername(), mailConfigBean.getReceivePassword());
            Folder folder = store.getFolder(mailConfigBean.getReceiveFolder());
            // 设置对邮件帐户的访问权限可以读写
            folder.open(Folder.READ_WRITE);
            Message[] messages = folder.getMessages();
            if(StringUtils.isBlank(mailDto.getSubject())){
                subjectMessage = Arrays.asList(messages);
            }else{
                for(Message message : messages){
                    if(mailDto.getSubject().equals(message.getSubject())){
                        subjectMessage.add(message);
                        // 邮件状态置为已读
                        message.setFlag(Flags.Flag.SEEN, true);
                    }
                }
            }
            logger.info(MAIL_RECEIVE_SUCCESS);
        } catch (Exception e) {
            logger.error(MAIL_RECEIVE_EXCEPTION, e);
        }
        return subjectMessage;
    }

    /**
     * 处理邮件内容
     *
     * @param messages
     */
    @Override
    public List<MailDto> handleMailData(List<Message> messages) {
        List<MailDto> mailDtoList = new ArrayList<>();
        for (Message message : messages) {
            MimeMessage mimeMessage = (MimeMessage) message;
            try {
                Object content = mimeMessage.getContent();
                if (content instanceof String) {
                    mailDtoList.add(new MailDto(mimeMessage.getSubject(), String.valueOf(content)));
                } else if (content instanceof MimeMultipart) {
                    MimeMultipart mimeMultipart = (MimeMultipart) mimeMessage.getContent();
                    for (int i = 0; i < mimeMultipart.getCount(); i++) {
                        BodyPart bodyPart = mimeMultipart.getBodyPart(i);
                        if (bodyPart.isMimeType(TEXT_PLAIN)) {
                            mailDtoList.add(new MailDto(mimeMessage.getSubject(), String.valueOf(bodyPart.getContent())));
                        } else if (bodyPart.isMimeType(TEXT_HTML)) {
                            logger.info(MAIL_CONTENT_HTML);
                        } else if (bodyPart.isMimeType(MULTIPART)) {
                            logger.info(MAIL_CONTENT_MULTIPART);
                        }
                    }
                } else {
                    logger.error(MAIL_CONTENT_NOT_SUPPORT);
                }
            } catch (Exception e) {
                logger.error(MAIL_CONTENT_HANDLE_EXCEPTION, e);
            }
        }
        logger.info(MAIL_CONTENT_HANDLE_SUCCESS);
        return mailDtoList;
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
        if (StringUtils.isNotBlank(fimsConfigBean.getConsoleOutputKeyword()) && StringUtils.isNotBlank(key)) {
            String[] keywords = fimsConfigBean.getConsoleOutputKeyword().split(SEMICOLON);
            for (String word : keywords) {
                if (key.contains(word)) {
                    return ASTERISK_SIX;
                }
            }
        }
        return environment.getProperty(key);
    }
}
