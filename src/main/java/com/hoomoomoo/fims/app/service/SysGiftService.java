package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysGiftModel;
import com.hoomoomoo.fims.app.model.SysGiftQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;

/**
 * @author hoomoomoo
 * @description 随礼信息服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2019/09/07
 */

public interface SysGiftService {

    /**
     * 查询页面初始化相关数据
     *
     * @return
     */
    ResultData selectInitData();

    /**
     * 分页查询随礼信息
     *
     * @param sysGiftQueryModel
     * @return
     */
    FimsPage<SysGiftModel> selectPage(SysGiftQueryModel sysGiftQueryModel);

    /**
     * 删除随礼信息
     *
     * @param giftIds
     * @return
     */
    ResultData delete(String giftIds);

    /**
     * 查询随礼信息
     *
     * @param giftId
     * @return
     */
    ResultData selectOne(String giftId, Boolean isTranslate);

    /**
     * 保存随礼信息
     *
     * @param sysGiftModel
     * @return
     */
    ResultData save(SysGiftModel sysGiftModel);
}
