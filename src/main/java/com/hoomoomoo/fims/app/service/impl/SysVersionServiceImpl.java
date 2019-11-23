package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.dao.SysVersionDao;
import com.hoomoomoo.fims.app.model.SysVersionModel;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.service.SysVersionService;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.hoomoomoo.fims.app.consts.CueConst.SELECT_SUCCESS;
import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 修订信息服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/11/23
 */

@Service
@Transactional
public class SysVersionServiceImpl implements SysVersionService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysVersionDao sysVersionDao;

    /**
     * 查询修订信息
     *
     * @return
     */
    @Override
    public ResultData selectList() {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_VERSION, LOG_OPERATE_TYPE_SELECT);
        List<SysVersionModel> sysVersionModelList = sysVersionDao.selectList();
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_VERSION, LOG_OPERATE_TYPE_SELECT);
        return new ResultData(true, SELECT_SUCCESS, sysVersionModelList);
    }
}
