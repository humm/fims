package com.hoomoomoo.fims.app.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hoomoomoo.fims.app.dao.SysSalaryDao;
import com.hoomoomoo.fims.app.dto.common.ModelDto;
import com.hoomoomoo.fims.app.dto.common.Page;
import com.hoomoomoo.fims.app.dto.SysSalaryDto;
import com.hoomoomoo.fims.app.dto.SysSalaryQueryDto;
import com.hoomoomoo.fims.app.dto.common.SessionBean;
import com.hoomoomoo.fims.app.service.SysSalaryService;
import com.hoomoomoo.fims.app.service.SystemService;
import com.hoomoomoo.fims.app.util.BeanMapUtils;
import com.hoomoomoo.fims.app.util.SystemSessionUtils;
import com.hoomoomoo.fims.app.util.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hoomoomoo.fims.app.consts.TipConst.*;
import static com.hoomoomoo.fims.app.consts.TipConst.LOG_OPERATE_TAG_END;

/**
 * @author humm23693
 * @description 收入信息服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/08/10
 */

@Service
public class SysSalaryServiceImpl implements SysSalaryService {

    private static final Logger logger = LoggerFactory.getLogger(SysSalaryServiceImpl.class);

    @Autowired
    private SysSalaryDao sysSalaryDao;

    @Autowired
    private SystemService systemService;

    /**
     * 分页查询收入信息
     *
     * @param sysSalaryQueryDto
     * @return
     */
    @Override
    public Page<SysSalaryQueryDto> selectPage(SysSalaryQueryDto sysSalaryQueryDto) {
        logger.info(String.format(LOG_FORMAT_TIP, LOG_BUSINESS_TYPE_SALARY, LOG_TYPE_SERVICE, LOG_OPERATE_TYPE_SELECT_PAGE,
                LOG_OPERATE_TAG_START));
        SystemUtils.setSessionInfo(sysSalaryQueryDto);
        logger.info(LOG_REQUEST_PARAMETER, BeanMapUtils.beanToMap(sysSalaryQueryDto));
        PageHelper.startPage(sysSalaryQueryDto.getPage(), sysSalaryQueryDto.getLimit());
        List<SysSalaryDto> sysSalaryDtoList = sysSalaryDao.selectPage(sysSalaryQueryDto);
        PageInfo<SysSalaryDto> pageInfo = new PageInfo<>(systemService.transferData(sysSalaryDtoList, SysSalaryDto.class));
        logger.info(String.format(LOG_FORMAT_TIP, LOG_BUSINESS_TYPE_SALARY, LOG_TYPE_SERVICE, LOG_OPERATE_TYPE_SELECT_PAGE,
                LOG_OPERATE_TAG_END));
        return new Page(pageInfo.getTotal(), pageInfo.getList());
    }
}
