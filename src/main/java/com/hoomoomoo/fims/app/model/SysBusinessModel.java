package com.hoomoomoo.fims.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author humm23693
 * @description 业务数据实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/10/27
 */

@Data
public class SysBusinessModel {


    @ApiModelProperty(value="标题", required = false)
    private String title;

    @ApiModelProperty(value="收入数据", required = false)
    private List<SysItem> income           = new ArrayList<>();

    @ApiModelProperty(value="送礼数据", required = false)
    private List<SysItem> giftSend         = new ArrayList<>();

    @ApiModelProperty(value="收礼数据", required = false)
    private List<SysItem> giftReceive      = new ArrayList<>();

}
