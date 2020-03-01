package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.dao.SysWeChatUserDao;
import com.hoomoomoo.fims.app.model.SysWeChatUserModel;
import com.hoomoomoo.fims.app.model.SysWeChatUserQueryModel;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.service.SysSystemService;
import com.hoomoomoo.fims.app.service.SysWeChatUserService;
import com.hoomoomoo.fims.app.util.SysCommonUtils;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.hoomoomoo.fims.app.consts.CueConst.*;

/**
 * @author humm23693
 * @description 微信用户信息服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2020/02/28
 */

@Service
@Transactional
public class SysWeChatUserServiceImpl implements SysWeChatUserService {

    private static final Logger logger = LoggerFactory.getLogger(SysWeChatUserService.class);

    @Autowired
    private SysWeChatUserDao sysWeChatUserDao;

    @Autowired
    private SysSystemService sysSystemService;

    /**
     * 微信用户信息新增
     *
     * @param sysWeChatUserModel
     * @return
     */
    @Override
    public void insert(SysWeChatUserModel sysWeChatUserModel) {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_USER_WECHAT, LOG_OPERATE_TYPE_ADD);
        SysLogUtils.parameter(logger, sysWeChatUserModel);
        SysCommonUtils.setCreateUserInfo(sysWeChatUserModel, sysSystemService.getUserId());
        sysWeChatUserDao.insert(sysWeChatUserModel);
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_USER_WECHAT, LOG_OPERATE_TYPE_ADD);
    }

    /**
     * 微信用户信息修改
     *
     * @param sysWeChatUserModel
     * @return
     */
    @Override
    public void update(SysWeChatUserModel sysWeChatUserModel) {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_USER_WECHAT, LOG_OPERATE_TYPE_UPDATE);
        SysLogUtils.parameter(logger, sysWeChatUserModel);
        SysCommonUtils.setModifyUserInfo(sysWeChatUserModel, sysSystemService.getUserId());
        sysWeChatUserDao.update(sysWeChatUserModel);
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_USER_WECHAT, LOG_OPERATE_TYPE_UPDATE);
    }

    /**
     * 微信用户信息删除
     *
     * @param sysWeChatUserModel
     * @return
     */
    @Override
    public void delete(SysWeChatUserModel sysWeChatUserModel) {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_USER_WECHAT, LOG_OPERATE_TYPE_DELETE);
        SysLogUtils.parameter(logger, sysWeChatUserModel);
        sysWeChatUserDao.delete(sysWeChatUserModel);
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_USER_WECHAT, LOG_OPERATE_TYPE_DELETE);
    }

    /**
     * 微信用户信息查询
     *
     * @param sysWeChatUserQueryModel
     * @return
     */
    @Override
    public SysWeChatUserModel selectOne(SysWeChatUserQueryModel sysWeChatUserQueryModel) {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_USER_WECHAT, LOG_OPERATE_TYPE_SELECT);
        SysLogUtils.parameter(logger, sysWeChatUserQueryModel);
        SysWeChatUserModel sysWeChatUserModel = sysWeChatUserDao.selectOne(sysWeChatUserQueryModel);
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_USER_WECHAT, LOG_OPERATE_TYPE_SELECT);
        return sysWeChatUserModel;
    }
}
