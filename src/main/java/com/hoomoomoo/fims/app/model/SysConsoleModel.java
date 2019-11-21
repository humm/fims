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
    private List<SysItem> loginModel                     = new ArrayList<>();

    @ApiModelProperty(value="版本信息", required = false)
    private List<SysItem> versionModel                   = new ArrayList<>();

    @ApiModelProperty(value="统计开始时间", required = false)
    private SysItem yearStartDate;

    @ApiModelProperty(value="模块控制信息", required = false)
    private SysConfigModel sysConfigModel;

    @ApiModelProperty(value="未读消息通知", required = false)
    private String readNum;

}
