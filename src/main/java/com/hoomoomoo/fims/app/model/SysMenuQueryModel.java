package com.hoomoomoo.fims.app.model;

import com.hoomoomoo.fims.app.model.common.QueryBaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 菜单信息查询实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/09/29
 */

@Data
public class SysMenuQueryModel extends QueryBaseModel {

    @ApiModelProperty(value="菜单ID", required = false)
    private String menuId;

    @ApiModelProperty(value="菜单名称", required = false)
    private String menuTitle;

    @ApiModelProperty(value="菜单图标", required = false)
    private String menuIcon;

    @ApiModelProperty(value="菜单地址", required = false)
    private String menuUrl;

    @ApiModelProperty(value="父级菜单ID", required = false)
    private String parentId;

    @ApiModelProperty(value="菜单排序", required = false)
    private String menuOrder;

    @ApiModelProperty(value="是否启用", required = false)
    private String isEnable;

    @ApiModelProperty(value="菜单类型", required = false)
    private String menuType;
}
