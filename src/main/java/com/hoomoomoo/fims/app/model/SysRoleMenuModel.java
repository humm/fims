package com.hoomoomoo.fims.app.model;

import com.hoomoomoo.fims.app.model.common.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 角色菜单实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/10/08
 */

@Data
public class SysRoleMenuModel extends BaseModel {

    @ApiModelProperty(value="角色菜单ID", required = false)
    private String RoleMenuId;

    @ApiModelProperty(value="菜单ID", required = false)
    private String menuId;

    @ApiModelProperty(value="角色ID", required = false)
    private String roleId;
}
