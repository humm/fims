package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysParameterQueryModel;
import com.hoomoomoo.fims.app.model.common.ResultData;

/**
 * @author humm23693
 * @description 参数信息服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2019/10/20
 */
public interface SysParameterService {

    /**
     * 查询参数信息
     *
     * @param sysParameterQueryModel
     * @return
     */
    ResultData selectList(SysParameterQueryModel sysParameterQueryModel);
}
