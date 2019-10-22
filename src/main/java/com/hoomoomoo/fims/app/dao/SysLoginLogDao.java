package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysLoginLogModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author humm23693
 * @description 登入日志dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2019/10/22
 */

@Mapper
public interface SysLoginLogDao {


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
