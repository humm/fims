package com.hoomoomoo.fims.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 微信事件消息实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2020/02/28
 */

@Data
public class SysWeChatEventModel extends SysWeChatBaseModel{

    @ApiModelProperty(value="事件key", required = false)
    private String EventKey;

    @ApiModelProperty(value="事件类型", required = false)
    private String Event;
}
