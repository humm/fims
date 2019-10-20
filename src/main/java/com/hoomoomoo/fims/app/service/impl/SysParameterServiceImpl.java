package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.dao.SysParameterDao;
import com.hoomoomoo.fims.app.model.SysParameterModel;
import com.hoomoomoo.fims.app.model.SysParameterQueryModel;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.service.SysParameterService;
import com.hoomoomoo.fims.app.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hoomoomoo.fims.app.consts.CueConst.SELECT_SUCCESS;
import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 参数信息服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/10/20
 */

@Service
public class SysParameterServiceImpl implements SysParameterService {

    private static final Logger logger = LoggerFactory.getLogger(SysParameterServiceImpl.class);


    @Autowired
    private SysParameterDao sysParameterDao;


    /**
     * 查询参数信息
     *
     * @param sysParameterQueryModel
     * @return
     */
    @Override
    public ResultData selectList(SysParameterQueryModel sysParameterQueryModel) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_PARAMETER, LOG_OPERATE_TYPE_SELECT);
        LogUtils.parameter(logger, sysParameterQueryModel);
        List<SysParameterModel> sysUserModelList = sysParameterDao.selectList(sysParameterQueryModel);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_PARAMETER, LOG_OPERATE_TYPE_SELECT);
        return new ResultData(true, SELECT_SUCCESS, sysUserModelList);
    }
}
