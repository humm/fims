package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.dao.SysWeChatFlowDao;
import com.hoomoomoo.fims.app.model.SysWeChatFlowModel;
import com.hoomoomoo.fims.app.model.SysWeChatFlowQueryModel;
import com.hoomoomoo.fims.app.service.SysWeChatFlowService;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static com.hoomoomoo.fims.app.config.RunDataConfig.*;
import static com.hoomoomoo.fims.app.consts.BusinessConst.*;
import static com.hoomoomoo.fims.app.consts.CueConst.*;

/**
 * @author humm23693
 * @description 微信流程步骤服务体实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2020/02/29
 */

@Service
@Transactional
public class SysWeChatFlowServiceImpl implements SysWeChatFlowService {

    private static final Logger logger = LoggerFactory.getLogger(SysWeChatFlowServiceImpl.class);


    @Autowired
    private SysWeChatFlowDao sysWeChatFlowDao;

    /**
     * 查询流程步骤
     *
     * @param sysWeChatFlowQueryModel
     * @return
     */
    @Override
    public List<SysWeChatFlowModel> selectFlowList(SysWeChatFlowQueryModel sysWeChatFlowQueryModel) {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_WECHAT_FLOW, LOG_OPERATE_TYPE_SELECT);
        SysLogUtils.parameter(logger, sysWeChatFlowQueryModel);
        List<SysWeChatFlowModel> sysWeChatFlowModelList = sysWeChatFlowDao.selectFlowList(sysWeChatFlowQueryModel);
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_WECHAT_FLOW, LOG_OPERATE_TYPE_SELECT);
        return sysWeChatFlowModelList;
    }

    /**
     * 获取微信流程步骤
     *
     * @return
     */
    @Override
    public void getWeChatFlow() {
        ConcurrentHashMap<String, String> flowNumToCode = new ConcurrentHashMap<>(16);
        LinkedHashMap<String, SysWeChatFlowModel> mainFlow = new LinkedHashMap<>(16);
        StringBuffer mainFlowList = new StringBuffer(WECHAT_MAIN_FLOW).append(NEXT_LINE).append(NEXT_LINE);
        StringBuffer moreFlowList = new StringBuffer();
        StringBuffer flowTip = null;
        SysWeChatFlowQueryModel sysWeChatFlowQueryModel = new SysWeChatFlowQueryModel();
        sysWeChatFlowQueryModel.setFlowType(STR_1 + MINUS + STR_2);
        List<SysWeChatFlowModel> sysWeChatFlowModelList = selectFlowList(sysWeChatFlowQueryModel);
        if (CollectionUtils.isNotEmpty(sysWeChatFlowModelList)) {
            for (SysWeChatFlowModel sysWeChatFlowModel : sysWeChatFlowModelList) {
                flowTip = new StringBuffer(String.format(STR_NUMBER, sysWeChatFlowModel.getFlowNum())).append(sysWeChatFlowModel.getFlowDescribe()).append(NEXT_LINE);
                if (StringUtils.isNotBlank(sysWeChatFlowModel.getFlowCode())) {
                    mainFlow.put(sysWeChatFlowModel.getFlowCode(), sysWeChatFlowModel);
                    flowNumToCode.put(sysWeChatFlowModel.getFlowNum(), sysWeChatFlowModel.getFlowCode());
                } else {
                    mainFlow.put(sysWeChatFlowModel.getFlowNum(), sysWeChatFlowModel);
                }
                if (STR_1.equals(sysWeChatFlowModel.getFlowType())) {
                    mainFlowList.append(flowTip);
                } else {
                    moreFlowList.append(flowTip);
                }
            }
        }
        WECHAT_FLOW_NUM_TO_CODE = flowNumToCode;
        WECHAT_FLOW_LIST = mainFlow;
        WECHAT_MAIN_FLOW_LIST = mainFlowList.toString();
        WECHAT_MAIN_FLOW_MORE_LIST = moreFlowList.toString();
    }
}
