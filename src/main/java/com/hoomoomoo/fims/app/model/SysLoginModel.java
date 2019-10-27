package com.hoomoomoo.fims.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author humm23693
 * @description 登入日志数据实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/10/27
 */

@Data
public class SysLoginModel {

    @ApiModelProperty(value="最近一次登入时间", required = false)
    private String loginLastDate;

    @ApiModelProperty(value="本月登入次数", required = false)
    private String loginMonthTime;

    @ApiModelProperty(value="本年登入次数", required = false)
    private String loginYearTime;

    @ApiModelProperty(value="总登入次数", required = false)
    private String loginTotalTime;

    @ApiModelProperty(value="结果数据", required = false)
    private String consoleData;
}
