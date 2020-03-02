package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysWeChatUserModel;
import com.hoomoomoo.fims.app.model.SysWeChatUserQueryModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author humm23693
 * @description 微信用户信息dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2020/02/28
 */

@Mapper
public interface SysWeChatUserDao {

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