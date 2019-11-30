package com.hoomoomoo.fims.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 数据表字段信息实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/11/29
 */

@Data
public class SysTableModel {

    @ApiModelProperty(value="字段代码", required = false)
    private String columnCode;

    @ApiModelProperty(value="字段类型", required = false)
    private String columnType;
}
