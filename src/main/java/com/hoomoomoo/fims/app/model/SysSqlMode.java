package com.hoomoomoo.fims.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 配置sql实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/11/23
 */

@Data
public class SysSqlMode {

    @ApiModelProperty(value="id", required = false)
    private String id;

    @ApiModelProperty(value="模式", required = false)
    private String mode;

    @ApiModelProperty(value="sql值", required = false)
    private String value;

    public SysSqlMode() {
    }

    public SysSqlMode(String id, String mode, String value) {
        this.id = id;
        this.mode = mode;
        this.value = value;
    }
}
