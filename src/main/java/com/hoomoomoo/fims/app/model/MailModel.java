package com.hoomoomoo.fims.app.model;

import lombok.Data;

/**
 * @author humm23693
 * @description 邮件实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/08/04
 */

@Data
public class MailModel {

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
