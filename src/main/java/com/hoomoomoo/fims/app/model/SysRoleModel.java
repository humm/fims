package com.hoomoomoo.fims.app.model;

import com.hoomoomoo.fims.app.model.common.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 角色信息实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/09/27
 */

@Data
public class SysRoleModel extends BaseModel {

    @ApiModelProperty(value="角色ID", required = false)
    private String roleId;

    @ApiModelProperty(value="角色代码", required = false)
    private String roleCode;

    @ApiModelProperty(value="角色名称", required = false)
    private String roleName;

    @ApiModelProperty(value="角色备注", required = false)
    private String roleMemo;

    @ApiModelProperty(value="菜单ID", required = false)
    private String menuId;
}
