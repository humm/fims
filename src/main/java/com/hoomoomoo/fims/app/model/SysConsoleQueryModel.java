package com.hoomoomoo.fims.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 首页数据查询实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/10/27
 */

@Data
public class SysConsoleQueryModel {

    @ApiModelProperty(value="用户ID", required = false)
    private String userId;

    @ApiModelProperty(value="年度开始时间", required = false)
    private String yearStartDate;

    @ApiModelProperty(value="用户名称", required = false)
    private String userName;
}