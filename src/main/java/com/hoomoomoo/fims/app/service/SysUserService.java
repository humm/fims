package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysUserModel;
import com.hoomoomoo.fims.app.model.SysUserQueryModel;

import java.util.List;

/**
 * @author humm23693
 * @description 用户信息服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2019/08/11
 */

public interface SysUserService {

    /**
     * 查询用户信息
     *
     * @param sysUserQueryModel
     * @return
     */
    List<SysUserModel> selectSysUser(SysUserQueryModel sysUserQueryModel);

}
