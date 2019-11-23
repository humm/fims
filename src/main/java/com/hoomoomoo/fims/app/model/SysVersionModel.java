package com.hoomoomoo.fims.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hoomoomoo.fims.app.model.common.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author humm23693
 * @description 修订信息实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/11/23
 */

@Data
public class SysVersionModel extends BaseModel {

    @ApiModelProperty(value="修订ID", required = false)
    private String versionId;

    @ApiModelProperty(value="修订内容", required = false)
    private String versionContent;

    @ApiModelProperty(value="修订日期", required = false)
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy年MM月dd日")
    private Date versionDate;

    @ApiModelProperty(value="修订排序", required = false)
    private String versionOrder;

    @ApiModelProperty(value="修订类型", required = false)
    private String versionType;
}
