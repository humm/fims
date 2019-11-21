package com.hoomoomoo.fims.test;

import com.hoomoomoo.fims.FimsApplication;
import com.hoomoomoo.fims.app.model.MailModel;
import com.hoomoomoo.fims.app.service.SysMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @author humm23693
 * @description 邮件测试
 * @package com.hoomoomoo.fims.test
 * @date 2019/08/03
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FimsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MailConfigTest {

    private static final Logger logger = LoggerFactory.getLogger(MailConfigTest.class);

    @Autowired
    private SysMailService sysMailService;

    @Test
    public void send() {
        MailModel mailModel = new MailModel();
        mailModel.setTo("10806623@qq.com");
        mailModel.setSubject("测试邮件主题");
        mailModel.setContent("测试邮件内容");
        sysMailService.sendMail(mailModel);
    }

    @Test
    public void receive() {
        MailModel mailModel = new MailModel();
        mailModel.setSubject("*");
        List<MailModel> mailTDtos = sysMailService.receiveMail(mailModel);
        for(MailModel dto : mailTDtos){
            logger.info(dto.toString());
        }
    }
}
