package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysWeChatUserModel;
import com.hoomoomoo.fims.app.model.SysWeChatUserQueryModel;
import com.hoomoomoo.fims.app.model.common.ResultData;

import java.util.List;

/**
 * @author hoomoomoo
 * @description 微信用户信息服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2020/02/28
 */

public interface SysWeChatUserService {

    /**
     * 微信用户信息新增
     *
     * @param sysWeChatUserModel
     * @return
     */
    void insert(SysWeChatUserModel sysWeChatUserModel);

    /**
     * 微信用户信息修改
     *
     * @param sysWeChatUserModel
     * @return
     */
    void update(SysWeChatUserModel sysWeChatUserModel);

    /**
     * 微信用户信息删除
     *
     * @param sysWeChatUserModel
     * @return
     */
    void delete(SysWeChatUserModel sysWeChatUserModel);

    /**
     * 微信用户信息查询
     *
     * @param sysWeChatUserQueryModel
     * @return
     */
    SysWeChatUserModel selectOne(SysWeChatUserQueryModel sysWeChatUserQueryModel);

    /**
     * 微信用户信息查询
     *
     * @param sysWeChatUserQueryModel
     * @return
     */
    List<SysWeChatUserModel> selectList(SysWeChatUserQueryModel sysWeChatUserQueryModel);

}
