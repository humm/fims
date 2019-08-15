package com.hoomoomoo.fims.app.service;


import com.hoomoomoo.fims.app.model.SysIncomeModel;
import com.hoomoomoo.fims.app.model.SysIncomeQueryModel;
import com.hoomoomoo.fims.app.model.common.Page;

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
    Page<SysIncomeModel> selectPage(SysIncomeQueryModel sysIncomeQueryModel);
}
