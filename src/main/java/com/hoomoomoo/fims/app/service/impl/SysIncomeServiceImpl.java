package com.hoomoomoo.fims.app.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hoomoomoo.fims.app.dao.SysIncomeDao;
import com.hoomoomoo.fims.app.model.SysDictionaryModel;
import com.hoomoomoo.fims.app.model.SysIncomeModel;
import com.hoomoomoo.fims.app.model.SysIncomeQueryModel;
import com.hoomoomoo.fims.app.model.common.*;
import com.hoomoomoo.fims.app.service.SysIncomeService;
import com.hoomoomoo.fims.app.service.SystemService;
import com.hoomoomoo.fims.app.util.LogUtils;
import com.hoomoomoo.fims.app.util.SystemSessionUtils;
import com.hoomoomoo.fims.app.util.SystemUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hoomoomoo.fims.app.config.RunDataConfig.DICTIONARY_CONDITION;
import static com.hoomoomoo.fims.app.config.RunDataConfig.MIND_FILL;
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
public class SysIncomeServiceImpl implements SysIncomeService {

    private static final Logger logger = LoggerFactory.getLogger(SysIncomeServiceImpl.class);

    @Autowired
    private SysIncomeDao sysIncomeDao;

    @Autowired
    private SystemService systemService;

    /**
     * 查询列表页面相关数据
     *
     * @return
     */
    @Override
    public ResultData selectInitData() {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT_INIT);
        ViewData viewData = new ViewData();
        Map<String, List<SysDictionaryModel>> condition = new HashMap<>();
        SessionBean sessionBean = SystemSessionUtils.getSession();
        String userId = sessionBean.getUserId();
        // 获取查询条件
        condition.put(SELECT_USER_ID,
                DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D000));
        condition.put(SELECT_INCOME_COMPANY,
                DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D005));
        condition.put(SELECT_INCOME_TYPE,
                DICTIONARY_CONDITION.get(new StringBuffer(userId).append(BLANK).toString()).get(D003));
        viewData.setCondition(condition);
        // 智能填充
        viewData.setMindFill(MIND_FILL);
        // 最近一次操作类型
        SysIncomeQueryModel sysIncomeQueryModel = new SysIncomeQueryModel();
        sysIncomeQueryModel.setUserId(userId);
        LastType lastType = sysIncomeDao.selectLastType(sysIncomeQueryModel);
        viewData.setLastType(lastType);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT_INIT);
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
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT_PAGE);
        SystemUtils.setSessionInfo(sysIncomeQueryModel);
        LogUtils.parameter(logger, sysIncomeQueryModel);
        PageHelper.startPage(sysIncomeQueryModel.getPage(), sysIncomeQueryModel.getLimit());
        List<SysIncomeModel> sysIncomeModelList = sysIncomeDao.selectPage(sysIncomeQueryModel);
        // 创建PageInfo对象前 不能处理数据否则getTotal数据不正确
        PageInfo<SysIncomeModel> pageInfo = new PageInfo<>(sysIncomeModelList);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT_PAGE);
        return new FimsPage(pageInfo.getTotal(), systemService.transferData(pageInfo.getList(), SysIncomeModel.class));
    }

    /**
     * 删除收入信息
     *
     * @param incomeIds
     * @return
     */
    @Override
    public ResultData delete(String incomeIds) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_DELETE);
        List<SysIncomeModel> list = new ArrayList<>();
        if(StringUtils.isNotBlank(incomeIds)){
            String[] incomeId = incomeIds.split(COMMA);
            for(String ele : incomeId){
                SysIncomeModel sysIncomeModel = new SysIncomeModel();
                sysIncomeModel.setIncomeId(ele);
                list.add(sysIncomeModel);
            }
            sysIncomeDao.delete(list);
        }
        LogUtils.parameter(logger, list);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_DELETE);
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
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT);
        SysIncomeQueryModel sysIncomeQueryModel = new SysIncomeQueryModel();
        sysIncomeQueryModel.setIncomeId(incomeId);
        LogUtils.parameter(logger, sysIncomeQueryModel);
        SysIncomeModel sysIncomeModel = sysIncomeDao.selectOne(sysIncomeQueryModel);
        if(isTranslate){
            sysIncomeModel = (SysIncomeModel)systemService.transferData(sysIncomeModel);
        }
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT);
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
        if(sysIncomeModel.getIncomeId() == null){
            sysIncomeModel.setIncomeId(systemService.getBusinessSerialNo(BUSINESS_TYPE_INCOME));
        }
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_INCOME, operateType);
        SystemUtils.setCreateUserInfo(sysIncomeModel);
        LogUtils.parameter(logger, sysIncomeModel);
        sysIncomeDao.save(sysIncomeModel);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_INCOME, operateType);
        return new ResultData(true, tipMsg, null);
    }
}
