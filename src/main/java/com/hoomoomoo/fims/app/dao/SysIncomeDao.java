package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysIncomeModel;
import com.hoomoomoo.fims.app.model.SysIncomeQueryModel;
import com.hoomoomoo.fims.app.model.common.LastType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author humm23693
 * @description 收入信息dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2019/08/10
 */

@Mapper
public interface SysIncomeDao {

    /**
     * 分页查询收入信息
     *
     * @param sysIncomeQueryModel
     * @return
     */
    List<SysIncomeModel> selectPage(SysIncomeQueryModel sysIncomeQueryModel);

    /**
     * 删除收入信息
     *
     * @param SysIncomeModelList
     * @return
     */
    void delete(List<SysIncomeModel> SysIncomeModelList);

    /**
     * 查询收入信息
     *
     * @param sysIncomeQueryModel
     * @return
     */
    SysIncomeModel selectOne(SysIncomeQueryModel sysIncomeQueryModel);

    /**
     * 查询最后一次收入类型
     *
     * @param sysIncomeQueryModel
     * @return
     */
    LastType selectLastType(SysIncomeQueryModel sysIncomeQueryModel);

    /**
     * 查询最后一次收入来源
     *
     * @param sysIncomeQueryModel
     * @return
     */
    LastType selectLastTypeIncomeCompany(SysIncomeQueryModel sysIncomeQueryModel);

    /**
     * 保存收入信息
     *
     * @param sysIncomeModel
     */
    void save(SysIncomeModel sysIncomeModel);

}
