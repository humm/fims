package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysLoginLogModel;
import com.hoomoomoo.fims.app.model.SysLoginLogQueryModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hoomoomoo
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

    /**
     * 分页查询登入日志信息
     *
     * @param sysLoginLogQueryModel
     * @return
     */
    List<SysLoginLogModel> selectPage(SysLoginLogQueryModel sysLoginLogQueryModel);

    /**
     * 查询登入日志信息
     *
     * @param sysLoginLogQueryModel
     * @return
     */
    SysLoginLogModel selectOne(SysLoginLogQueryModel sysLoginLogQueryModel);

}
