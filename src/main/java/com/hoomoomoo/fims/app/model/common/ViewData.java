package com.hoomoomoo.fims.app.model.common;

import com.hoomoomoo.fims.app.model.SysDictionaryModel;
import com.hoomoomoo.fims.app.model.SysMenuTreeModel;
import com.hoomoomoo.fims.app.model.SysRoleModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hoomoomoo
 * @description 页面返回实体类
 * @package com.hoomoomoo.fims.app.model.common
 * @date 2019/08/23
 */

@Data
public class ViewData {

    @ApiModelProperty(value="查询条件", required = false)
    private Map<String, List<SysDictionaryModel>> condition               = new HashMap<>(16);

    @ApiModelProperty(value="智能填充", required = false)
    private Boolean mindFill;

    @ApiModelProperty(value="最近一次操作类型", required = false)
    private LastType lastType;

    @ApiModelProperty(value="登录用户信息", required = false)
    private SessionBean sessionBean;

    @ApiModelProperty(value="页面类型", required = false)
    private String viewType;

    @ApiModelProperty(value="角色信息", required = false)
    private List<SysRoleModel> roleList;

    @ApiModelProperty(value="菜单信息", required = false)
    private List<SysMenuTreeModel> menuList;

    @ApiModelProperty(value="数据权限", required = false)
    private String dataAuthority;

}
