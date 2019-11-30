package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.SysSystemQueryModel;
import com.hoomoomoo.fims.app.model.SysTableModel;
import com.hoomoomoo.fims.app.model.SysTableQueryModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author humm23693
 * @description 系统级别公用Dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2019/08/08
 */

@Mapper
public interface SysSystemDao {

    /**
     * 加载业务ID信息
     *
     * @return
     */
    List<String> loadBusinessId();

    /**
     * 查询页面按钮权限
     *
     * @param sysSystemQueryModel
     * @return
     */
    Boolean selectButtonAuthority(SysSystemQueryModel sysSystemQueryModel);

    /**
     * 查询数据权限
     *
     * @param sysSystemQueryModel
     * @return
     */
    Boolean selectDataAuthority(SysSystemQueryModel sysSystemQueryModel);

    /**
     * 查询系统当前存在表
     *
     * @param sysTableQueryModel
     * @return
     */
    int selectTableNum(SysTableQueryModel sysTableQueryModel);

    /**
     * 查询表字段信息
     *
     * @param sysTableQueryModel
     * @return
     */
    List<SysTableModel> selectTableColumn(SysTableQueryModel sysTableQueryModel);

    /**
     * 查询表数据
     *
     * @param sysTableQueryModel
     * @return
     */
    List<Map> selectTableData(SysTableQueryModel sysTableQueryModel);

}
