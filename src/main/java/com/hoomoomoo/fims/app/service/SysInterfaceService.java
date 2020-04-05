package com.hoomoomoo.fims.app.service;

import com.hoomoomoo.fims.app.model.SysInterfaceResponseModel;
import com.hoomoomoo.fims.app.model.SysMailModel;
import com.hoomoomoo.fims.app.model.common.BaseModel;

import java.util.List;

/**
 * @author hoomoomoo
 * @description 接口信息服务类
 * @package com.hoomoomoo.fims.app.service
 * @date 2020/02/09
 */

public interface SysInterfaceService {

    /**
     * 处理邮件请求
     */
    void handleMailRequest();


    /**
     * 处理业务请求数据
     *
     * @param baseModelList
     * @param sysMailModel
     * @return
     */
    SysInterfaceResponseModel handleRequestData(List<BaseModel> baseModelList, SysMailModel sysMailModel);
}
