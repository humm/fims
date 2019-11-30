package com.hoomoomoo.fims.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 数据表字段信息查询实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/11/29
 */

@Data
public class SysTableQueryModel {

    @ApiModelProperty(value="数据表名称", required = false)
    private String tableName;

    @ApiModelProperty(value="数据表字段", required = false)
    private String tableColumn;

    @ApiModelProperty(value="数据表排序", required = false)
    private String tableOrder;
}
