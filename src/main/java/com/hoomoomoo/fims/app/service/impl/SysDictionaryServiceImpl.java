package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.dao.SysDictionaryDao;
import com.hoomoomoo.fims.app.dao.SysUserDao;
import com.hoomoomoo.fims.app.model.SysDictionaryModel;
import com.hoomoomoo.fims.app.model.SysDictionaryQueryModel;
import com.hoomoomoo.fims.app.model.SysUserModel;
import com.hoomoomoo.fims.app.service.SysDictionaryService;
import com.hoomoomoo.fims.app.util.LogUtils;
import com.hoomoomoo.fims.app.util.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 字典信息服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/08/11
 */

@Service
@Transactional
public class SysDictionaryServiceImpl implements SysDictionaryService {

    private static final Logger logger = LoggerFactory.getLogger(SysDictionaryServiceImpl.class);

    @Autowired
    private SysDictionaryDao sysDictionaryDao;

    /**
     * 查询字典信息
     *
     * @param sysDictionaryQueryModel
     * @return
     */
    @Override
    public List<SysDictionaryModel> selectSysDictionary(SysDictionaryQueryModel sysDictionaryQueryModel){
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_DICTIONARY, LOG_OPERATE_TYPE_SELECT);
        SystemUtils.setSessionInfo(sysDictionaryQueryModel);
        LogUtils.parameter(logger, sysDictionaryQueryModel);
        List<SysDictionaryModel> sysDictionaryList = sysDictionaryDao.selectSysDictionary(sysDictionaryQueryModel);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_DICTIONARY, LOG_OPERATE_TYPE_SELECT);
        return sysDictionaryList;
    }

}
