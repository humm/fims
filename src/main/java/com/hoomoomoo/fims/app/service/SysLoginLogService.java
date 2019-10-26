package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysLoginLogModel;
import com.hoomoomoo.fims.app.model.SysLoginLogQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;

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

    /**
     * 查询页面初始化相关数据
     *
     * @return
     */
    ResultData selectInitData();

    /**
     * 分页查询登入日志信息
     *
     * @param sysLoginLogQueryModel
     * @return
     */
    FimsPage<SysLoginLogModel> selectPage(SysLoginLogQueryModel sysLoginLogQueryModel);


    /**
     * 查询登入日志信息
     *
     * @param logId
     * @return
     */
    ResultData selectOne(String logId, Boolean isTranslate);
}
