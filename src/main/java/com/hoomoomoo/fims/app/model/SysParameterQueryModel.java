package com.hoomoomoo.fims.app.model;

import com.hoomoomoo.fims.app.model.common.QueryBaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 参数信息查询实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/10/20
 */

@Data
public class SysParameterQueryModel extends QueryBaseModel {

    @ApiModelProperty(value = "字典代码", required = false)
    private String parameterCode;

    @ApiModelProperty(value = "字典描述", required = false)
    private String parameterCaption;

    @ApiModelProperty(value = "字典值", required = false)
    private String parameterValue;

    @ApiModelProperty(value = "字典排序", required = false)
    private String parameterOrder;
}
