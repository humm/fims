package com.hoomoomoo.fims.app.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author humm23693
 * @description 查询dto
 * @package com.hoomoomoo.fims.app.dto
 * @date 2019/08/10
 */

@Data
public class QueryDto {

    @ApiModelProperty(value = "当前页码", required = true)
    private Integer page;

    @ApiModelProperty(value = "每页显示记录数", required = true)
    private Integer limit;

    @ApiModelProperty(value = "排序字段", required = false)
    private String sort;

    @ApiModelProperty(value = "排序方式", required = false)
    private String order;

    @JsonIgnore
    @ApiModelProperty(value = "是否管理员", required = false)
    private Boolean isAdmin;

    @JsonIgnore
    @ApiModelProperty(value = "session用户ID", required = false)
    private String userKey;


}
