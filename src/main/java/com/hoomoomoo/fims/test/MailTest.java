package com.hoomoomoo.fims.test;

import com.hoomoomoo.fims.app.dto.MailDto;
import com.hoomoomoo.fims.app.service.common.SystemService;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @author humm23693
 * @description 邮件测试
 * @package com.hoomoomoo.fims.test
 * @date 2019/08/03
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    private static final Logger logger = LoggerFactory.getLogger(MailTest.class);

    @Autowired
    private SystemService systemService;

    @Test
    public void testSend() {
        MailDto mailDto = new MailDto();
        mailDto.setSubject("测试邮件主题");
        mailDto.setText("测试邮件内容");
        systemService.sendMail(mailDto);
    }

    @Test
    public void testReceive() {
        List<Message> messageList = systemService.receiveMail(new MailDto("测试邮件主题"));
        List<MailDto> mailTDtos = systemService.handleMailData(messageList);
        for(MailDto dto : mailTDtos){
            logger.info(dto.toString());
        }
    }
}
