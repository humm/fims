package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysVersionModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author humm23693
 * @description 修订信息dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2019/11/23
 */

@Mapper
public interface SysVersionDao {

    List<SysVersionModel> selectList();
}
