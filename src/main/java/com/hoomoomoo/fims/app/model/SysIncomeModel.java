package com.hoomoomoo.fims.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hoomoomoo.fims.app.model.common.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author humm23693
 * @description 收入信息实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/08/10
 */

@Data
public class SysIncomeModel extends BaseModel {

    @ApiModelProperty(value="收入ID", required = false)
    private String incomeId;

    @ApiModelProperty(value="用户Id", required = false)
    private String userId;

    @ApiModelProperty(value="收入类型", required = false)
    private String incomeType;

    @ApiModelProperty(value="收入类型", required = false)
    private String incomeTypeCode;

    @ApiModelProperty(value="收入日期", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date incomeDate;

    @ApiModelProperty(value="收入来源", required = false)
    private String incomeCompany;

    @ApiModelProperty(value="收入来源", required = false)
    private String incomeCompanyCode;

    @ApiModelProperty(value="收入金额", required = false)
    private Double incomeAmount;

    @ApiModelProperty(value="收入备注", required = false)
    private String incomeMemo;
}
