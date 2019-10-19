package com.hoomoomoo.fims.app.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author humm23693
 * @description 系统控制类
 * @package com.hoomoomoo.fims.app.controller
 * @date 2019/08/09
 */

@Controller
@RequestMapping("/")
public class SysSystemController {

    /**
     * 跳转首页
     *
     * @return
     */
    @ApiOperation("跳转首页")
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /**
     * 跳转首页子页面
     *
     * @return
     */
    @ApiOperation("跳转首页子页面")
    @RequestMapping(value = "home/console", method = RequestMethod.GET)
    public String console() {
        return "home/console";
    }

    /**
     * 跳转404页面
     *
     * @return
     */
    @ApiOperation("跳转404页面")
    @RequestMapping(value = "error/404", method = RequestMethod.GET)
    public String error404() {
        return "error/404";
    }

    /**
     * 跳转error页面
     *
     * @return
     */
    @ApiOperation("跳转error页面")
    @RequestMapping(value = "error/error", method = RequestMethod.GET)
    public String error() {
        return "error/error";
    }

}
