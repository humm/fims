package com.hoomoomoo.fims.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hoomoomoo.fims.app.model.common.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author humm23693
 * @description 消息通知实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/09/06
 */

@Data
public class SysNoticeModel extends BaseModel {

    @ApiModelProperty(value="通知ID", required = false)
    private String noticeId;

    @ApiModelProperty(value="用户ID", required = false)
    private String userId;

    @ApiModelProperty(value="业务ID", required = false)
    private String businessId;

    @ApiModelProperty(value="业务类型", required = false)
    private String businessType;

    @ApiModelProperty(value="业务子类型", required = false)
    private String businessSubType;

    @ApiModelProperty(value="业务日期", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date businessDate;

    @ApiModelProperty(value="业务子类型", required = false)
    private Double businessAmount;

    @ApiModelProperty(value="通知状态", required = false)
    private String noticeStatus;

    @ApiModelProperty(value="通知类型", required = false)
    private String noticeType;
}
