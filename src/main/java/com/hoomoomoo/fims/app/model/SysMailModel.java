package com.hoomoomoo.fims.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humm23693
 * @description 邮件实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/08/04
 */

@Data
public class SysMailModel {

    @ApiModelProperty(value="邮件主题", required = false)
    private String subject;

    @ApiModelProperty(value="邮件内容", required = false)
    private String content;

    @ApiModelProperty(value="邮件ID", required = false)
    private String mailId;

    @ApiModelProperty(value="收件人", required = false)
    private String to;

}