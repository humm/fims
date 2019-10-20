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
        String head = "<div class='layui-col-md3 layui-col-sm6'>\n" +
                "            <div class='layadmin-contact-box'>\n" +
                "                <div class='layui-col-md8 layadmin-padding-left20 layui-col-sm6'>\n";
        String end ="                </div>\n" +
                "            </div>\n" +
                "        </div>";
        String str = "               <p class='layadmin-textimg'><i class='layui-icon layui-icon-reply-fill'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-set-fill'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-menu-fill'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-search'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-share'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-set-sm'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-engine'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-close'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-close-fill'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-chart-screen'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-star'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-circle-dot'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-chat'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-release'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-list'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-chart'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-ok-circle'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-layim-theme'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-table'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-right'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-left'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-cart-simple'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-face-cry'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-face-smile'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-survey'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-tree'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-upload-circle'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-add-circle'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-download-circle'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-download-circle'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-templeate-1'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-util'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-face-surprised'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-edit'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-speaker'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-down'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-file'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-layouts'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-rate-half'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-add-circle-fine'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-prev-circle'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-read'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-rate-half'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-404'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-carousel'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-help'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-code-circle'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-water'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-username'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-find-fill'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-about'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-location'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-up'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-pause'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-date'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-layim-uploadfile'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-delete'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-play'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-top'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-friends'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-refresh-3'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-ok'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-layer'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-face-smile-fine'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-dollar'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-group'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-layim-download'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-picture-fine'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-link'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-diamond'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-log'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-rate-solid'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-fonts-del'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-unlink'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-fonts-clear'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-triangle-r'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-circle'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-radio'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-align-center'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-align-right'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-align-left'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-loading-1'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-return'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-fonts-strong'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-upload'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-dialogue'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-video'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-headset'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-cellphone-fine'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-add-1'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-face-smile-b'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-fonts-html'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-form'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-cart'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-camera-fill'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-tabs'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-fonts-code'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-fire'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-set'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-fonts-u'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-triangle-d'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-tips'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-picture'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-more-vertical'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-flag'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-loading'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-fonts-i'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-refresh-1'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-rmb'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-home'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-user'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-notice'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-login-weibo'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-voice'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-upload-drag'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-login-qq'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-snowflake'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-file-b'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-template'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-auz'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-console'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-app'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-prev'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-website'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-next'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-component'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-more'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-login-wechat'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-shrink-right'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-spread-left'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-camera'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-note'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-refresh'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-female'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-male'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-password'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-senior'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-theme'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-tread'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-praise'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-star-fill'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-rate'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-template-1'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-vercode'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-cellphone'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-screen-full'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-screen-restore'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-cols'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-export'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-print'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-slider'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-addition'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-subtraction'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-service'></i></p>\n" +
                "                        <p class='layadmin-textimg'><i class='layui-icon layui-icon-transfer'></i></p>";
        String[] sss = str.split("\n");
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i<sss.length; i++){
             buffer.append(head).append(sss[i]);
            buffer.append("<span>").append(sss[i].trim().split(" ")[3].split("'")[0]).append("</span>").append(end);
        }
System.out.println(buffer);
    }
}
