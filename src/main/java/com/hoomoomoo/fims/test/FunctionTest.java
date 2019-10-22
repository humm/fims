package com.hoomoomoo.fims.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hoomoomoo.fims.FimsApplication;
import com.hoomoomoo.fims.app.model.SysIncomeModel;
import com.hoomoomoo.fims.app.service.SysDictionaryService;
import com.hoomoomoo.fims.app.service.SysSystemService;
import com.hoomoomoo.fims.app.util.LogUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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
    private SysSystemService sysSystemService;

    @Autowired
    private SysDictionaryService sysDictionaryService;

    @Test
    public void getBusinessSerialNo(){
        sysSystemService.getBusinessSerialNo("user");
    }

    @Test
    public void log(){
        LogUtils.controllerStart(logger, null, null);
    }

    @Test
    public void transferData(){
        SysIncomeModel sysIncomeModel = new SysIncomeModel();
        sysIncomeModel.setIncomeAmount(12345D);
        sysSystemService.transferData(sysIncomeModel, SysIncomeModel.class);
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
        sysSystemService.loadSysDictionaryCondition();
    }

    @Test
    public void Json(){
        List<Map> list = new ArrayList<>();
        Map ele = new HashMap();
        Map a = new HashMap();
        a.put("12", "456");
        ele.put("websocket", a);
        list.add(ele);
        list.add(ele);
        logger.info(JSONObject.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect));
    }


    @Test
    public void test(){

    }
}
