package com.hoomoomoo.fims.app.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hoomoomoo.fims.app.dao.SysIncomeDao;
import com.hoomoomoo.fims.app.model.SysIncomeModel;
import com.hoomoomoo.fims.app.model.SysIncomeQueryModel;
import com.hoomoomoo.fims.app.model.common.Page;
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
    public Page<SysIncomeModel> selectPage(SysIncomeQueryModel sysIncomeQueryModel) {

        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_SALARY, LOG_OPERATE_TYPE_SELECT_PAGE);

        SystemUtils.setSessionInfo(sysIncomeQueryModel);

        LogUtils.parameter(logger, sysIncomeQueryModel);

        PageHelper.startPage(sysIncomeQueryModel.getPage(), sysIncomeQueryModel.getLimit());
        List<SysIncomeModel> sysSalaryList = sysIncomeDao.selectPage(sysIncomeQueryModel);
        PageInfo<SysIncomeModel> pageInfo = new PageInfo<>(systemService.transferData(sysSalaryList, SysIncomeModel.class));

        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_SALARY, LOG_OPERATE_TYPE_SELECT_PAGE);

        return new Page(pageInfo.getTotal(), pageInfo.getList());
    }
}
