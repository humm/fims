package com.hoomoomoo.fims.app.dto;

import com.hoomoomoo.fims.app.dto.common.QueryDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 字典信息查询实体类
 * @package com.hoomoomoo.fims.app.dto
 * @date 2019/08/11
 */

@Data
public class SysDictionaryQueryDto extends QueryDto {

    @ApiModelProperty(value="字典代码", required = false)
    private String dictionaryCode;

    @ApiModelProperty(value="字典选值", required = false)
    private String dictionaryItem;

    @ApiModelProperty(value="字典描述", required = false)
    private String dictionaryCaption;

    @ApiModelProperty(value="选值排序", required = false)
    private Integer itemOrder;

    @ApiModelProperty(value="代码排序", required = false)
    private Integer codeOrder;

    @ApiModelProperty(value="用户ID", required = false)
    private String userId;
}
