package com.hoomoomoo.fims.app.controller;

import com.hoomoomoo.fims.app.config.bean.SystemConfigBean;
import com.hoomoomoo.fims.app.util.SysSessionUtils;
import com.hoomoomoo.fims.app.util.SysUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import static com.hoomoomoo.fims.app.consts.BusinessConst.REQUEST_URL;
import static com.hoomoomoo.fims.app.consts.BusinessConst.USER_NAME;


/**
 * @author humm23693
 * @description 系统控制类
 * @package com.hoomoomoo.fims.app.controller
 * @date 2019/08/09
 */

@Controller
@RequestMapping("/")
public class SysSystemController {

    @Autowired
    private SystemConfigBean systemConfigBean;

    /**
     * 跳转首页
     *
     * @return
     */
    @ApiOperation("跳转首页")
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute(USER_NAME, SysSessionUtils.getSession().getUserName());
        return "index";
    }

    /**
     * 跳转首页子页面
     *
     * @return
     */
    @ApiOperation("跳转首页子页面")
    @RequestMapping(value = "home/console", method = RequestMethod.GET)
    public String console(ModelMap modelMap, HttpServletRequest httpServletRequest) {
        modelMap.addAttribute(REQUEST_URL, SysUtils.getConnectUrl(httpServletRequest, systemConfigBean.getAppName()));
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

    /**
     * 跳转icon页面
     *
     * @return
     */
    @ApiOperation("跳转icon页面")
    @RequestMapping(value = "icon/view/list", method = RequestMethod.GET)
    public String icon() {
        return "icon/list";
    }

}
