package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysNoticeModel;

/**
 * @author humm23693
 * @description 消息通知服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2019/09/06
 */

public interface SysNoticeService {

    /**
     * 保存消息通知
     *
     * @param sysNoticeModel
     */
    void save(SysNoticeModel sysNoticeModel);

    /**
     * 更新消息通知
     *
     * @param sysNoticeModel
     */
    void update(SysNoticeModel sysNoticeModel);

}
