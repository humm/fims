package com.hoomoomoo.fims.app.service.common;

import com.hoomoomoo.fims.app.dto.MailDto;

import javax.mail.Message;
import java.util.List;

/**
 * @author humm23693
 * @description 系统级别公用服务
 * @package com.hoomoomoo.fims.app.service.common
 * @date 2019/08/04
 */
public interface SystemService {

    /**
     * 控制台输出应用配置参数
     */
    void outputConfigParameter();

    /**
     * 发送邮件
     * @param mailDto
     * @return
     */
    Boolean sendMail(MailDto mailDto);

    /**
     * 接收指定主题邮件
     * @param mailDto
     * @return
     */
    List<Message> receiveMail(MailDto mailDto);

    /**
     * 处理邮件内容
     * @param messages
     */
    List<MailDto> handleMailData(List<Message> messages);
}
