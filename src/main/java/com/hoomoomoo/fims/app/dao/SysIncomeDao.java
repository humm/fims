package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysIncomeModel;
import com.hoomoomoo.fims.app.model.SysIncomeQueryModel;
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

}
