package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysRoleModel;
import com.hoomoomoo.fims.app.model.SysRoleQueryModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author humm23693
 * @description 角色信息dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2019/09/27
 */

@Mapper
public interface SysRoleDao {

    /**
     * 查询角色信息
     *
     * @param sysRoleQueryModel
     * @return
     */
    List<SysRoleModel> selectSysRole(SysRoleQueryModel sysRoleQueryModel);

    /**
     * 分页查询角色信息
     *
     * @param sysRoleQueryModel
     * @return
     */
    List<SysRoleModel> selectPage(SysRoleQueryModel sysRoleQueryModel);

    /**
     * 删除角色信息
     *
     * @param sysRoleModelList
     * @return
     */
    void delete(List<SysRoleModel> sysRoleModelList);

    /**
     * 查询角色信息
     *
     * @param sysRoleQueryModel
     * @return
     */
    SysRoleModel selectOne(SysRoleQueryModel sysRoleQueryModel);

    /**
     * 保存角色信息
     *
     * @param sysRoleModel
     */
    void save(SysRoleModel sysRoleModel);


    /**
     * 校验roleCode是否存在
     *
     * @param sysRoleQueryModel
     * @return
     */
    Boolean checkRoleCode(SysRoleQueryModel sysRoleQueryModel);
}
