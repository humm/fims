package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysInterfaceModel;
import com.hoomoomoo.fims.app.model.SysInterfaceQueryModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author humm23693
 * @description 接口信息Dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2020/02/09
 */
@Mapper
public interface SysInterfaceDao {

    /**
     * 查询接口信息
     *
     * @param sysInterfaceQueryModel
     * @return
     */
    SysInterfaceModel selectOne(SysInterfaceQueryModel sysInterfaceQueryModel);

    /**
     * 保存接口信息
     *
     * @param sysInterfaceModel
     * @return
     */
    void save(SysInterfaceModel sysInterfaceModel);

   /**
     * 修改接口信息
     *
     * @param sysInterfaceModel
     * @return
     */
    void update(SysInterfaceModel sysInterfaceModel);

}
