package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.dto.SysDictionaryDto;
import com.hoomoomoo.fims.app.dto.SysDictionaryQueryDto;

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
     * @param sysDictionaryQueryDto
     * @return
     */
    List<SysDictionaryDto> selectSysSalary(SysDictionaryQueryDto sysDictionaryQueryDto);
}
