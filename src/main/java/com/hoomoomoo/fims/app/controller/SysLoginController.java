package com.hoomoomoo.fims.app.controller;

import com.hoomoomoo.fims.app.model.SysUserModel;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.service.SysLoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author humm23693
 * @description 用户登录控制类
 * @package com.hoomoomoo.fims.app.controller
 * @date 2019/10/14
 */

@Controller
@RequestMapping("/")
public class SysLoginController {

    @Autowired
    private SysLoginService sysLoginService;


    /**
     * 跳转登入页面
     *
     * @return
     */
    @ApiOperation("跳转登入页面")
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String viewLogin() {
        return "user/login";
    }

    /**
     * 登入
     *
     * @param request
     * @param sysUserModel
     * @return
     */
    @ApiOperation("用户登入")
    @RequestMapping(value = "user/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultData login(HttpServletRequest request, SysUserModel sysUserModel) {
        return sysLoginService.login(request, sysUserModel);
    }

    /**
     * 登出
     *
     * @param sysUserModel
     * @return
     */
    @ApiOperation("用户登出")
    @RequestMapping(value = "user/logout", method = RequestMethod.POST)
    @ResponseBody
    public ResultData logout(SysUserModel sysUserModel) {
        return null;
    }
}
