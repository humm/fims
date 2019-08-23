package com.hoomoomoo.fims.app.model;

import com.hoomoomoo.fims.app.model.common.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 用户信息实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/08/11
 */

@Data
public class SysUserModel extends BaseModel {

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

    @ApiModelProperty(value="是否管理员", required = false)
    private Boolean isAdmin;

    @ApiModelProperty(value="备注", required = false)
    private String userMemo;

}
