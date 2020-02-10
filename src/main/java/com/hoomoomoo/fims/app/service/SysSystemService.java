package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.common.BaseModel;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.model.common.ViewData;

import java.util.List;

/**
 * @author humm23693
 * @description 系统级别公用服务
 * @package com.hoomoomoo.fims.app.service.common
 * @date 2019/08/04
 */

public interface SysSystemService {

    /**
     * 控制台输出应用配置参数
     */
    void outputConfigParameter();

    /**
     * 加载业务ID
     *
     * @return
     */
    void loadBusinessId();

    /**
     * 根据业务类型获取业务ID
     *
     * @param businessType
     * @return
     */
    String getBusinessSerialNo(String businessType);

    /**
     * 字典转义
     *
     * @param list
     * @param clazz
     * @return
     */
    List transferData(List list, Class clazz);

    /**
     * 字典转义
     *
     * @param baseModel
     * @param clazz
     * @return
     */
    void transferData(BaseModel baseModel, Class clazz);

    /**
     * 加载所有字典查询条件
     *
     * @return
     */
    void loadSysDictionaryCondition();

    /**
     * 获取用户ID
     *
     * @return
     */
    String getUserId();

    /**
     * 设置查询条件
     *
     * @param viewData
     */
    void setCondition(ViewData viewData);

    /**
     * 查询按钮权限
     *
     * @param menuId
     * @return
     */
    Boolean selectButtonAuthority(String menuId);

    /**
     * 获取用户密码
     *
     * @return
     */
    String selectUserPassword();

    /**
     * 系统初始化
     */
    void initSystem();

    /**
     * 参数初始化
     */
    void initParameter();

    /**
     * 加载配置sql
     */
    void getConfigSql();

    /**
     * 系统备份文件
     *
     * @param fileName
     */
    ResultData systemBackupFile(String fileName);

    /**
     * 系统备份dmp
     *
     * @param fileName
     */
    ResultData systemBackupDmp(String fileName);

    /**
     * 应用启动备份
     * @return
     */
    void applicationStartBackup();

    /**
     * 系统启动读取邮件
     */
    void applicationStartMail();

}
