package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.dao.SysUserDao;
import com.hoomoomoo.fims.app.dto.SysUserDto;
import com.hoomoomoo.fims.app.dto.SysUserQueryDto;
import com.hoomoomoo.fims.app.dto.common.SessionBean;
import com.hoomoomoo.fims.app.service.SysUserService;
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
 * @description 用户信息服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/08/11
 */

@Service
public class SysUserServiceImpl implements SysUserService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 查询用户信息
     *
     * @param sysUserQueryDto
     * @return
     */
    @Override
    public List<SysUserDto> selectSysUser(SysUserQueryDto sysUserQueryDto) {
        logger.info(String.format(LOG_FORMAT_TIP, LOG_BUSINESS_TYPE_USER, LOG_TYPE_SERVICE, LOG_OPERATE_TYPE_SELECT,
                LOG_OPERATE_TAG_START));
        SystemUtils.setSessionInfo(sysUserQueryDto);
        logger.info(LOG_REQUEST_PARAMETER, BeanMapUtils.beanToMap(sysUserQueryDto));
        List<SysUserDto> sysUserDtoList = sysUserDao.selectSysUser(sysUserQueryDto);
        logger.info(String.format(LOG_FORMAT_TIP, LOG_BUSINESS_TYPE_USER, LOG_TYPE_SERVICE, LOG_OPERATE_TYPE_SELECT,
                LOG_OPERATE_TAG_END));
        return sysUserDtoList;
    }
}
