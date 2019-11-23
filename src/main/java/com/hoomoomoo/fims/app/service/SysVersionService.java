package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysVersionModel;
import com.hoomoomoo.fims.app.model.common.ResultData;

import java.util.List;

/**
 * @author humm23693
 * @description 修订信息服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2019/11/23
 */

public interface SysVersionService {

    /**
     * 查询修订信息
     *
     * @return
     */
    ResultData selectList();

}
