package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysDictionaryModel;
import com.hoomoomoo.fims.app.model.SysDictionaryQueryModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author humm23693
 * @description 字典信息Dto
 * @package com.hoomoomoo.fims.app.dao
 * @date 2019/08/11
 */

@Mapper
public interface SysDictionaryDao {

    /**
     * 分页查询字典信息
     *
     * @param sysDictionaryQueryModel
     * @return
     */
    List<SysDictionaryModel> selectPage(SysDictionaryQueryModel sysDictionaryQueryModel);

    /**
     * 查询字典信息
     *
     * @param sysDictionaryQueryModel
     * @return
     */
    List<SysDictionaryModel> selectSysDictionary(SysDictionaryQueryModel sysDictionaryQueryModel);

    /**
     * 查询所有字典查询条件
     *
     * @return
     */
    List<SysDictionaryModel> selectSysDictionaryCondition();


}
