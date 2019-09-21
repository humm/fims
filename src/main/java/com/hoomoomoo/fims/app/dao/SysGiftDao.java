package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysGiftModel;
import com.hoomoomoo.fims.app.model.SysGiftQueryModel;
import com.hoomoomoo.fims.app.model.common.LastType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author humm23693
 * @description 随礼信息dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2019/09/07
 */

@Mapper
public interface SysGiftDao {

    /**
     * 分页查询收入信息
     *
     * @param sysGiftQueryModel
     * @return
     */
    List<SysGiftModel> selectPage(SysGiftQueryModel sysGiftQueryModel);

    /**
     * 删除收入信息
     *
     * @param sysGiftModelList
     * @return
     */
    void delete(List<SysGiftModel> sysGiftModelList);

    /**
     * 查询收入信息
     *
     * @param sysGiftQueryModel
     * @return
     */
    SysGiftModel selectOne(SysGiftQueryModel sysGiftQueryModel);

    /**
     * 查询最后一次随礼类型
     *
     * @param sysGiftQueryModel
     * @return
     */
    LastType selectLastType(SysGiftQueryModel sysGiftQueryModel);

    /**
     * 保存收入信息
     *
     * @param sysGiftModel
     */
    void save(SysGiftModel sysGiftModel);
}
