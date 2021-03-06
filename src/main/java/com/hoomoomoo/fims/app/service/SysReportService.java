package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.common.ResultData;

/**
 * @author hoomoomoo
 * @description 报表信息服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2019/09/08
 */

public interface SysReportService {

    /**
     * 查询报表数据
     *
     * @param reportMode
     * @param reportType
     * @param reportSubType
     * @param reportValue
     * @return
     */
    ResultData initData(String reportMode, String reportType, String reportSubType, String reportValue);
}
