package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysUserModel;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.model.common.SessionBean;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author humm23693
 * @description 用户登录服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2019/10/14
 */

public interface SysLoginService {

    /**
     * 用户登录
     *
     * @param request
     * @param response
     * @param sysUserModel
     * @return
     */
    ResultData login(HttpServletRequest request, HttpServletResponse response, SysUserModel sysUserModel);

    /**
     * 登出
     * @param request
     * @param sessionStatus
     * @return
     */
    ResultData logout(HttpServletRequest request, SessionStatus sessionStatus);

    /**
     * 设置sessionBean信息
     *
     * @param sysUserModel
     * @return
     */
    SessionBean setSessionBeanInfo(SysUserModel sysUserModel);
}
