package com.hoomoomoo.fims.app.controller;

import com.hoomoomoo.fims.app.model.SysUserModel;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.service.SysLoginService;
import com.hoomoomoo.fims.app.service.SysParameterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;

import static com.hoomoomoo.fims.app.consts.ParameterConst.VERSION;

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

    @Autowired
    private SysParameterService sysParameterService;


    /**
     * 跳转登入页面
     *
     * @return
     */
    @ApiOperation("跳转登入页面")
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String viewLogin(ModelMap modelMap) {
        modelMap.addAttribute(VERSION, sysParameterService.getParameterString(VERSION));
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
     * @param request
     * @param sessionStatus
     * @return
     */
    @ApiOperation("用户登出")
    @RequestMapping(value = "user/logout", method = RequestMethod.POST)
    @ResponseBody
    public ResultData logout(HttpServletRequest request, SessionStatus sessionStatus) {
        return sysLoginService.logout(request, sessionStatus);
    }
}
