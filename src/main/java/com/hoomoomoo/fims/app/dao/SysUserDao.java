package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysUserModel;
import com.hoomoomoo.fims.app.model.SysUserQueryModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author humm23693
 * @description 用户信息dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2019/08/11
 */

@Mapper
public interface SysUserDao {

    /**
     * 查询用户信息
     *
     * @param sysUserQueryModel
     * @return
     */
    List<SysUserModel> selectSysUser(SysUserQueryModel sysUserQueryModel);
}
