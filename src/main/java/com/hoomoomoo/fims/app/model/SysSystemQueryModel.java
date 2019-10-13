package com.hoomoomoo.fims.app.model;

import com.hoomoomoo.fims.app.model.common.QueryBaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 系统级别公用查询实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/10/13
 */

@Data
public class SysSystemQueryModel extends QueryBaseModel {

    @ApiModelProperty(value="菜单ID", required = false)
    private String menuId;

    @ApiModelProperty(value="用户ID", required = false)
    private String userId;
}
