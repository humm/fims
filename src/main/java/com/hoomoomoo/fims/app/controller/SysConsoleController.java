package com.hoomoomoo.fims.app.controller;

import com.hoomoomoo.fims.app.model.SysModuleModel;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.service.SysConsoleService;
import com.hoomoomoo.fims.app.util.SysBeanUtils;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.util.Iterator;
import java.util.Map;

import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 首页信息控制类
 * @package com.hoomoomoo.fims.app.controller
 * @date 2019/10/27
 */

@Controller
@RequestMapping("console")
public class SysConsoleController {

    private static final Logger logger = LoggerFactory.getLogger(SysConsoleController.class);

    @Autowired
    private SysConsoleService   sysConsoleService;

    @ApiOperation("查询首页信息")
    @RequestMapping(value = "selectConsoleData", method = RequestMethod.GET)
    @ResponseBody
    public ResultData selectConsoleData(HttpServletRequest httpServletRequest) {
        SysLogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_CONSOLE, LOG_OPERATE_TYPE_SELECT);
        ResultData resultData = sysConsoleService.selectConsoleData(httpServletRequest);
        SysLogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_CONSOLE, LOG_OPERATE_TYPE_SELECT);
        return resultData;
    }

    /**
     * 跳转模块编辑页面
     *
     * @return
     */
    @ApiOperation("跳转模块编辑页面")
    @RequestMapping(value = "view/module", method = RequestMethod.GET)
    public String viewModule(ModelMap modelMap) {
        SysModuleModel sysModuleModel = sysConsoleService.selectConfigModule();
        Map module = SysBeanUtils.beanToMap(sysModuleModel);
        Iterator<String> iterator = module.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            modelMap.addAttribute(key, module.get(key));
        }
        return "home/module";
    }

    @ApiOperation("保存模块信息")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public ResultData save(SysModuleModel sysModuleModel) {
        SysLogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_CONSOLE, LOG_OPERATE_TYPE_UPDATE);
        ResultData resultData = sysConsoleService.save(sysModuleModel);
        SysLogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_CONSOLE, LOG_OPERATE_TYPE_UPDATE);
        return resultData;
    }
}
