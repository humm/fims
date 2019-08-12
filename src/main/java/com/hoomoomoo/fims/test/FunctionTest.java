package com.hoomoomoo.fims.test;

import com.hoomoomoo.fims.app.dto.SysSalaryDto;
import com.hoomoomoo.fims.app.service.SystemService;
import com.hoomoomoo.fims.app.util.BeanMapUtils;
import com.hoomoomoo.fims.app.util.LogUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(FunctionTest.class);

    @Autowired
    private SystemService systemService;

    @Test
    public void testGetBusinessSerialNo(){
        systemService.getBusinessSerialNo("user");
    }

    @Test
    public void testLog(){
        LogUtils.controllerStart(logger, null, null);
    }

    @Test
    public void testTransferData(){
        SysSalaryDto sysSalaryDto = new SysSalaryDto();
        sysSalaryDto.setSalaryAmount(12345D);
        sysSalaryDto = (SysSalaryDto)systemService.transferData(sysSalaryDto);
        logger.info(sysSalaryDto.toString());
    }
}
