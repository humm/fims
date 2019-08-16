package com.hoomoomoo.fims.app.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hoomoomoo.fims.app.dao.SysIncomeDao;
import com.hoomoomoo.fims.app.model.SysIncomeModel;
import com.hoomoomoo.fims.app.model.SysIncomeQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.service.SysIncomeService;
import com.hoomoomoo.fims.app.service.SystemService;
import com.hoomoomoo.fims.app.util.LogUtils;
import com.hoomoomoo.fims.app.util.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * @param sysIncomeQueryModelList
     * @return
     */
    @Override
    public ResultData delete(List<SysIncomeQueryModel> sysIncomeQueryModelList) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_DELETE);

        LogUtils.parameter(logger, sysIncomeQueryModelList);

        sysIncomeDao.delete(sysIncomeQueryModelList);

        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_DELETE);

        return new ResultData();
    }
}
