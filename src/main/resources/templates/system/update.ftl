<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>系统升级</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${appName}/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/admin.css" media="all">
</head>
<body>

<style>
    #LAY-component-timeline .layui-card-body {
        padding: 15px;
    }
    .layui-timeline-item-fims {
        position: relative;
        padding-bottom: 20px;
    }
    .layui-timeline-content {
        padding-left: 30px;
    }
</style>

<div class="layui-fluid" id="LAY-component-timeline">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">
                    <span>当前版本：<b>${version}</b></span>
                    <span style="padding-left:80px;">最新版本：<b>3.1.10</b></span>
                    <span style="margin-left:10px; cursor:pointer;" class="layui-badge">升级</span>
                </div>
                <div class="layui-card-body">
                    <ul class="layui-timeline">
                        <li class="layui-timeline-item-fims">
                            <i class="layui-icon layui-timeline-axis"></i>
                            <div class="layui-timeline-content layui-text">
                                <h3 class="layui-timeline-title">3.1.10</h3>
                                <ul>
                                    <li>
                                        <span class="layui-btn-fims layui-btn-xs-fims layui-bg-orange">&nbsp;功能&nbsp;</span>
                                        &nbsp;&nbsp;&nbsp; 系统升级
                                    </li>
                                    <li>
                                        <span class="layui-btn-fims layui-btn-xs-fims layui-bg-blue">&nbsp;优化&nbsp;</span>
                                        &nbsp;&nbsp;&nbsp; 随礼信息：送礼人、收礼人修改为模糊查询
                                    </li>
                                    <li>
                                        <span class="layui-btn-fims layui-btn-xs-fims layui-bg-gray">&nbsp;修复&nbsp;</span>
                                        &nbsp;&nbsp;&nbsp; 日期控件加载不出来(一闪而过)
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${appName}/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '${appName}/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'admin', 'fims'], function () {
        var $ = layui.$,
            admin = layui.admin,
            fims = layui.fims;

        // 应用名称
        var appName = '${appName}';
        
        var url = {
            init: appName + "/system/update"
        };

        // 版本信息过滤显示  小于等于当前版本内容不显示

        // 系统升级
       /* admin.req({
            url: url.init,
            type: "post",
            dataType: "json",
            done: function (response) {
                if (response.bizResult) {

                }
            }
        });*/

    });
</script>
</body>
</html>