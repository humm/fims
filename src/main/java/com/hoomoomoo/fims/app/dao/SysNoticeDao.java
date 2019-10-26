package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysNoticeModel;
import com.hoomoomoo.fims.app.model.SysNoticeQueryModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author humm23693
 * @description 消息通知dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2019/09/06
 */

@Mapper
public interface SysNoticeDao {

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

    /**
     * 分页查询消息通知信息
     *
     * @param sysNoticeQueryModel
     * @return
     */
    List<SysNoticeModel> selectPage(SysNoticeQueryModel sysNoticeQueryModel);

    /**
     * 查询消息通知信息
     *
     * @param sysNoticeQueryModel
     * @return
     */
    SysNoticeModel selectOne(SysNoticeQueryModel sysNoticeQueryModel);
}
