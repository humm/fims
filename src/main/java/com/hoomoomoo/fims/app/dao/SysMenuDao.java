package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hoomoomoo
 * @description 菜单信息dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2019/09/29
 */

@Mapper
public interface SysMenuDao {

    /**
     * 查询菜单树
     *
     * @return
     */
    List<SysMenuTreeModel> selectMenuTree(SysMenuTreeQueryModel sysMenuTreeQueryModel);

    /**
     * 查询数据权限
     *
     * @param sysMenuTreeQueryModel
     * @return
     */
    String selectDataAuthority(SysMenuTreeQueryModel sysMenuTreeQueryModel);

    /**
     * 查询数据权限
     *
     * @param sysMenuTreeQueryModel
     * @return
     */
    Boolean selectDataAuthorityByUserId(SysMenuTreeQueryModel sysMenuTreeQueryModel);

    /**
     * 查询菜单信息
     *
     * @param sysMenuQueryModel
     * @return
     */
    List<SysMenuModel> selectMenu(SysMenuQueryModel sysMenuQueryModel);

    /**
     * 查询所有菜单信息
     *
     * @param sysMenuQueryModel
     * @return
     */
    List<SysMenuModel> selectAllMenu(SysMenuQueryModel sysMenuQueryModel);

    /**
     * 查询所有菜单
     *
     * @return
     */
    List<SysMenuModel> selectUrlMenu();

    /**
     * 更新菜单信息
     *
     * @param sysMenuModel
     */
    void updateMenu(SysMenuModel sysMenuModel);

    /**
     * 查询菜单权限
     *
     * @param sysMenuQueryModel
     * @return
     */
    Boolean selectMenuAuthority(SysMenuQueryModel sysMenuQueryModel);

}
