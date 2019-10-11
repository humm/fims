package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author humm23693
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
     * 查询菜单信息
     *
     * @param sysMenuQueryModel
     * @return
     */
    List<SysMenuModel> selectMenu(SysMenuQueryModel sysMenuQueryModel);
}
