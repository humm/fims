package com.hoomoomoo.fims.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 菜单信息查询实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/09/29
 */

@Data
public class SysMenuQueryModel {

    @ApiModelProperty(value="父级菜单ID", required = false)
    private String parentId;

    @ApiModelProperty(value="菜单ID", required = false)
    private String menuId;

    @ApiModelProperty(value="是否父级菜单", required = false)
    private Boolean isParentId;

    @ApiModelProperty(value="用户ID", required = false)
    private String userId;

    @ApiModelProperty(value="用户代码", required = false)
    private String userCode;
}
