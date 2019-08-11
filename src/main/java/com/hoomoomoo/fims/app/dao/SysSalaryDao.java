package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.dto.SysSalaryDto;
import com.hoomoomoo.fims.app.dto.SysSalaryQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author humm23693
 * @description 收入信息dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2019/08/10
 */

@Mapper
public interface SysSalaryDao {

    /**
     * 分页查询收入信息
     *
     * @param sysSalaryQueryDto
     * @return
     */
    List<SysSalaryDto> selectPage(SysSalaryQueryDto sysSalaryQueryDto);

}
