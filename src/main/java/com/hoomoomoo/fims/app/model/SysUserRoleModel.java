package com.hoomoomoo.fims.app.model;

import com.hoomoomoo.fims.app.model.common.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author hoomoomoo
 * @description 用户角色信息实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/09/28
 */

@Data
public class SysUserRoleModel extends BaseModel {

    @ApiModelProperty(value="用户角色ID", required = false)
    private String userRoleId;

    @ApiModelProperty(value="用户ID", required = false)
    private String userId;

    @ApiModelProperty(value="角色ID", required = false)
    private String roleId;
}
