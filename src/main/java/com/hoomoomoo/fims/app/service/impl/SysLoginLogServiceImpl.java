package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.dao.SysLoginLogDao;
import com.hoomoomoo.fims.app.model.SysLoginLogModel;
import com.hoomoomoo.fims.app.service.SysLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author humm23693
 * @description
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/10/22
 */

@Service
@Transactional
public class SysLoginLogServiceImpl implements SysLoginLogService {

    @Autowired
    private SysLoginLogDao sysLoginLogDao;

    /**
     * 保存登录日志信息
     *
     * @param sysLoginLogModel
     */
    @Override
    public void save(SysLoginLogModel sysLoginLogModel) {
        sysLoginLogDao.save(sysLoginLogModel);
    }

    /**
     * 更新登录日志信息
     *
     * @param sysLoginLogModel
     */
    @Override
    public void update(SysLoginLogModel sysLoginLogModel) {
        sysLoginLogDao.update(sysLoginLogModel);
    }
}
