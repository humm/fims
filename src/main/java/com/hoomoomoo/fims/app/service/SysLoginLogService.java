package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysLoginLogModel;

/**
 * @author humm23693
 * @description 登入日志服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2019/10/22
 */

public interface SysLoginLogService {

    /**
     * 保存登录日志信息
     *
     * @param sysLoginLogModel
     */
    void save(SysLoginLogModel sysLoginLogModel);

    /**
     * 更新登录日志信息
     *
     * @param sysLoginLogModel
     */
    void update(SysLoginLogModel sysLoginLogModel);
}
