package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysConfigModel;
import com.hoomoomoo.fims.app.model.SysModuleModel;
import com.hoomoomoo.fims.app.model.common.ResultData;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hoomoomoo
 * @description 首页信息服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2019/10/27
 */
public interface SysConsoleService {

    /**
     * 查询首页信息
     *
     * @return
     */
    ResultData selectConsoleData(HttpServletRequest httpServletRequest);

    /**
     * 查询模块配置信息
     *
     * @return
     */
    SysModuleModel selectConfigModule();

    /**
     * 保存模块信息
     *
     * @param sysModuleModel
     * @return
     */
    ResultData save(SysModuleModel sysModuleModel);

    /**
     * 删除模块信息
     *
     * @param sysConfigModelList
     * @return
     */
    ResultData delete(List<SysConfigModel> sysConfigModelList);
}
