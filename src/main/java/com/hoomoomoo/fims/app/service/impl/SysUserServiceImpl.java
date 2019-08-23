package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.dao.SysUserDao;
import com.hoomoomoo.fims.app.model.SysUserModel;
import com.hoomoomoo.fims.app.model.SysUserQueryModel;
import com.hoomoomoo.fims.app.service.SysUserService;
import com.hoomoomoo.fims.app.util.LogUtils;
import com.hoomoomoo.fims.app.util.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 用户信息服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/08/11
 */

@Service
public class SysUserServiceImpl implements SysUserService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 查询用户信息
     *
     * @param sysUserQueryModel
     * @return
     */
    @Override
    public List<SysUserModel> selectSysUser(SysUserQueryModel sysUserQueryModel) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT);
        SystemUtils.setSessionInfo(sysUserQueryModel);
        LogUtils.parameter(logger, sysUserQueryModel);

        List<SysUserModel> sysUserList = sysUserDao.selectSysUser(sysUserQueryModel);

        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT);
        return sysUserList;
    }
}
