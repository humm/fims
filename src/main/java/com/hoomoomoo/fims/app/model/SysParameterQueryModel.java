package com.hoomoomoo.fims.app.model;

import com.hoomoomoo.fims.app.model.common.QueryBaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author hoomoomoo
 * @description 参数信息查询实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/10/20
 */

@Data
public class SysParameterQueryModel {

    @ApiModelProperty(value = "参数代码", required = false)
    private String parameterCode;

    @ApiModelProperty(value = "参数描述", required = false)
    private String parameterCaption;

    @ApiModelProperty(value = "参数值", required = false)
    private String parameterValue;

    @ApiModelProperty(value = "参数排序", required = false)
    private String parameterOrder;
}
