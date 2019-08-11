package com.hoomoomoo.fims.app.dto;

import com.hoomoomoo.fims.app.dto.common.QueryDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 用户信息查询实体类
 * @package com.hoomoomoo.fims.app.dto
 * @date 2019/08/11
 */

@Data
public class SysUserQueryDto extends QueryDto {

    @ApiModelProperty(value="用户ID", required = false)
    private String userId;

    @ApiModelProperty(value="用户代码", required = false)
    private String userCode;

    @ApiModelProperty(value="用户名称", required = false)
    private String userName;

    @ApiModelProperty(value="用户密码", required = false)
    private String userPassword;

    @ApiModelProperty(value="用户状态", required = false)
    private String userStatus;

    @ApiModelProperty(value="备注", required = false)
    private String userMemo;
}
