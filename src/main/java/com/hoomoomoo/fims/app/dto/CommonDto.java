package com.hoomoomoo.fims.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author humm23693
 * @description 公共dto
 * @package com.hoomoomoo.fims.app.dto
 * @date 2019/08/08
 */

@Data
public class CommonDto {

    @ApiModelProperty(value="创建人", required = false)
    private String createUser;

    @ApiModelProperty(value="创建时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @ApiModelProperty(value="修改人", required = false)
    private String modifyUser;

    @ApiModelProperty(value="修改时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date modifyDate;

    @JsonIgnore
    @ApiModelProperty(value="排序字段", required = false)
    private String sort;

    @JsonIgnore
    @ApiModelProperty(value="排序方式", required = false)
    private String order;

    @JsonIgnore
    @ApiModelProperty(value="是否管理员", required = false)
    private Boolean isAdmin;
}
