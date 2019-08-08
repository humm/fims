package com.hoomoomoo.fims.app.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author humm23693
 * @description 系统级别公用Dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2019/08/08
 */

@Mapper
public interface SystemDao {

    List<String> loadBusinessId();
}
