package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysParameterModel;
import com.hoomoomoo.fims.app.model.SysParameterQueryModel;
import com.hoomoomoo.fims.app.model.common.ResultData;

/**
 * @author hoomoomoo
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

    /**
     * 保存参数信息
     *
     * @param sysParameterModel
     * @return
     */
    ResultData save(SysParameterModel sysParameterModel);

    /**
     * 获取系统参数
     *
     * @param parameterCode
     * @return
     */
    Boolean getParameterBoolean(String parameterCode);

    /**
     * 获取系统参数
     *
     * @param parameterCode
     * @return
     */
    String getParameterString(String parameterCode);

    /**
     * 获取系统参数
     *
     * @param parameterCode
     * @return
     */
    Integer getParameterInteger(String parameterCode);
}
