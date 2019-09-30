package com.hoomoomoo.fims.app.model.common;

import com.hoomoomoo.fims.app.model.SysDictionaryModel;
import com.hoomoomoo.fims.app.model.SysMenuTreeModel;
import com.hoomoomoo.fims.app.model.SysRoleModel;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author humm23693
 * @description 页面返回实体类
 * @package com.hoomoomoo.fims.app.model.common
 * @date 2019/08/23
 */

@Data
public class ViewData {

    /**
     * 查询条件
     */
    private Map<String, List<SysDictionaryModel>> condition               = new HashMap<>(16);

    /**
     * 智能填充
     */
    private Boolean mindFill;

    /**
     * 最近一次操作类型
     */
    private LastType lastType;

    /**
     * 登录用户信息
     */
    private SessionBean sessionBean;

    /**
     * 页面类型
     */
    private String viewType;

    /**
     * 角色信息
     */
    private List<SysRoleModel> roleList;

    /**
     * 菜单信息
     */
    private List<SysMenuTreeModel> menuList;

    /**
     * 数据权限
     */
    private String dataAuthority;

}
