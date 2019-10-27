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
public class MailModel {

    @ApiModelProperty(value="邮件主题", required = false)
    private String subject;

    @ApiModelProperty(value="邮件内容", required = false)
    private String text;

    @ApiModelProperty(value="邮件ID", required = false)
    private String mailId;


    public MailModel() {
    }

    public MailModel(String subject) {
        this.subject = subject;
    }

    public MailModel(String subject, String text) {
        this.subject = subject;
        this.text = text;
    }

    public MailModel(String subject, String text, String mailId) {
        this.subject = subject;
        this.text = text;
        this.mailId = mailId;
    }
}
