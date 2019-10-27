package com.hoomoomoo.fims.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author humm23693
 * @description 首页数据实体类
 * @package com.hoomoomoo.fims.app.model
 * @date 2019/10/27
 */

@Data
public class SysConsoleModel {

    @ApiModelProperty(value="业务数据", required = false)
    private List<SysBusinessModel> businessModel;

    @ApiModelProperty(value="登入日志数据", required = false)
    private SysLoginModel loginModel;
}
