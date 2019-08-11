package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.dto.common.Page;
import com.hoomoomoo.fims.app.dto.SysSalaryQueryDto;

/**
 * @author humm23693
 * @description 收入信息服务类
 * @package com.hoomoomoo.fims.app.service.common
 * @date 2019/08/10
 */

public interface SysSalaryService {

    /**
     * 分页查询收入信息
     *
     * @param sysSalaryQueryDto
     * @return
     */
    Page<SysSalaryQueryDto> selectPage(SysSalaryQueryDto sysSalaryQueryDto);
}
