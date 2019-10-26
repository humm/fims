package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysNoticeModel;
import com.hoomoomoo.fims.app.model.SysNoticeQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;

/**
 * @author humm23693
 * @description 消息通知服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2019/09/06
 */

public interface SysNoticeService {

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
     * 查询页面初始化相关数据
     *
     * @return
     */
    ResultData selectInitData();

    /**
     * 分页查询消息通知信息
     *
     * @param sysNoticeQueryModel
     * @return
     */
    FimsPage<SysNoticeModel> selectPage(SysNoticeQueryModel sysNoticeQueryModel);


    /**
     * 查询消息通知信息
     *
     * @param noticeId
     * @return
     */
    ResultData selectOne(String noticeId, Boolean isTranslate);

}
