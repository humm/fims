package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysNoticeModel;
import org.apache.ibatis.annotations.Mapper;

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
}
