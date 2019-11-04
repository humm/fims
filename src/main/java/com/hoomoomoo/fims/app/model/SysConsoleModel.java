package com.hoomoomoo.fims.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
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
    private List<SysBusinessModel> businessModel      = new ArrayList<>();

    @ApiModelProperty(value="登入日志数据", required = false)
    private List<Item> loginModel                     = new ArrayList<>();

    @ApiModelProperty(value="版本信息", required = false)
    private List<Item> versionModel                   = new ArrayList<>();

    @ApiModelProperty(value="统计开始时间", required = false)
    private Item yearStartDate;

    @ApiModelProperty(value="websocket连接url", required = false)
    private String websocketUrl;

    @ApiModelProperty(value="模块控制信息", required = false)
    private SysConfigModel sysConfigModel;

}
