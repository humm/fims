package com.hoomoomoo.fims.app.controller;

/**
 * @author humm23693
 * @description 修订信息控制类
 * @package com.hoomoomoo.fims.app.controller
 * @date 2019/11/23
 */

import com.hoomoomoo.fims.app.model.SysVersionModel;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.service.SysParameterService;
import com.hoomoomoo.fims.app.service.SysVersionService;
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

import static com.hoomoomoo.fims.app.consts.BusinessConst.BUSINESS_TYPE_VERSION;
import static com.hoomoomoo.fims.app.consts.ParameterConst.VERSION;
import static com.hoomoomoo.fims.app.consts.TipConst.LOG_BUSINESS_TYPE_VERSION;
import static com.hoomoomoo.fims.app.consts.TipConst.LOG_OPERATE_TYPE_SELECT;

@Controller
@RequestMapping("/version")
public class SysVersionController {

    private static final Logger logger = LoggerFactory.getLogger(SysVersionController.class);

    @Autowired
    private SysVersionService sysVersionService;

    @Autowired
    private SysParameterService sysParameterService;

    /**
     * 跳转列表页面
     *
     * @return
     */
    @ApiOperation("跳转列表页面")
    @RequestMapping(value = "view/list", method = RequestMethod.GET)
    public String viewList(ModelMap modelMap) {
        modelMap.addAttribute(BUSINESS_TYPE_VERSION, sysParameterService.getParameterString(VERSION));
        return "version/list";
    }

    /**
     * 查询修订信息
     *
     * @return
     */
    @ApiOperation("查询修订信息")
    @RequestMapping(value = "selectList", method = RequestMethod.GET)
    @ResponseBody
    public ResultData selectList() {
        SysLogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_VERSION, LOG_OPERATE_TYPE_SELECT);
        ResultData resultData = sysVersionService.selectList();
        SysLogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_VERSION, LOG_OPERATE_TYPE_SELECT);
        return resultData;
    }

}