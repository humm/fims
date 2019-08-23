package com.hoomoomoo.fims.test;

import com.hoomoomoo.fims.FimsApplication;
import com.hoomoomoo.fims.app.model.SysIncomeModel;
import com.hoomoomoo.fims.app.service.SysDictionaryService;
import com.hoomoomoo.fims.app.service.SystemService;
import com.hoomoomoo.fims.app.util.LogUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.hoomoomoo.fims.app.consts.BusinessConst.UNDERLINE;


/**
 * @author humm23693
 * @description 功能测试
 * @package com.hoomoomoo.fims.test
 * @date 2019/08/08
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FimsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FunctionTest {

    private static final Logger logger = LoggerFactory.getLogger(FunctionTest.class);

    @Autowired
    private SystemService systemService;

    @Autowired
    private SysDictionaryService sysDictionaryService;

    @Test
    public void getBusinessSerialNo(){
        systemService.getBusinessSerialNo("user");
    }

    @Test
    public void log(){
        LogUtils.controllerStart(logger, null, null);
    }

    @Test
    public void transferData(){
        SysIncomeModel sysIncomeModel = new SysIncomeModel();
        sysIncomeModel.setIncomeAmount(12345D);
        sysIncomeModel = (SysIncomeModel)systemService.transferData(sysIncomeModel);
        logger.info(sysIncomeModel.toString());
    }

    @Test
    public void upperCase(){
        String arg = "workSalaryIdDay";
        StringBuffer convert = new StringBuffer();
        for(int i=0; i<arg.length(); i++){
            char single = arg.charAt(i);
            if(i != 0 && Character.isUpperCase(single)){
                convert.append(UNDERLINE).append(single);
            }else{
                convert.append(single);
            }
        }
        logger.info(convert.toString().toLowerCase());
    }

    @Test
    public void loadSysDictionaryCondition(){
        systemService.loadSysDictionaryCondition();
    }

}
