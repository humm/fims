package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.dao.SysDictionaryDao;
import com.hoomoomoo.fims.app.dao.SysParameterDao;
import com.hoomoomoo.fims.app.model.SysDictionaryModel;
import com.hoomoomoo.fims.app.model.SysDictionaryQueryModel;
import com.hoomoomoo.fims.app.model.SysParameterModel;
import com.hoomoomoo.fims.app.model.SysParameterQueryModel;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.service.SysParameterService;
import com.hoomoomoo.fims.app.util.LogUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hoomoomoo.fims.app.consts.BusinessConst.*;
import static com.hoomoomoo.fims.app.consts.CueConst.SELECT_SUCCESS;
import static com.hoomoomoo.fims.app.consts.CueConst.UPDATE_SUCCESS;
import static com.hoomoomoo.fims.app.consts.DictionaryConst.D010;
import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 参数信息服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/10/20
 */

@Service
public class SysParameterServiceImpl implements SysParameterService {

    private static final Logger logger = LoggerFactory.getLogger(SysParameterServiceImpl.class);

    @Autowired
    private SysParameterDao sysParameterDao;

    @Autowired
    private SysDictionaryDao sysDictionaryDao;


    /**
     * 查询参数信息
     *
     * @param sysParameterQueryModel
     * @return
     */
    @Override
    public ResultData selectList(SysParameterQueryModel sysParameterQueryModel) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_PARAMETER, LOG_OPERATE_TYPE_SELECT);
        LogUtils.parameter(logger, sysParameterQueryModel);
        List<SysParameterModel> sysParameterModelList = sysParameterDao.selectList(sysParameterQueryModel);
        transfer(sysParameterModelList);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_PARAMETER, LOG_OPERATE_TYPE_SELECT);
        return new ResultData(true, SELECT_SUCCESS, sysParameterModelList);
    }

    /**
     * 保存参数信息
     *
     * @param sysParameterModel
     * @return
     */
    @Override
    public ResultData save(SysParameterModel sysParameterModel) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_DICTIONARY, LOG_OPERATE_TYPE_UPDATE);
        LogUtils.parameter(logger, sysParameterModel);
        if (PARAMETER_TYPE_SWITCH.equals(sysParameterModel.getParameterType())) {
            if (sysParameterModel.getParameterValue() != null) {
                sysParameterModel.setParameterValue(STR_1);
            } else {
                sysParameterModel.setParameterValue(STR_2);
            }
        }
        sysParameterDao.save(sysParameterModel);
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_DICTIONARY, LOG_OPERATE_TYPE_UPDATE);
        return new ResultData(true, UPDATE_SUCCESS, null);
    }

    /**
     * 获取系统参数
     *
     * @param parameterCode
     * @return
     */
    @Override
    public Boolean getParameterBoolean(String parameterCode) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_PARAMETER, LOG_OPERATE_TYPE_SELECT);
        SysParameterQueryModel sysParameterQueryModel = new SysParameterQueryModel();
        sysParameterQueryModel.setParameterCode(parameterCode);
        LogUtils.parameter(logger, sysParameterQueryModel);
        boolean flag = false;
        SysParameterModel sysParameterModel = sysParameterDao.selectSysParameter(sysParameterQueryModel);
        if (sysParameterModel != null && STR_1.equals(sysParameterModel.getParameterValue())) {
            flag = true;
        }
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_PARAMETER, LOG_OPERATE_TYPE_SELECT);
        return flag;
    }

    /**
     * 获取系统参数
     *
     * @param parameterCode
     * @return
     */
    @Override
    public String getParameterString(String parameterCode) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_PARAMETER, LOG_OPERATE_TYPE_SELECT);
        SysParameterQueryModel sysParameterQueryModel = new SysParameterQueryModel();
        sysParameterQueryModel.setParameterCode(parameterCode);
        LogUtils.parameter(logger, sysParameterQueryModel);
        String parameterValue = STR_EMPTY;
        SysParameterModel sysParameterModel = sysParameterDao.selectSysParameter(sysParameterQueryModel);
        if (sysParameterModel != null) {
            parameterValue = sysParameterModel.getParameterValue();
        }
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_PARAMETER, LOG_OPERATE_TYPE_SELECT);
        return parameterValue;
    }

    /**
     * 转义
     *
     * @param sysParameterModelList
     */
    private void transfer(List<SysParameterModel> sysParameterModelList) {
        if (CollectionUtils.isNotEmpty(sysParameterModelList)) {
            SysDictionaryQueryModel sysDictionaryQueryModel = new SysDictionaryQueryModel();
            sysDictionaryQueryModel.setDictionaryCode(D010);
            List<SysDictionaryModel> dictionaryModelList =
                    sysDictionaryDao.selectSysDictionary(sysDictionaryQueryModel);
            Map<String, String> dictionaryMap = new HashMap(16);
            for (SysDictionaryModel sysDictionaryModel : dictionaryModelList) {
                dictionaryMap.put(sysDictionaryModel.getDictionaryItem(), sysDictionaryModel.getDictionaryCaption());
            }
            for (SysParameterModel sysParameterModel : sysParameterModelList) {
                if (PARAMETER_TYPE_SWITCH.equals(sysParameterModel.getParameterType())) {
                    if (dictionaryMap.get(sysParameterModel.getParameterValue()) != null) {
                        sysParameterModel.setParameterOldValue(sysParameterModel.getParameterValue());
                        sysParameterModel.setParameterValue(dictionaryMap.get(sysParameterModel.getParameterValue()));
                    }
                }
            }
        }
    }
}
