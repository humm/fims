package com.hoomoomoo.fims.app.dto;

import lombok.Data;

/**
 * @author humm23693
 * @description 邮件实体类
 * @package com.hoomoomoo.fims.app.dto
 * @date 2019/08/04
 */

@Data
public class MailDto {

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String text;

    /**
     * 邮件id
     */
    private String mailId;


    public MailDto() {
    }

    public MailDto(String subject) {
        this.subject = subject;
    }

    public MailDto(String subject, String text) {
        this.subject = subject;
        this.text = text;
    }

    public MailDto(String subject, String text, String mailId) {
        this.subject = subject;
        this.text = text;
        this.mailId = mailId;
    }
}
