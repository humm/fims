package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.dao.SysNoticeDao;
import com.hoomoomoo.fims.app.model.SysNoticeModel;
import com.hoomoomoo.fims.app.service.SysNoticeService;
import com.hoomoomoo.fims.app.util.LogUtils;
import com.hoomoomoo.fims.app.util.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.hoomoomoo.fims.app.consts.BusinessConst.*;
import static com.hoomoomoo.fims.app.consts.DictionaryConst.D007;
import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 消息通知服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/09/06
 */

@Service
@Transactional
public class SysNoticeServiceImpl implements SysNoticeService {

    private static final Logger logger = LoggerFactory.getLogger(SysNoticeServiceImpl.class);

    @Autowired
    private SysNoticeDao sysNoticeDao;

    /**
     * 保存消息通知
     *
     * @param sysNoticeModel
     */
    @Override
    public void save(SysNoticeModel sysNoticeModel) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_ADD);
        SystemUtils.setCreateUserInfo(sysNoticeModel);
        sysNoticeModel.setNoticeStatus(new StringBuffer(D007).append(MINUS).append(STR_1).toString());
        LogUtils.parameter(logger, sysNoticeModel);
        sysNoticeDao.save(sysNoticeModel);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_ADD);

    }

    /**
     * 更新消息通知
     *
     * @param sysNoticeModel
     */
    @Override
    public void update(SysNoticeModel sysNoticeModel) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_UPDATE);
        SystemUtils.setCreateUserInfo(sysNoticeModel);
        sysNoticeModel.setNoticeStatus(new StringBuffer(D007).append(MINUS).append(STR_2).toString());
        LogUtils.parameter(logger, sysNoticeModel);
        sysNoticeDao.update(sysNoticeModel);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_UPDATE);
    }

}
