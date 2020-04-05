package com.hoomoomoo.fims.app.service;


import com.hoomoomoo.fims.app.model.SysIncomeModel;
import com.hoomoomoo.fims.app.model.SysIncomeQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;

/**
 * @author hoomoomoo
 * @description 收入信息服务类
 * @package com.hoomoomoo.fims.app.service.common
 * @date 2019/08/10
 */

public interface SysIncomeService {

    /**
     * 查询页面初始化相关数据
     *
     * @return
     */
    ResultData selectInitData();

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
     * @param incomeIds
     * @return
     */
    ResultData delete(String incomeIds);

    /**
     * 查询收入信息
     *
     * @param incomeId
     * @return
     */
    ResultData selectOne(String incomeId, Boolean isTranslate);

    /**
     * 保存收入信息
     *
     * @param sysIncomeModel
     * @return
     */
    ResultData save(SysIncomeModel sysIncomeModel);
}
