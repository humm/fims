package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.MailModel;

import java.util.List;

/**
 * @author humm23693
 * @description 邮件服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2019/09/20
 */
public interface SysMailService {

    /**
     * 发送邮件
     *
     * @param mailModel
     * @return
     */
    Boolean sendMail(MailModel mailModel);

    /**
     * 接收指定主题邮件
     *
     * @param mailModel
     * @return
     */
    List<MailModel> receiveMail(MailModel mailModel);

}
