package com.hoomoomoo.fims.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 首页权限实体类
 * com.hoomoomoo.fims.app.model
 * @date 2020/03/22
 */

@Data
public class SysAuthModel {

    @ApiModelProperty(value="收入信息", required = false)
    private Boolean income;

    @ApiModelProperty(value="随礼信息", required = false)
    private Boolean gift;

}
