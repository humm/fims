package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysConsoleModel;

/**
 * @author humm23693
 * @description 首页信息服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2019/10/27
 */
public interface SysConsoleService {

    /**
     * 查询首页信息
     *
     * @return
     */
    SysConsoleModel selectConsoleData();
}
