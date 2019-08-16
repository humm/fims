package com.hoomoomoo.fims.app.service;


import com.hoomoomoo.fims.app.model.SysIncomeModel;
import com.hoomoomoo.fims.app.model.SysIncomeQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;

import java.util.List;

/**
 * @author humm23693
 * @description 收入信息服务类
 * @package com.hoomoomoo.fims.app.service.common
 * @date 2019/08/10
 */

public interface SysIncomeService {

    /**
     * 分页查询收入信息
     *
     * @param sysIncomeQueryModel
     * @return
     */
    FimsPage<SysIncomeModel> selectPage(SysIncomeQueryModel sysIncomeQueryModel);

    /**
     * 删除收入信息
     *
     * @param sysIncomeQueryModelList
     * @return
     */
    ResultData delete(List<SysIncomeQueryModel> sysIncomeQueryModelList);
}
