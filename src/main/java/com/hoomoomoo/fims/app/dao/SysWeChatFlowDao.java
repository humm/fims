package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysWeChatFlowModel;
import com.hoomoomoo.fims.app.model.SysWeChatFlowQueryModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author humm23693
 * @description 微信流程步骤服dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2020/02/29
 */

@Mapper
public interface SysWeChatFlowDao {

    /**
     * 查询流程步骤
     *
     * @param selectFlowList
     * @return
     */
    List<SysWeChatFlowModel> selectFlowList(SysWeChatFlowQueryModel sysWeChatFlowQueryModel);

}
