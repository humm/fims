package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.dto.SysDictionaryDto;
import com.hoomoomoo.fims.app.dto.SysDictionaryQueryDto;
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
     * 查询字典信息
     *
     * @param sysDictionaryQueryDto
     * @return
     */
    List<SysDictionaryDto> selectSysSalary(SysDictionaryQueryDto sysDictionaryQueryDto);
}
