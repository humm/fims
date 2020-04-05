package com.hoomoomoo.fims.app.config.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import static com.hoomoomoo.fims.app.consts.BusinessConst.APPLICATION_PROPERTIES;
import static com.hoomoomoo.fims.app.consts.BusinessConst.SPRING_MAIL;


/**
 * @author hoomoomoo
 * @description 邮件配置
 * @package com.hoomoomoo.fims.app.config.bean
 * @date 2019/08/04
 */

@Component
@PropertySource({APPLICATION_PROPERTIES})
@ConfigurationProperties(prefix = SPRING_MAIL)
@Data
public class MailConfigBean {

    /**
     * 邮件发送是否启用debug模式
     */
    private Boolean debug;

    /**
     * 邮件发送host
     */
    private String host;

    /**
     * 邮件发送用户名
     */
    private String username;

    /**
     * 邮件发送用户密码
     */
    private String password;

    /**
     * 邮件发送协议
     */
    private String protocol;

    /**
     * 邮件收件人
     */
    private String to;

    /**
     * 邮件发送人
     */
    private String from;

    /**
     * 邮件发送编码规则
     */
    @Value("${spring.mail.default-encoding}")
    private String defaultEncoding;


    /**
     * 邮件读取主题
     */
    private String subject;

    /**
     * 邮件读取host
     */
    private String receiveHost;

    /**
     * 邮件读取用户名
     */
    private String receiveUsername;

    /**
     * 邮件读取密码
     */
    private String receivePassword;

    /**
     * 邮件读取协议
     */
    private String receiveProtocol;

    /**
     * 邮件读取类型
     */
    private String receiveFolder;
}
