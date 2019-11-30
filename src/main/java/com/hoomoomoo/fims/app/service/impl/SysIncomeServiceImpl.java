package com.hoomoomoo.fims.app.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hoomoomoo.fims.app.config.WebSocketServerConfig;
import com.hoomoomoo.fims.app.dao.SysIncomeDao;
import com.hoomoomoo.fims.app.model.SysIncomeModel;
import com.hoomoomoo.fims.app.model.SysIncomeQueryModel;
import com.hoomoomoo.fims.app.model.SysNoticeModel;
import com.hoomoomoo.fims.app.model.common.*;
import com.hoomoomoo.fims.app.service.SysIncomeService;
import com.hoomoomoo.fims.app.service.SysNoticeService;
import com.hoomoomoo.fims.app.service.SysSystemService;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import com.hoomoomoo.fims.app.util.SysUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.hoomoomoo.fims.app.consts.BusinessConst.*;
import static com.hoomoomoo.fims.app.consts.CueConst.*;
import static com.hoomoomoo.fims.app.consts.DictionaryConst.*;
import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 收入信息服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/08/10
 */

@Service
@Transactional
public class SysIncomeServiceImpl implements SysIncomeService {

    private static final Logger logger = LoggerFactory.getLogger(SysIncomeServiceImpl.class);

    @Autowired
    private SysIncomeDao sysIncomeDao;

    @Autowired
    private SysSystemService sysSystemService;

    @Autowired
    private SysNoticeService sysNoticeService;

    /**
     * 查询列表页面相关数据
     *
     * @return
     */
    @Override
    public ResultData selectInitData() {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT_INIT);
        ViewData viewData = new ViewData();
        // 设置查询条件
        viewData.setViewType(BUSINESS_TYPE_INCOME);
        sysSystemService.setCondition(viewData);
        // 最近一次操作类型
        SysIncomeQueryModel sysIncomeQueryModel = new SysIncomeQueryModel();
        sysIncomeQueryModel.setUserId(sysSystemService.getUserId());
        LastType lastType = sysIncomeDao.selectLastType(sysIncomeQueryModel);
        if (lastType != null) {
            viewData.setLastType(lastType);
            LastType incomeCompany = sysIncomeDao.selectLastTypeIncomeCompany(sysIncomeQueryModel);
            viewData.getLastType().setIncomeCompany(incomeCompany.getIncomeCompany());
        }
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT_INIT);
        return new ResultData(true, SELECT_SUCCESS, viewData);
    }

    /**
     * 分页查询收入信息
     *
     * @param sysIncomeQueryModel
     * @return
     */
    @Override
    public FimsPage<SysIncomeModel> selectPage(SysIncomeQueryModel sysIncomeQueryModel) {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT_PAGE);
        SysUtils.setSessionInfo(sysIncomeQueryModel);
        SysLogUtils.parameter(logger, sysIncomeQueryModel);
        PageHelper.startPage(sysIncomeQueryModel.getPage(), sysIncomeQueryModel.getLimit());
        List<SysIncomeModel> sysIncomeModelList = sysIncomeDao.selectPage(sysIncomeQueryModel);
        // 创建PageInfo对象前 不能处理数据否则getTotal数据不正确
        PageInfo<SysIncomeModel> pageInfo = new PageInfo<>(sysIncomeModelList);
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT_PAGE);
        return new FimsPage(pageInfo.getTotal(), sysSystemService.transferData(pageInfo.getList(), SysIncomeModel.class));
    }

    /**
     * 删除收入信息
     *
     * @param incomeIds
     * @return
     */
    @Override
    public ResultData delete(String incomeIds) {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_DELETE);
        List<SysIncomeModel> list = new ArrayList<>();
        if (StringUtils.isNotBlank(incomeIds)) {
            String[] incomeId = incomeIds.split(COMMA);
            for (String ele : incomeId) {
                SysIncomeModel sysIncomeModel = new SysIncomeModel();
                sysIncomeModel.setIncomeId(ele);
                SysNoticeModel sysNoticeModel = setSysNoticeProperties(sysIncomeModel);
                sysNoticeModel.setBusinessId(ele);
                sysNoticeService.update(sysNoticeModel);
                list.add(sysIncomeModel);
            }
            sysIncomeDao.delete(list);
        }
        SysLogUtils.parameter(logger, list);
        sendWebsocketInfo();
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_DELETE);
        return new ResultData(true, DELETE_SUCCESS, null);
    }

    /**
     * 查询收入信息
     *
     * @param incomeId
     * @return
     */
    @Override
    public ResultData selectOne(String incomeId, Boolean isTranslate) {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT);
        SysIncomeQueryModel sysIncomeQueryModel = new SysIncomeQueryModel();
        sysIncomeQueryModel.setIncomeId(incomeId);
        SysLogUtils.parameter(logger, sysIncomeQueryModel);
        SysIncomeModel sysIncomeModel = sysIncomeDao.selectOne(sysIncomeQueryModel);
        if (isTranslate) {
            sysSystemService.transferData(sysIncomeModel, SysIncomeModel.class);
        }
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT);
        return new ResultData(true, SELECT_SUCCESS, sysIncomeModel);
    }

    /**
     * 保存收入信息
     *
     * @param sysIncomeModel
     * @return
     */
    @Override
    public ResultData save(SysIncomeModel sysIncomeModel) {
        String operateType = sysIncomeModel.getIncomeId() == null ? LOG_OPERATE_TYPE_ADD : LOG_OPERATE_TYPE_UPDATE;
        String tipMsg = sysIncomeModel.getIncomeId() == null ? ADD_SUCCESS : UPDATE_SUCCESS;
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_INCOME, operateType);
        SysUtils.setCreateUserInfo(sysIncomeModel);
        SysNoticeModel sysNoticeModel = setSysNoticeProperties(sysIncomeModel);
        if (sysIncomeModel.getIncomeId() == null) {
            // 新增
            String incomeId = sysSystemService.getBusinessSerialNo(BUSINESS_TYPE_INCOME);
            sysIncomeModel.setIncomeId(incomeId);
            sysNoticeModel.setBusinessId(incomeId);
        } else {
            // 修改
            sysNoticeModel.setBusinessId(sysIncomeModel.getIncomeId());
            sysNoticeService.update(sysNoticeModel);
        }
        sysNoticeModel.setNoticeStatus(new StringBuffer(D007).append(MINUS).append(STR_1).toString());
        sysNoticeModel.setNoticeId(sysSystemService.getBusinessSerialNo(BUSINESS_TYPE_NOTICE));
        sysNoticeService.save(sysNoticeModel);
        SysLogUtils.parameter(logger, sysIncomeModel);
        sysIncomeDao.save(sysIncomeModel);
        sendWebsocketInfo();
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_INCOME, operateType);
        return new ResultData(true, tipMsg, null);
    }

    /**
     * 设置消息通知属性
     *
     * @param sysIncomeModel
     * @return
     */
    private SysNoticeModel setSysNoticeProperties(SysIncomeModel sysIncomeModel) {
        SysNoticeModel sysNoticeModel = new SysNoticeModel();
        sysNoticeModel.setUserId(sysIncomeModel.getUserId());
        sysNoticeModel.setBusinessType(new StringBuffer(D011).append(MINUS).append(STR_1).toString());
        sysNoticeModel.setBusinessSubType(sysIncomeModel.getIncomeType());
        sysNoticeModel.setBusinessDate(sysIncomeModel.getIncomeDate());
        sysNoticeModel.setBusinessAmount(sysIncomeModel.getIncomeAmount());
        sysNoticeModel.setNoticeType(new StringBuffer(D008).append(MINUS).append(STR_1).toString());
        sysNoticeModel.setReadStatus(new StringBuffer(D012).append(MINUS).append(STR_1).toString());
        return sysNoticeModel;
    }

    /**
     * 发送websocket消息
     */
    private void sendWebsocketInfo() {
        WebSocketServerConfig.sendMessageInfo(WEBSOCKET_TOPIC_NAME_CONSOLE, LOG_BUSINESS_TYPE_INCOME);
        WebSocketServerConfig.sendMessageInfo(WEBSOCKET_TOPIC_NAME_NOTICE, LOG_BUSINESS_TYPE_INCOME);
    }
}
