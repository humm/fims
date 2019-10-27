package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysBusinessModel;
import com.hoomoomoo.fims.app.model.SysConsoleQueryModel;
import com.hoomoomoo.fims.app.model.SysLoginModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author humm23693
 * @description 首页数据Dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2019/10/27
 */

@Mapper
public interface SysConsoleDao {

    /**
     * 查询最后一笔收入
     *
     * @param sysConsoleQueryModel
     * @return
     */
    SysBusinessModel selectIncomeLast(SysConsoleQueryModel sysConsoleQueryModel);

    /**
     * 查询月度收入
     *
     * @param sysConsoleQueryModel
     * @return
     */
    SysBusinessModel selectIncomeMonth(SysConsoleQueryModel sysConsoleQueryModel);

    /**
     * 查询上年本月度收入
     *
     * @param sysConsoleQueryModel
     * @return
     */
    SysBusinessModel selectIncomePreviousYearMonth(SysConsoleQueryModel sysConsoleQueryModel);

    /**
     * 查询本年上月度收入
     *
     * @param sysConsoleQueryModel
     * @return
     */
    SysBusinessModel selectIncomePreviousMonth(SysConsoleQueryModel sysConsoleQueryModel);

    /**
     * 查询年度收入
     *
     * @param sysConsoleQueryModel
     * @return
     */
    SysBusinessModel selectIncomeYear(SysConsoleQueryModel sysConsoleQueryModel);

    /**
     * 查询总收入
     *
     * @param sysConsoleQueryModel
     * @return
     */
    SysBusinessModel selectIncomeTotal(SysConsoleQueryModel sysConsoleQueryModel);

    /**
     * 查询最后一笔送礼
     *
     * @param sysConsoleQueryModel
     * @return
     */
    SysBusinessModel selectGiftSendLast(SysConsoleQueryModel sysConsoleQueryModel);

    /**
     * 查询年度送礼
     *
     * @param sysConsoleQueryModel
     * @return
     */
    SysBusinessModel selectGiftSendYear(SysConsoleQueryModel sysConsoleQueryModel);

    /**
     * 查询总送礼
     *
     * @param sysConsoleQueryModel
     * @return
     */
    SysBusinessModel selectGiftSendTotal(SysConsoleQueryModel sysConsoleQueryModel);

    /**
     * 查询最后一笔收礼
     *
     * @param sysConsoleQueryModel
     * @return
     */
    SysBusinessModel selectGiftReceiveLast(SysConsoleQueryModel sysConsoleQueryModel);

    /**
     * 查询年度收礼
     *
     * @param sysConsoleQueryModel
     * @return
     */
    SysBusinessModel selectGiftReceiveYear(SysConsoleQueryModel sysConsoleQueryModel);

    /**
     * 查询总收礼
     *
     * @param sysConsoleQueryModel
     * @return
     */
    SysBusinessModel selectGiftReceiveTotal(SysConsoleQueryModel sysConsoleQueryModel);

    /**
     * 查询最后一次登入日志
     *
     * @param sysConsoleQueryModel
     * @return
     */
    SysLoginModel selectLoginLast(SysConsoleQueryModel sysConsoleQueryModel);

    /**
     * 查询本月登入次数
     *
     * @param sysConsoleQueryModel
     * @return
     */
    SysLoginModel selectLoginMonthTime(SysConsoleQueryModel sysConsoleQueryModel);

    /**
     * 查询本年登入次数
     *
     * @param sysConsoleQueryModel
     * @return
     */
    SysLoginModel selectLoginYearTime(SysConsoleQueryModel sysConsoleQueryModel);

    /**
     * 查询总登入次数
     *
     * @param sysConsoleQueryModel
     * @return
     */
    SysLoginModel selectLoginTotalTime(SysConsoleQueryModel sysConsoleQueryModel);
}
