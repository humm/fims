package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysConfigModel;
import com.hoomoomoo.fims.app.model.SysConfigQueryModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author humm23693
 * @description 配置信息dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2019/11/26
 */

@Mapper
public interface SysConfigDao {

    /**
     * 查询配置模块信息
     *
     * @return
     */
    List<SysConfigModel> selectModule(SysConfigQueryModel sysConfigQueryModel);

    /**
     * 保存模块信息
     *
     * @return
     */
    void save(SysConfigModel sysConfigModel);
}
