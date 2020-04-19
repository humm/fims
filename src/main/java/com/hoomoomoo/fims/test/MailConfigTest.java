package com.hoomoomoo.fims.test;

import com.hoomoomoo.fims.FimsStarter;
import com.hoomoomoo.fims.app.model.SysInterfaceRequestModel;
import com.hoomoomoo.fims.app.model.SysMailModel;
import com.hoomoomoo.fims.app.model.common.BaseModel;
import com.hoomoomoo.fims.app.service.SysInterfaceService;
import com.hoomoomoo.fims.app.service.SysMailService;
import com.hoomoomoo.fims.app.util.SysCommonUtils;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @author hoomoomoo
 * @description 邮件测试
 * @package com.hoomoomoo.fims.test
 * @date 2019/08/03
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FimsStarter.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MailConfigTest {

    private static final Logger logger = LoggerFactory.getLogger(MailConfigTest.class);

    @Autowired
    private SysMailService sysMailService;

    @Autowired
    private SysInterfaceService sysInterfaceService;

    @Test
    public void send() {
    }

    @Test
    public void receive() {
    }

    @Test
    public void handleMailRequest() {
    }
}
