package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysDictionaryModel;
import com.hoomoomoo.fims.app.model.SysDictionaryQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;

import java.util.List;

/**
 * @author hoomoomoo
 * @description  字典信息服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2019/08/11
 */

public interface SysDictionaryService {

    /**
     * 查询页面初始化相关数据
     *
     * @return
     */
    ResultData selectInitData();

    /**
     * 分页查询字典信息
     *
     * @param sysDictionaryQueryModel
     * @return
     */
    FimsPage<SysDictionaryModel> selectPage(SysDictionaryQueryModel sysDictionaryQueryModel);

    /**
     * 查询字典信息
     *
     * @param sysDictionaryQueryModel
     * @return
     */
    List<SysDictionaryModel> selectSysDictionary(SysDictionaryQueryModel sysDictionaryQueryModel);

    /**
     * 查询字典信息
     *
     * @param dictionaryCode
     * @return
     */
    ResultData selectOne(String dictionaryCode, Boolean isTranslate);

    /**
     * 保存字典信息
     *
     * @param sysDictionaryModelList
     * @return
     */
    ResultData save(List<SysDictionaryModel> sysDictionaryModelList);

    /**
     * 刷新字典信息
     *
     * @return
     */
    ResultData refresh();

}
