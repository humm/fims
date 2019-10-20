package com.hoomoomoo.fims.app.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author humm23693
 * @description 系统参数控制类
 * @package com.hoomoomoo.fims.app.controller
 * @date 2019/10/20
 */

@Controller
@RequestMapping("/parameter")
public class SysParameterController {

    /**
     * 跳转列表页面
     *
     * @return
     */
    @ApiOperation("跳转列表页面")
    @RequestMapping(value = "view/list", method = RequestMethod.GET)
    public String viewList(ModelMap modelMap,
                           @ApiParam(value = "菜单ID", required = true)
                           @RequestParam String menuId) {
        return "parameter/list";
    }

}
