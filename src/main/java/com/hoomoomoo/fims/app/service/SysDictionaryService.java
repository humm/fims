package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysDictionaryModel;
import com.hoomoomoo.fims.app.model.SysDictionaryQueryModel;

import java.util.List;

/**
 * @author humm23693
 * @description  字典信息服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2019/08/11
 */

public interface SysDictionaryService {

    /**
     * 查询字典信息
     *
     * @param sysDictionaryQueryModel
     * @return
     */
    List<SysDictionaryModel> selectSysDictionary(SysDictionaryQueryModel sysDictionaryQueryModel);

}
