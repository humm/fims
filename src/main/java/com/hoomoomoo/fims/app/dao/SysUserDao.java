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

    /**
     * 分页查询用户信息
     *
     * @param sysUserQueryModel
     * @return
     */
    List<SysUserModel> selectPage(SysUserQueryModel sysUserQueryModel);
    
    /**
     * 删除用户信息
     *
     * @param sysUserModelList
     * @return
     */
    void delete(List<SysUserModel> sysUserModelList);

    /**
     * 查询用户信息
     *
     * @param sysUserQueryModel
     * @return
     */
    SysUserModel selectOne(SysUserQueryModel sysUserQueryModel);

    /**
     * 保存用户信息
     *
     * @param sysUserModel
     */
    void save(SysUserModel sysUserModel);


    /**
     * 校验userCode是否存在
     *
     * @param sysUserQueryModel
     * @return
     */
    Boolean checkUserCode(SysUserQueryModel sysUserQueryModel);
}
