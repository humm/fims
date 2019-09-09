package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.dao.SysReportDao;
import com.hoomoomoo.fims.app.model.SysDictionaryModel;
import com.hoomoomoo.fims.app.model.SysReportModel;
import com.hoomoomoo.fims.app.model.SysReportQueryModel;
import com.hoomoomoo.fims.app.model.SysReportYaxisModel;
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
     * @param reportType
     * @param reportSubType
     * @param reportValue
     * @return
     */
    @Override
    public ResultData initData(String reportType, String reportSubType, String reportValue) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_REPORT_INCOME, LOG_OPERATE_TYPE_SELECT);
        SysReportQueryModel sysReportQueryModel = new SysReportQueryModel();
        sysReportQueryModel.setReportType(reportType);
        sysReportQueryModel.setReportSubType(reportSubType);
        sysReportQueryModel.setReportValue(reportValue);
        SessionBean sessionBean = SystemSessionUtils.getSession();
        SysReportModel sysReportModel = new SysReportModel();
        if (sessionBean != null) {
            String loginUserId = sessionBean.getUserId();
            // 获取所有用户数据
            if (sessionBean.getIsAdmin()) {
                // 获取汇总数据
                List<SysReportModel> sysReportModelList = getSysReportData(sysReportQueryModel);
                setSysReportCommonProperties(sysReportModel, sysReportQueryModel, sysReportModelList, sessionBean);
                setSysReportProperties(sysReportModel, sysReportModelList, sessionBean, 0);
                // 获取用户信息
                List<SysDictionaryModel> userList = DICTIONARY_CONDITION.get(loginUserId).get(D000);
                for (int i = 0; i < userList.size(); i++) {
                    String userId = userList.get(i).getDictionaryItem();
                    sysReportQueryModel.setUserId(userId);
                    sysReportModelList = getSysReportData(sysReportQueryModel);
                    setSysReportProperties(sysReportModel, sysReportModelList, sessionBean, i + 1);
                }
            } else {
                // 获取当前用户数据
                sysReportQueryModel.setUserId(loginUserId);
                List<SysReportModel> sysReportModelList = getSysReportData(sysReportQueryModel);
                setSysReportCommonProperties(sysReportModel, sysReportQueryModel, sysReportModelList, sessionBean);
                setSysReportProperties(sysReportModel, sysReportModelList, sessionBean, 0);
            }
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
                if(REPORT_SUB_TYPE_YEAR.equals(sysReportQueryModel.getReportSubType())){
                    sysReportModelList = sysReportDao.selectIncomeYear(sysReportQueryModel);
                }else if(REPORT_SUB_TYPE_MONTH.equals(sysReportQueryModel.getReportSubType())){
                    sysReportModelList = sysReportDao.selectIncomeMonth(sysReportQueryModel);
                }
                break;
            case REPORT_TYPE_GIFT_SEND:

                break;
            case REPORT_TYPE_GIFT_RECEIVE:

                break;
            default:
                break;
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
            sysReportModel.setXAxisData(new String[0]);
            sysReportModel.setTitle(STR_EMPTY);
            sysReportModel.setSubTitle(STR_EMPTY);
            sysReportModel.setYAxisData(new ArrayList<>());
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
        switch (sysReportQueryModel.getReportSubType()) {
            case REPORT_SUB_TYPE_YEAR:
                Integer start = Integer.valueOf(sysReportModelList.get(0).getReportDate());
                Integer end = Integer.valueOf(sysReportModelList.get(sysReportModelList.size() - 1).getReportDate());
                sysReportModel.setXAxisData(new String[end - start + 1]);
                for (int i = 0; i < end - start + 1; i++) {
                    sysReportModel.getXAxisData()[i] = String.valueOf(start + i);
                }
                break;
            case REPORT_SUB_TYPE_MONTH:
                sysReportModel.setXAxisData(new String[REPORT_NUM_12]);
                for (int i = 0; i < REPORT_NUM_12; i++) {
                    sysReportModel.getXAxisData()[i] = String.valueOf(i + 1);
                }
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
    private void setSysReportProperties(SysReportModel sysReportModel, List<SysReportModel> sysReportModelList,
                                        SessionBean sessionBean, Integer index) {
        // 设置Y轴数据
        Integer length = sysReportModel.getXAxisData().length;
        SysReportYaxisModel sysReportYaxisModel = new SysReportYaxisModel();
        sysReportYaxisModel.setData(new String[length]);
        sysReportModel.getYAxisData().add(sysReportYaxisModel);
        // 设置Y轴标题
        if (CollectionUtils.isEmpty(sysReportModelList)) {
            sysReportYaxisModel.setName(sessionBean.getUserName());
            if (sysReportModel.getLegendData().length > 0) {
                sysReportModel.getLegendData()[index] = sessionBean.getUserName();
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
                    if (year.equals(sysReport.getReportDate())) {
                        sysReportYaxisModel.getData()[i] = sysReport.getReportNum();
                        break inner;
                    }
                }
                // 若无则设置为0
                if (StringUtils.isBlank(sysReportYaxisModel.getData()[i])) {
                    sysReportYaxisModel.getData()[i] = STR_0;
                }
            } else {
                sysReportYaxisModel.getData()[i] = STR_0;
            }
        }
    }
}
