package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysUserModel;
import com.hoomoomoo.fims.app.model.common.ResultData;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;

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
     * @param sysUserModel
     * @return
     */
    ResultData login(HttpServletRequest request, SysUserModel sysUserModel);

    /**
     * 登出
     * @param request
     * @param sessionStatus
     * @param sysUserModel
     * @return
     */
    ResultData logout(HttpServletRequest request, SessionStatus sessionStatus, SysUserModel sysUserModel);
}
