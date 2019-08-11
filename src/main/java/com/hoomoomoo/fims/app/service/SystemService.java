package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.dto.MailDto;
import com.hoomoomoo.fims.app.dto.common.ModelDto;

import javax.mail.Message;
import java.util.List;
import java.util.Map;

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
     *
     * @param mailDto
     * @return
     */
    Boolean sendMail(MailDto mailDto);

    /**
     * 接收指定主题邮件
     *
     * @param mailDto
     * @return
     */
    List<Map<String, Message>> receiveMail(MailDto mailDto);

    /**
     * 处理邮件内容
     *
     * @param messages
     */
    List<MailDto> handleMailData(List<Map<String, Message>> messages);

    /**
     * 加载业务ID
     *
     * @return
     */
    void loadBusinessId();

    /**
     * 根据业务类型获取业务ID
     *
     * @param businessType
     * @return
     */
    String getBusinessSerialNo(String businessType);

    /**
     * 字典转义
     *
     * @param list
     * @param clazz
     * @return
     */
    List transferData(List list, Class clazz);
}
