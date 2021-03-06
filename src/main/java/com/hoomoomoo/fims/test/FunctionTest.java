package com.hoomoomoo.fims.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hoomoomoo.fims.FimsStarter;
import com.hoomoomoo.fims.app.model.SysIncomeModel;
import com.hoomoomoo.fims.app.model.SysMailModel;
import com.hoomoomoo.fims.app.service.SysDictionaryService;
import com.hoomoomoo.fims.app.service.SysParameterService;
import com.hoomoomoo.fims.app.service.SysSystemService;
import com.hoomoomoo.fims.app.util.SysDateUtils;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hoomoomoo.fims.app.consts.BusinessConst.BACKUP_DMP_SUFFIX;
import static com.hoomoomoo.fims.app.consts.BusinessConst.UNDERLINE;
import static com.hoomoomoo.fims.app.consts.ParameterConst.BACKUP_LOCATION;


/**
 * @author hoomoomoo
 * @description 功能测试
 * @package com.hoomoomoo.fims.test
 * @date 2019/08/08
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FimsStarter.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FunctionTest {

    private static final Logger logger = LoggerFactory.getLogger(FunctionTest.class);

    @Autowired
    private SysSystemService sysSystemService;

    @Autowired
    private SysDictionaryService sysDictionaryService;

    @Autowired
    private SysParameterService sysParameterService;

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
    public void batch(){
        List<String> fundInfoList = new ArrayList<>();
        for (int i=1; i<=120012; i++){
            fundInfoList.add("" + i);
        }
        int size = fundInfoList.size();
        int batchNum = 500;
        if (size <= batchNum) {
            // 一次性插入
        } else {
            // 分批插入
            int times = size / batchNum;
            int surplus = size % batchNum;
            if (surplus != 0) {
                times++;
            }
            for (int i = 1; i <= times; i++) {
                List<String> item = null;
                if (i == times && surplus != 0) {
                    item = fundInfoList.subList((i - 1) * batchNum,
                            ((i - 1) * batchNum) + surplus);
                } else {
                    item = fundInfoList.subList((i - 1) * batchNum, i * batchNum);
                }
                logger.info( "" + item.get(item.size()-1));
            }
        }
    }

}
