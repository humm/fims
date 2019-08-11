package com.hoomoomoo.fims.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hoomoomoo.fims.app.dto.common.ModelDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author humm23693
 * @description 收入信息实体类
 * @package com.hoomoomoo.fims.app.dto
 * @date 2019/08/10
 */

@Data
public class SysSalaryDto extends ModelDto {

    @ApiModelProperty(value="收入ID", required = false)
    private String salaryId;

    @ApiModelProperty(value="用户Id", required = false)
    private String userId;

    @ApiModelProperty(value="收入类型", required = false)
    private String salaryType;

    @ApiModelProperty(value="收入日期", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date salaryDate;

    @ApiModelProperty(value="收入来源", required = false)
    private String salaryCompany;

    @ApiModelProperty(value="收入金额", required = false)
    private String salaryAmount;

    @ApiModelProperty(value="收入备注", required = false)
    private String salaryMemo;
}
