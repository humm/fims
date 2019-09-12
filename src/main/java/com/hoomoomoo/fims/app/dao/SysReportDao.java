package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysReportModel;
import com.hoomoomoo.fims.app.model.SysReportQueryModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author humm23693
 * @description 报表信息dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2019/09/08
 */

@Mapper
public interface SysReportDao {

    /**
     * 收入信息年度报表
     *
     * @param sysReportQueryModel
     * @return
     */
    List<SysReportModel> selectIncomeYear(SysReportQueryModel sysReportQueryModel);

    /**
     * 收入信息月度报表
     *
     * @param sysReportQueryModel
     * @return
     */
    List<SysReportModel> selectIncomeMonth(SysReportQueryModel sysReportQueryModel);

    /**
     * 收入信息来源报表
     *
     * @param sysReportQueryModel
     * @return
     */
    List<SysReportModel> selectIncomeSource(SysReportQueryModel sysReportQueryModel);

    /**
     * 收入信息类型报表
     *
     * @param sysReportQueryModel
     * @return
     */
    List<SysReportModel> selectIncomeType(SysReportQueryModel sysReportQueryModel);

    /**
     * 收入信息极值报表
     *
     * @param sysReportQueryModel
     * @return
     */
    List<SysReportModel> selectIncomePeak(SysReportQueryModel sysReportQueryModel);

}
