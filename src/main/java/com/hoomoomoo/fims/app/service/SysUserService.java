package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysUserModel;
import com.hoomoomoo.fims.app.model.SysUserQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;

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

    /**
     * 查询页面初始化相关数据
     *
     * @return
     */
    ResultData selectInitData();

    /**
     * 分页查询用户信息
     *
     * @param sysUserQueryModel
     * @return
     */
    FimsPage<SysUserModel> selectPage(SysUserQueryModel sysUserQueryModel);

    /**
     * 删除用户信息
     *
     * @param userIds
     * @return
     */
    ResultData delete(String userIds);

    /**
     * 查询用户信息
     *
     * @param userId
     * @return
     */
    ResultData selectOne(String userId, Boolean isTranslate);

    /**
     * 保存用户信息
     *
     * @param sysUserModel
     * @return
     */
    ResultData save(SysUserModel sysUserModel);

    /**
     * 校验userCode是否存在
     *
     * @param sysUserQueryModel
     * @return
     */
    ResultData checkUserCode(SysUserQueryModel sysUserQueryModel);

    /**
     * 重置用户密码
     *
     * @param userIds
     * @return
     */
    ResultData reset(String userIds);

    /**
     * 修改用户密码
     *
     * @param password
     * @return
     */
    ResultData changPassword(String password);

}
