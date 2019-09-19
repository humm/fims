package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.dao.SysReportDao;
import com.hoomoomoo.fims.app.model.*;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.model.common.SessionBean;
import com.hoomoomoo.fims.app.service.SysReportService;
import com.hoomoomoo.fims.app.util.LogUtils;
import com.hoomoomoo.fims.app.util.SystemSessionUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.hoomoomoo.fims.app.config.RunDataConfig.DICTIONARY_CONDITION;
import static com.hoomoomoo.fims.app.consts.BusinessConst.*;
import static com.hoomoomoo.fims.app.consts.CueConst.SELECT_SUCCESS;
import static com.hoomoomoo.fims.app.consts.DictionaryConst.D000;
import static com.hoomoomoo.fims.app.consts.TipConst.LOG_BUSINESS_TYPE_REPORT_INCOME;
import static com.hoomoomoo.fims.app.consts.TipConst.LOG_OPERATE_TYPE_SELECT;

/**
 * @author humm23693
 * @description 报表信息服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/09/08
 */

@Service
@Transactional
public class SysReportServiceImpl implements SysReportService {

    private static final Logger logger = LoggerFactory.getLogger(SysReportServiceImpl.class);

    @Autowired
    private SysReportDao sysReportDao;

    /**
     * 查询报表数据
     *
     * @param reportMode
     * @param reportType
     * @param reportSubType
     * @param reportValue
     * @return
     */
    @Override
    public ResultData initData(String reportMode, String reportType, String reportSubType, String reportValue) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_REPORT_INCOME, LOG_OPERATE_TYPE_SELECT);
        SysReportQueryModel sysReportQueryModel = new SysReportQueryModel();
        sysReportQueryModel.setReportMode(reportMode);
        sysReportQueryModel.setReportType(reportType);
        sysReportQueryModel.setReportSubType(reportSubType);
        sysReportQueryModel.setReportValue(reportValue);
        SysReportModel sysReportModel = null;
        switch (reportMode) {
            case REPORT_MODE_BAR:
                sysReportModel = initBarData(sysReportQueryModel);
                break;
            case REPORT_MODE_PIE:
                sysReportModel = initPieData(sysReportQueryModel);
                break;
            default:
                break;
        }
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_REPORT_INCOME, LOG_OPERATE_TYPE_SELECT);
        return new ResultData(true, SELECT_SUCCESS, sysReportModel);
    }

    /**
     * 获取报表数据
     *
     * @param sysReportQueryModel
     * @return
     */
    private List<SysReportModel> getSysReportData(SysReportQueryModel sysReportQueryModel) {
        List<SysReportModel> sysReportModelList = new ArrayList<>();
        LogUtils.parameter(logger, sysReportQueryModel);
        switch (sysReportQueryModel.getReportType()) {
            case REPORT_TYPE_INCOME:
                if (REPORT_SUB_TYPE_YEAR.equals(sysReportQueryModel.getReportSubType())) {
                    // 年度
                    sysReportModelList = sysReportDao.selectIncomeYear(sysReportQueryModel);
                } else if (REPORT_SUB_TYPE_MONTH.equals(sysReportQueryModel.getReportSubType())) {
                    // 月度
                    sysReportModelList = sysReportDao.selectIncomeMonth(sysReportQueryModel);
                } else if (REPORT_SUB_TYPE_SOURCE.equals(sysReportQueryModel.getReportSubType())) {
                    // 来源
                    sysReportModelList = sysReportDao.selectIncomeSource(sysReportQueryModel);
                } else if (REPORT_SUB_TYPE_TYPE.equals(sysReportQueryModel.getReportSubType())) {
                    // 类型
                    sysReportModelList = sysReportDao.selectIncomeType(sysReportQueryModel);
                } else if (REPORT_SUB_TYPE_PEAK.equals(sysReportQueryModel.getReportSubType())) {
                    // 极值
                    sysReportModelList = sysReportDao.selectIncomePeak(sysReportQueryModel);
                }
                break;
            case REPORT_TYPE_GIFT_SEND:
                sysReportQueryModel.setGiftMode(STR_0);
                sysReportQueryModel.setGiftSender(sysReportQueryModel.getUserId());
                sysReportModelList = getSysGiftReportData(sysReportQueryModel);
                break;
            case REPORT_TYPE_GIFT_RECEIVE:
                sysReportQueryModel.setGiftMode(STR_1);
                sysReportQueryModel.setGiftReceiver(sysReportQueryModel.getUserId());
                sysReportModelList = getSysGiftReportData(sysReportQueryModel);
                break;
            default:
                break;
        }
        return sysReportModelList;
    }

    /**
     * 获取随礼报表数据
     *
     * @param sysReportQueryModel
     * @return
     */
    private List<SysReportModel> getSysGiftReportData(SysReportQueryModel sysReportQueryModel) {
        List<SysReportModel> sysReportModelList = new ArrayList<>();
        if (REPORT_SUB_TYPE_YEAR.equals(sysReportQueryModel.getReportSubType())) {
            // 年度
            sysReportModelList = sysReportDao.selectGiftYear(sysReportQueryModel);
        } else if (REPORT_SUB_TYPE_MONTH.equals(sysReportQueryModel.getReportSubType())) {
            // 月度
            sysReportModelList = sysReportDao.selectGiftMonth(sysReportQueryModel);
        } else if (REPORT_SUB_TYPE_TYPE.equals(sysReportQueryModel.getReportSubType())) {
            // 类型
            sysReportModelList = sysReportDao.selectGiftType(sysReportQueryModel);
        } else if (REPORT_SUB_TYPE_PEAK.equals(sysReportQueryModel.getReportSubType())) {
            // 极值
            sysReportModelList = sysReportDao.selectGiftPeak(sysReportQueryModel);
        } else if (REPORT_SUB_TYPE_GIFT.equals(sysReportQueryModel.getReportSubType())) {
            // 随礼
            sysReportQueryModel.setGiftSender(sysReportQueryModel.getUserId());
            sysReportQueryModel.setGiftReceiver(sysReportQueryModel.getUserId());
            sysReportModelList = sysReportDao.selectGift(sysReportQueryModel);
        }
        return sysReportModelList;
    }

    /**
     * 设置报表信息公共数据
     *
     * @param sysReportModel
     * @param sysReportQueryModel
     * @param sysReportModelList
     * @param sessionBean
     */
    private void setSysReportCommonProperties(SysReportModel sysReportModel, SysReportQueryModel sysReportQueryModel,
                                              List<SysReportModel> sysReportModelList, SessionBean sessionBean) {
        switch (sysReportQueryModel.getReportMode()) {
            case REPORT_MODE_BAR:
                setBarSysReportCommonProperties(sysReportModel, sysReportQueryModel, sysReportModelList, sessionBean);
                break;
            case REPORT_MODE_PIE:
                setPieSysReportCommonProperties(sysReportModel, sysReportModelList);
                break;
            default:
                break;
        }
    }

    /**
     * 设置报表信息数据
     *
     * @param sysReportModel
     * @param sysReportModelList
     * @param sessionBean
     */
    private void setSysReportProperties(SysReportModel sysReportModel, SysReportQueryModel sysReportQueryModel,
                                        List<SysReportModel> sysReportModelList, SessionBean sessionBean,
                                        Integer index) {
        switch (sysReportQueryModel.getReportMode()) {
            case REPORT_MODE_BAR:
                setBarSysReportProperties(sysReportModel, sysReportQueryModel, sysReportModelList, index);
                break;
            case REPORT_MODE_PIE:
                setPieSysReportProperties(sysReportModel, sysReportModelList);
                break;
            default:
                break;
        }
    }

    /**
     * 查询饼图数据
     *
     * @param sysReportQueryModel
     * @return
     */
    private SysReportModel initPieData(SysReportQueryModel sysReportQueryModel) {
        SysReportModel sysReportModel = new SysReportModel();
        SessionBean sessionBean = SystemSessionUtils.getSession();
        if (sessionBean != null) {
            String loginUserId = sessionBean.getUserId();
            if (!sessionBean.getIsAdmin()) {
                sysReportQueryModel.setUserId(loginUserId);
            }
            List<SysReportModel> sysReportModelList = getSysReportData(sysReportQueryModel);
            setSysReportCommonProperties(sysReportModel, sysReportQueryModel, sysReportModelList, sessionBean);
            setSysReportProperties(sysReportModel, sysReportQueryModel, sysReportModelList, sessionBean, null);
        }
        return sysReportModel;
    }

    /**
     * 查询柱状图报表数据
     *
     * @param sysReportQueryModel
     * @return
     */
    private SysReportModel initBarData(SysReportQueryModel sysReportQueryModel) {
        SysReportModel sysReportModel = new SysReportModel();
        SessionBean sessionBean = SystemSessionUtils.getSession();
        if (sessionBean != null) {
            String loginUserId = sessionBean.getUserId();
            // 获取所有用户数据
            if (sessionBean.getIsAdmin()) {
                // 获取汇总数据
                List<SysReportModel> sysReportModelList = getSysReportData(sysReportQueryModel);
                setSysReportCommonProperties(sysReportModel, sysReportQueryModel, sysReportModelList, sessionBean);
                setSysReportProperties(sysReportModel, sysReportQueryModel, sysReportModelList, sessionBean, 0);
                // 获取用户信息
                List<SysDictionaryModel> userList = DICTIONARY_CONDITION.get(loginUserId).get(D000);
                for (int i = 0; i < userList.size(); i++) {
                    sysReportQueryModel.setUserId(userList.get(i).getDictionaryItem());
                    sysReportQueryModel.setUserName(userList.get(i).getDictionaryCaption());
                    sysReportModelList = getSysReportData(sysReportQueryModel);
                    setSysReportProperties(sysReportModel, sysReportQueryModel, sysReportModelList, sessionBean, i + 1);
                }
            } else {
                // 获取当前用户数据
                sysReportQueryModel.setUserId(loginUserId);
                List<SysReportModel> sysReportModelList = getSysReportData(sysReportQueryModel);
                setSysReportCommonProperties(sysReportModel, sysReportQueryModel, sysReportModelList, sessionBean);
                setSysReportProperties(sysReportModel, sysReportQueryModel, sysReportModelList, sessionBean, 0);
            }
        }
        return sysReportModel;
    }

    /**
     * 设置柱状图公共数据
     *
     * @param sysReportModel
     * @param sysReportQueryModel
     * @param sysReportModelList
     * @param sessionBean
     */
    private void setBarSysReportCommonProperties(SysReportModel sysReportModel, SysReportQueryModel sysReportQueryModel,
                                                 List<SysReportModel> sysReportModelList, SessionBean sessionBean) {
        // 设置公共数据
        if (CollectionUtils.isNotEmpty(sysReportModelList)) {
            Integer length = DICTIONARY_CONDITION.get(sessionBean.getUserId()).get(D000).size();
            length = sessionBean.getIsAdmin() ? length + 1 : length;
            sysReportModel.setLegendData(new String[length]);
            sysReportModel.setTitle(sysReportModelList.get(0).getTitle());
            sysReportModel.setSubTitle(sysReportModelList.get(0).getSubTitle());
            sysReportModel.setYAxisData(new ArrayList<>());
            // 设置x轴数据
            setXAxisData(sysReportModel, sysReportQueryModel, sysReportModelList);
        } else {
            sysReportModel.setLegendData(new String[0]);
            sysReportModel.setTitle(STR_EMPTY);
            sysReportModel.setSubTitle(STR_EMPTY);
            sysReportModel.setYAxisData(new ArrayList<>());
            sysReportModel.setXAxisData(new String[0]);
        }
    }

    /**
     * 设置饼图公共数据
     *
     * @param sysReportModel
     * @param sysReportModelList
     */
    private void setPieSysReportCommonProperties(SysReportModel sysReportModel, List<SysReportModel> sysReportModelList) {
        // 设置公共数据
        if (CollectionUtils.isNotEmpty(sysReportModelList)) {
            sysReportModel.setLegendData(new String[sysReportModelList.size()]);
            sysReportModel.setTitle(sysReportModelList.get(0).getTitle());
            sysReportModel.setSubTitle(sysReportModelList.get(0).getSubTitle());
            sysReportModel.setPieData(new ArrayList<>());
        } else {
            sysReportModel.setLegendData(new String[0]);
            sysReportModel.setTitle(STR_EMPTY);
            sysReportModel.setSubTitle(STR_EMPTY);
            sysReportModel.setPieData(new ArrayList<>());
        }
    }

    /**
     * 设置X轴数据
     *
     * @param sysReportModel
     * @param sysReportModelList
     */
    private void setXAxisData(SysReportModel sysReportModel, SysReportQueryModel sysReportQueryModel,
                              List<SysReportModel> sysReportModelList) {
        switch (sysReportQueryModel.getReportMode()) {
            case REPORT_MODE_BAR:
                if (REPORT_SUB_TYPE_YEAR.equals(sysReportQueryModel.getReportSubType())) {
                    Integer start = Integer.valueOf(sysReportModelList.get(0).getReportDate());
                    Integer end = Integer.valueOf(sysReportModelList.get(sysReportModelList.size() - 1).getReportDate());
                    sysReportModel.setXAxisData(new String[end - start + 1]);
                    for (int i = 0; i < end - start + 1; i++) {
                        sysReportModel.getXAxisData()[i] =
                                new StringBuffer(String.valueOf(start + i)).append(REPORT_UNIT_YEAR).toString();
                    }
                } else if (REPORT_SUB_TYPE_MONTH.equals(sysReportQueryModel.getReportSubType())) {
                    sysReportModel.setXAxisData(new String[REPORT_NUM_12]);
                    for (int i = 0; i < REPORT_NUM_12; i++) {
                        sysReportModel.getXAxisData()[i] =
                                new StringBuffer(String.valueOf(i + 1)).append(REPORT_UNIT_MONTH).toString();
                    }
                }
                break;
            case REPORT_MODE_PIE:
                // 无需设置
                break;
            default:
                break;
        }
    }

    /**
     * 设置柱状图报表信息数据
     *
     * @param sysReportModel
     * @param sysReportModelList
     * @param sysReportQueryModel
     * @param index
     */
    private void setBarSysReportProperties(SysReportModel sysReportModel, SysReportQueryModel sysReportQueryModel,
                                           List<SysReportModel> sysReportModelList, Integer index) {
        // 设置Y轴数据
        Integer length = sysReportModel.getXAxisData().length;
        if (length == 0) {
            return;
        }
        SysReportYaxisModel sysReportYaxisModel = new SysReportYaxisModel();
        sysReportYaxisModel.setData(new Double[length]);
        sysReportModel.getYAxisData().add(sysReportYaxisModel);
        // 设置Y轴标题
        if (CollectionUtils.isEmpty(sysReportModelList)) {
            sysReportYaxisModel.setName(sysReportQueryModel.getUserName());
            if (sysReportModel.getLegendData().length > 0) {
                sysReportModel.getLegendData()[index] = sysReportQueryModel.getUserName();
            }
        } else {
            if (StringUtils.isBlank(sysReportModelList.get(0).getReportName())) {
                sysReportYaxisModel.setName(REPORT_COLLECT_TITLE);
                sysReportModel.getLegendData()[index] = REPORT_COLLECT_TITLE;
            } else {
                sysReportYaxisModel.setName(sysReportModelList.get(0).getReportName());
                sysReportModel.getLegendData()[index] = sysReportModelList.get(0).getReportName();
            }
        }
        // 设置Y轴数据
        for (int i = 0; i < length; i++) {
            if (CollectionUtils.isNotEmpty(sysReportModelList)) {
                String year = sysReportModel.getXAxisData()[i];
                inner:
                for (SysReportModel sysReport : sysReportModelList) {
                    Boolean flag =
                            year.equals(new StringBuffer(sysReport.getReportDate()).append(REPORT_UNIT_YEAR).toString()) ||
                                    year.equals(new StringBuffer(sysReport.getReportDate()).append(REPORT_UNIT_MONTH).toString());
                    if (flag) {
                        sysReportYaxisModel.getData()[i] = sysReport.getReportNum();
                        break inner;
                    }
                }
                // 若无则设置为0
                if (sysReportYaxisModel.getData()[i] == null) {
                    sysReportYaxisModel.getData()[i] = 0D;
                }
            } else {
                sysReportYaxisModel.getData()[i] = 0D;
            }
        }
    }

    /**
     * 设置饼图报表信息数据
     *
     * @param sysReportModel
     * @param sysReportModelList
     */
    private void setPieSysReportProperties(SysReportModel sysReportModel, List<SysReportModel> sysReportModelList) {
        if (CollectionUtils.isNotEmpty(sysReportModelList)) {
            SysReportPieModel sysReportPieModel = new SysReportPieModel();
            sysReportPieModel.setData(new SysReportPieSubModel[sysReportModelList.size()]);
            sysReportPieModel.setName(sysReportModelList.get(0).getTitle());
            sysReportModel.getPieData().add(sysReportPieModel);
            for (int i = 0; i < sysReportModelList.size(); i++) {
                sysReportModel.getLegendData()[i] = sysReportModelList.get(i).getReportName();
                SysReportPieSubModel sysReportPieSubModel = new SysReportPieSubModel();
                sysReportPieSubModel.setName(sysReportModelList.get(i).getReportName());
                sysReportPieSubModel.setValue(sysReportModelList.get(i).getReportNum());
                sysReportPieModel.getData()[i] = sysReportPieSubModel;
            }
        }
    }

}
