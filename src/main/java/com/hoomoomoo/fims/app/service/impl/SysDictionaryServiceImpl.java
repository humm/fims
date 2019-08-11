package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.dao.SysDictionaryDao;
import com.hoomoomoo.fims.app.dto.SysDictionaryDto;
import com.hoomoomoo.fims.app.dto.SysDictionaryQueryDto;
import com.hoomoomoo.fims.app.dto.common.SessionBean;
import com.hoomoomoo.fims.app.service.SysDictionaryService;
import com.hoomoomoo.fims.app.util.BeanMapUtils;
import com.hoomoomoo.fims.app.util.SystemSessionUtils;
import com.hoomoomoo.fims.app.util.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 字典信息服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/08/11
 */

@Service
public class SysDictionaryServiceImpl implements SysDictionaryService {

    private static final Logger logger = LoggerFactory.getLogger(SysDictionaryServiceImpl.class);

    @Autowired
    private SysDictionaryDao sysDictionaryDao;

    /**
     * 查询字典信息
     *
     * @param sysDictionaryQueryDto
     * @return
     */
    @Override
    public List<SysDictionaryDto> selectSysSalary(SysDictionaryQueryDto sysDictionaryQueryDto){
        logger.info(String.format(LOG_FORMAT_TIP, LOG_BUSINESS_TYPE_DICTIONARY, LOG_TYPE_SERVICE, LOG_OPERATE_TYPE_SELECT,
                LOG_OPERATE_TAG_START));
        SystemUtils.setSessionInfo(sysDictionaryQueryDto);
        logger.info(LOG_REQUEST_PARAMETER, BeanMapUtils.beanToMap(sysDictionaryQueryDto));
        List<SysDictionaryDto> sysDictionaryDtoList = sysDictionaryDao.selectSysSalary(sysDictionaryQueryDto);
        logger.info(String.format(LOG_FORMAT_TIP, LOG_BUSINESS_TYPE_DICTIONARY, LOG_TYPE_SERVICE, LOG_OPERATE_TYPE_SELECT,
                LOG_OPERATE_TAG_END));
        return sysDictionaryDtoList;
    }
}
