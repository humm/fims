package com.hoomoomoo.fims.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.mail.Message;

/**
 * @author humm23693
 * @description
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/11/08
 */

@Data
public class MailMessageModel {

    @ApiModelProperty(value="邮件ID", required = false)
    private String mailId;

    @ApiModelProperty(value="邮件消息内容", required = false)
    private Message message;
}
