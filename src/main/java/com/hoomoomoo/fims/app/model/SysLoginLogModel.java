package com.hoomoomoo.fims.app.model;

import com.hoomoomoo.fims.app.model.common.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author humm23693
 * @description 登录日志实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/10/21
 */

@Data
public class SysLoginLogModel extends BaseModel {

    @ApiModelProperty(value="日志ID", required = false)
    private String logId;

    @ApiModelProperty(value="用户ID", required = false)
    private String userId;

    @ApiModelProperty(value="登入日期", required = false)
    private Date loginDate;

    @ApiModelProperty(value="登出日期", required = false)
    private Date logoutDate;

    @ApiModelProperty(value="登入状态", required = false)
    private String loginStatus;

    @ApiModelProperty(value="登入提示消息", required = false)
    private String loginMessage;
}
