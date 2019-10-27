package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.dao.SysConsoleDao;
import com.hoomoomoo.fims.app.model.*;
import com.hoomoomoo.fims.app.model.common.SessionBean;
import com.hoomoomoo.fims.app.service.SysConsoleService;
import com.hoomoomoo.fims.app.service.SysParameterService;
import com.hoomoomoo.fims.app.util.LogUtils;
import com.hoomoomoo.fims.app.util.SystemSessionUtils;
import com.hoomoomoo.fims.app.util.SystemUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.hoomoomoo.fims.app.config.RunDataConfig.DICTIONARY_CONDITION;
import static com.hoomoomoo.fims.app.consts.BusinessConst.STR_0;
import static com.hoomoomoo.fims.app.consts.BusinessConst.STR_EMPTY;
import static com.hoomoomoo.fims.app.consts.DictionaryConst.D000;
import static com.hoomoomoo.fims.app.consts.ParameterConst.YEAR_START_DATE;
import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 首页信息服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/10/27
 */

@Service
@Transactional
public class SysConsoleServiceImpl implements SysConsoleService {

    private static final Logger logger = LoggerFactory.getLogger(SysConsoleServiceImpl.class);

    @Autowired
    private SysParameterService sysParameterService;

    @Autowired
    private SysConsoleDao sysConsoleDao;

    /**
     * 查询首页信息
     *
     * @return
     */
    @Override
    public SysConsoleModel selectConsoleData() {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_CONSOLE, LOG_OPERATE_TYPE_SELECT);
        SysConsoleModel sysConsoleModel = new SysConsoleModel();
        List<SysBusinessModel> sysBusinessModelList = new ArrayList<>();
        sysConsoleModel.setBusinessModel(sysBusinessModelList);
        SessionBean sessionBean = SystemSessionUtils.getSession();
        String yearStartDate = sysParameterService.getParameterString(YEAR_START_DATE);
        SysConsoleQueryModel sysConsoleQueryModel = new SysConsoleQueryModel();
        sysConsoleQueryModel.setYearStartDate(yearStartDate);
        if (sessionBean != null) {
            String loginUserId = sessionBean.getUserId();
            sysConsoleQueryModel.setUserName(sessionBean.getUserName());
            if (sessionBean.getIsAdminData()) {
                // 查询业务统计信息
                setBusinessInfo(sysConsoleModel, sysConsoleQueryModel);
                // 查询登入统计信息
                sysConsoleQueryModel.setUserId(sessionBean.getUserId());
                setLoginInfo(sysConsoleModel, sysConsoleQueryModel);
                // 获取用户信息
                List<SysDictionaryModel> userList = DICTIONARY_CONDITION.get(loginUserId).get(D000);
                if(CollectionUtils.isNotEmpty(userList)){
                    for(SysDictionaryModel sysDictionaryModel : userList){
                        sysConsoleQueryModel.setUserId(sysDictionaryModel.getDictionaryItem());
                        sysConsoleQueryModel.setUserName(sysDictionaryModel.getDictionaryCaption());
                        // 查询业务统计信息
                        setBusinessInfo(sysConsoleModel, sysConsoleQueryModel);
                    }
                }
            } else {
                sysConsoleQueryModel.setUserId(sessionBean.getUserId());
                // 查询业务统计信息
                setBusinessInfo(sysConsoleModel, sysConsoleQueryModel);
                // 查询登入统计信息
                setLoginInfo(sysConsoleModel, sysConsoleQueryModel);
            }
        } else {
            setZeroInfo(sysConsoleModel);
        }
        LogUtils.parameter(logger, sessionBean == null ? new SessionBean() : sessionBean);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_CONSOLE, LOG_OPERATE_TYPE_SELECT);
        return sysConsoleModel;
    }

    /**
     * 设置统计0数据
     *
     * @param sysConsoleModel
     */
    private void setZeroInfo(SysConsoleModel sysConsoleModel) {
        String yearStartDate = sysParameterService.getParameterString(YEAR_START_DATE);
        // 设置业务数据信息
        SysBusinessModel sysBusinessModel = new SysBusinessModel();
        sysBusinessModel.setIncomeLast(STR_0);
        sysBusinessModel.setIncomeRatio(STR_0);
        sysBusinessModel.setIncomeChainRatio(STR_0);
        sysBusinessModel.setIncomeYear(STR_0);
        sysBusinessModel.setIncomeTotal(STR_0);
        sysBusinessModel.setYearStartDate(yearStartDate);
        sysBusinessModel.setGiftSendLast(STR_0);
        sysBusinessModel.setGiftSendYear(STR_0);
        sysBusinessModel.setGiftSendTotal(STR_0);
        sysBusinessModel.setGiftReceiveLast(STR_0);
        sysBusinessModel.setGiftReceiveYear(STR_0);
        sysBusinessModel.setGiftReceiveTotal(STR_0);
        sysBusinessModel.setUserName(STR_EMPTY);
        sysConsoleModel.getBusinessModel().add(sysBusinessModel);
        // 设置登入日志信息
        SysLoginModel sysLoginModel = new SysLoginModel();
        sysLoginModel.setLoginLastDate(STR_EMPTY);
        sysLoginModel.setLoginMonthTime(STR_0);
        sysLoginModel.setLoginYearTime(STR_0);
        sysLoginModel.setLoginTotalTime(STR_0);
        sysConsoleModel.setLoginModel(sysLoginModel);
    }

    /**
     * 设置登入统计信息
     *
     * @param sysConsoleModel
     * @param sysConsoleQueryModel
     */
    private void setLoginInfo(SysConsoleModel sysConsoleModel, SysConsoleQueryModel sysConsoleQueryModel) {
        SysLoginModel sysLoginModel = new SysLoginModel();
        sysConsoleModel.setLoginModel(sysLoginModel);
        // 查询最后一次登入时间
        SysLoginModel console = sysConsoleDao.selectLoginLast(sysConsoleQueryModel);
        sysLoginModel.setLoginLastDate(console == null ? STR_EMPTY : console.getConsoleData());
        // 查询本月登入次数
        console = sysConsoleDao.selectLoginMonthTime(sysConsoleQueryModel);
        sysLoginModel.setLoginMonthTime(console == null ? STR_0 : console.getConsoleData());
        // 查询本年登入次数
        console = sysConsoleDao.selectLoginYearTime(sysConsoleQueryModel);
        sysLoginModel.setLoginYearTime(console == null ? STR_0 : console.getConsoleData());
        // 查询总登入次数
        console = sysConsoleDao.selectLoginTotalTime(sysConsoleQueryModel);
        sysLoginModel.setLoginTotalTime(console == null ? STR_0 : console.getConsoleData());
    }

    private void setBusinessInfo(SysConsoleModel sysConsoleModel, SysConsoleQueryModel sysConsoleQueryModel) {
        SysBusinessModel sysBusinessModel = new SysBusinessModel();
        sysConsoleModel.getBusinessModel().add(sysBusinessModel);
        sysBusinessModel.setUserName(sysConsoleQueryModel.getUserName());
        // 查询最近一笔收入
        SysBusinessModel console = sysConsoleDao.selectIncomeLast(sysConsoleQueryModel);
        sysBusinessModel.setIncomeLast(console == null ? STR_0 : console.getConsoleData());
        // 查询月度收入
        console = sysConsoleDao.selectIncomeMonth(sysConsoleQueryModel);
        sysBusinessModel.setIncomeMonth(console == null ? STR_0 : console.getConsoleData());
        // 设置同比收入
        console = sysConsoleDao.selectIncomePreviousYearMonth(sysConsoleQueryModel);
        if (console != null) {
            double incomeRatio =
                    Double.valueOf(sysBusinessModel.getIncomeMonth()) - Double.valueOf(console.getConsoleData());
            sysBusinessModel.setIncomeRatio(String.valueOf(incomeRatio));
        } else {
            sysBusinessModel.setIncomeRatio(sysBusinessModel.getIncomeMonth());
        }
        // 设置环比收入
        console = sysConsoleDao.selectIncomePreviousMonth(sysConsoleQueryModel);
        if (console != null) {
            double incomeChainRatio =
                    Double.valueOf(sysBusinessModel.getIncomeMonth()) - Double.valueOf(console.getConsoleData());
            sysBusinessModel.setIncomeChainRatio(String.valueOf(incomeChainRatio));
        } else {
            sysBusinessModel.setIncomeChainRatio(sysBusinessModel.getIncomeMonth());

        }
        // 查询年度收入
        console = sysConsoleDao.selectIncomeYear(sysConsoleQueryModel);
        sysBusinessModel.setIncomeYear(console == null ? STR_0 : console.getConsoleData());
        // 查询总收入
        console = sysConsoleDao.selectIncomeTotal(sysConsoleQueryModel);
        sysBusinessModel.setIncomeTotal(console == null ? STR_0 : console.getConsoleData());
        // 查询年度开始时间
        sysBusinessModel.setYearStartDate(sysConsoleQueryModel.getYearStartDate());
        // 查询最近一笔送礼
        console = sysConsoleDao.selectGiftSendLast(sysConsoleQueryModel);
        sysBusinessModel.setGiftSendLast(console == null ? STR_0 : console.getConsoleData());
        // 查询年度送礼
        console = sysConsoleDao.selectGiftSendYear(sysConsoleQueryModel);
        sysBusinessModel.setGiftSendYear(console == null ? STR_0 : console.getConsoleData());
        // 查询总送礼
        console = sysConsoleDao.selectGiftSendTotal(sysConsoleQueryModel);
        sysBusinessModel.setGiftSendTotal(console == null ? STR_0 : console.getConsoleData());
        // 查询最近一笔收礼
        console = sysConsoleDao.selectGiftReceiveLast(sysConsoleQueryModel);
        sysBusinessModel.setGiftReceiveLast(console == null ? STR_0 : console.getConsoleData());
        // 查询年度送礼
        console = sysConsoleDao.selectGiftReceiveYear(sysConsoleQueryModel);
        sysBusinessModel.setGiftReceiveYear(console == null ? STR_0 : console.getConsoleData());
        // 查询总送礼
        console = sysConsoleDao.selectGiftReceiveTotal(sysConsoleQueryModel);
        sysBusinessModel.setGiftReceiveTotal(console == null ? STR_0 : console.getConsoleData());
    }
}
