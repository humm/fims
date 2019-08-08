package com.hoomoomoo.fims.test;

import com.hoomoomoo.fims.app.service.common.SystemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author humm23693
 * @description 功能测试
 * @package com.hoomoomoo.fims.test
 * @date 2019/08/08
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class FunctionTest {

    @Autowired
    private SystemService systemService;

    @Test
    public void testBusinessId(){
        systemService.getBusinessId("user");
    }
}
