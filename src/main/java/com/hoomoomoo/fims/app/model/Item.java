package com.hoomoomoo.fims.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 业务数据实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/10/27
 */

@Data
public class Item {

    @ApiModelProperty(value="标题", required = false)
    private String title;

    @ApiModelProperty(value="数据值", required = false)
    private String value;

    @ApiModelProperty(value="链接地址", required = false)
    private String href;

    public Item() {
    }

    public Item(String title, String value, String href) {
        this.title = title;
        this.value = value;
        this.href = href;
    }
}
