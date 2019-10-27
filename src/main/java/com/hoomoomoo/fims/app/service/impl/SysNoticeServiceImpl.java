package com.hoomoomoo.fims.app.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hoomoomoo.fims.app.dao.SysNoticeDao;
import com.hoomoomoo.fims.app.model.SysNoticeModel;
import com.hoomoomoo.fims.app.model.SysNoticeQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.model.common.ViewData;
import com.hoomoomoo.fims.app.service.SysNoticeService;
import com.hoomoomoo.fims.app.service.SysSystemService;
import com.hoomoomoo.fims.app.util.LogUtils;
import com.hoomoomoo.fims.app.util.SystemUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.hoomoomoo.fims.app.consts.BusinessConst.*;
import static com.hoomoomoo.fims.app.consts.CueConst.SELECT_SUCCESS;
import static com.hoomoomoo.fims.app.consts.DictionaryConst.D007;
import static com.hoomoomoo.fims.app.consts.DictionaryConst.D012;
import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 消息通知服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/09/06
 */

@Service
@Transactional
public class SysNoticeServiceImpl implements SysNoticeService {

    private static final Logger logger = LoggerFactory.getLogger(SysNoticeServiceImpl.class);

    @Autowired
    private SysNoticeDao sysNoticeDao;

    @Autowired
    private SysSystemService sysSystemService;

    /**
     * 保存消息通知
     *
     * @param sysNoticeModel
     */
    @Override
    public void save(SysNoticeModel sysNoticeModel) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_ADD);
        SystemUtils.setCreateUserInfo(sysNoticeModel);
        if (StringUtils.isBlank(sysNoticeModel.getNoticeStatus())) {
            sysNoticeModel.setNoticeStatus(new StringBuffer(D007).append(MINUS).append(STR_1).toString());
        }
        LogUtils.parameter(logger, sysNoticeModel);
        sysNoticeDao.save(sysNoticeModel);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_ADD);

    }

    /**
     * 更新消息通知
     *
     * @param sysNoticeModel
     */
    @Override
    public void update(SysNoticeModel sysNoticeModel) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_UPDATE);
        SystemUtils.setCreateUserInfo(sysNoticeModel);
        if (StringUtils.isBlank(sysNoticeModel.getNoticeStatus())) {
            sysNoticeModel.setNoticeStatus(new StringBuffer(D007).append(MINUS).append(STR_2).toString());
        }
        LogUtils.parameter(logger, sysNoticeModel);
        sysNoticeDao.update(sysNoticeModel);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_UPDATE);
    }

    /**
     * 查询页面初始化相关数据
     *
     * @return
     */
    @Override
    public ResultData selectInitData() {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT_INIT);
        ViewData viewData = new ViewData();
        // 设置查询条件
        viewData.setViewType(BUSINESS_TYPE_NOTICE);
        sysSystemService.setCondition(viewData);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT_INIT);
        return new ResultData(true, SELECT_SUCCESS, viewData);
    }

    /**
     * 分页查询消息通知信息
     *
     * @param sysNoticeQueryModel
     * @return
     */
    @Override
    public FimsPage<SysNoticeModel> selectPage(SysNoticeQueryModel sysNoticeQueryModel) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT_PAGE);
        SystemUtils.setSessionInfo(sysNoticeQueryModel);
        LogUtils.parameter(logger, sysNoticeQueryModel);
        PageHelper.startPage(sysNoticeQueryModel.getPage(), sysNoticeQueryModel.getLimit());
        List<SysNoticeModel> sysNoticeModelList = sysNoticeDao.selectPage(sysNoticeQueryModel);
        // 创建PageInfo对象前 不能处理数据否则getTotal数据不正确
        PageInfo<SysNoticeModel> pageInfo = new PageInfo<>(sysNoticeModelList);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT_PAGE);
        return new FimsPage(pageInfo.getTotal(), sysSystemService.transferData(pageInfo.getList(), SysNoticeModel.class));
    }

    /**
     * 查询消息通知信息
     *
     * @param noticeId
     * @param isTranslate
     * @return
     */
    @Override
    public ResultData selectOne(String noticeId, Boolean isTranslate) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT);
        SysNoticeQueryModel sysNoticeQueryModel = new SysNoticeQueryModel();
        sysNoticeQueryModel.setNoticeId(noticeId);
        LogUtils.parameter(logger, sysNoticeQueryModel);
        SysNoticeModel sysNoticeModel = sysNoticeDao.selectOne(sysNoticeQueryModel);
        SysNoticeModel sysNotice = new SysNoticeModel();
        BeanUtils.copyProperties(sysNoticeModel, sysNotice);
        if (isTranslate) {
            sysSystemService.transferData(sysNoticeModel, SysNoticeModel.class);
        }
        sysNotice.setReadStatus(new StringBuffer(D012).append(MINUS).append(STR_2).toString());
        // 修改阅读状态
        update(sysNotice);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT);
        return new ResultData(true, SELECT_SUCCESS, sysNoticeModel);
    }

}
