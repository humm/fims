package com.hoomoomoo.fims.app.model;

import com.hoomoomoo.fims.app.model.common.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 接口信息实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/11/24
 */

@Data
public class SysInterfaceModel extends BaseModel {

    @ApiModelProperty(value="业务日期", required = false)
    private String date;

    @ApiModelProperty(value="业务金额", required = false)
    private String amount;

    @ApiModelProperty(value="业务类型", required = false)
    private String type;

    @ApiModelProperty(value="业务子类型", required = false)
    private String subType;

    @ApiModelProperty(value="用户", required = false)
    private String user;

    @ApiModelProperty(value="目标", required = false)
    private String target;

    @ApiModelProperty(value="备注", required = false)
    private String memo;
}
