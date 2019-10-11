package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysMenuModel;
import com.hoomoomoo.fims.app.model.SysMenuTreeModel;
import com.hoomoomoo.fims.app.model.common.ResultData;

import java.util.List;

/**
 * @author humm23693
 * @description 菜单信息服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2019/09/29
 */

public interface SysMenuService {

    /**
     * 查询菜单树
     *
     * @param roleId
     * @param disabled
     * @return
     */
    List<SysMenuTreeModel> selectMenuTree(String disabled, String roleId);

    /**
     * 查询数据权限
     *
     * @param roleId
     * @return
     */
    String selectDataAuthority(String roleId);

    /**
     * 查询菜单信息
     *
     * @return
     */
    ResultData selectMenu();
}
