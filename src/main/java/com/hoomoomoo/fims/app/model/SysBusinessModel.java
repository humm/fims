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
public class SysBusinessModel {

    @ApiModelProperty(value="最近一笔收入", required = false)
    private String incomeLast;

    @ApiModelProperty(value="收入环比增长", required = false)
    private String incomeChainRatio;

    @ApiModelProperty(value="收入同比增长", required = false)
    private String incomeRatio;

    @ApiModelProperty(value="月度收入", required = false)
    private String incomeMonth;

    @ApiModelProperty(value="年度收入", required = false)
    private String incomeYear;

    @ApiModelProperty(value="总收入", required = false)
    private String incomeTotal;

    @ApiModelProperty(value="统计开始时间", required = false)
    private String yearStartDate;

    @ApiModelProperty(value="最近一笔送礼", required = false)
    private String giftSendLast;

    @ApiModelProperty(value="年度送礼", required = false)
    private String giftSendYear;

    @ApiModelProperty(value="总送礼", required = false)
    private String giftSendTotal;

    @ApiModelProperty(value="最近一笔收礼", required = false)
    private String giftReceiveLast;

    @ApiModelProperty(value="年度收礼", required = false)
    private String giftReceiveYear;

    @ApiModelProperty(value="总收礼", required = false)
    private String giftReceiveTotal;

    @ApiModelProperty(value="结果数据", required = false)
    private String consoleData;

    @ApiModelProperty(value="用户名称", required = false)
    private String userName;

}
