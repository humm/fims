<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>参数信息-修改</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, role-scalable=0">
    <link rel="stylesheet" href="${appName}/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/fims.css" media="all">

</head>
<body>

<div class="layui-form" style="padding: 20px 30px 0 0;">
    <input type="hidden" name="roleId"/>
    <input type="hidden" name="menuId"/>

    <div class="layui-form-item input">
        <label class="layui-form-label"></label>
        <div class="layui-input-inline">
            <input type="text" name="" class="layui-input" lay-verify="required"/>
        </div>
    </div>
    <div class="layui-form-item radio">
        <label class="layui-form-label"></label>
        <div class="layui-input-inline">
            <input type="radio" name="" value="1" title="是" class="layui-input" lay-verify="required"/>
            <input type="radio" name="" value="0" title="否" class="layui-input" lay-verify="required"/>
        </div>
    </div>

    <div class="layui-form-item layui-hide">
        <input type="button" lay-submit lay-filter="LAY-app-role-update" id="LAY-app-role-update"/>
    </div>
</div>

<script src="${appName}/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '${appName}/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form', 'admin', 'fims'], function () {
        var $ = layui.$,
            form = layui.form,
            admin = layui.admin,
            fims = layui.fims;

        // 应用名称
        var appName = '${appName}';
        var parameterCode = fims.getUrlParameter("parameterCode");
        var parameterCaption = fims.getUrlParameter("parameterCaption");
        var parameterValue = fims.getUrlParameter("parameterValue");

        var url = {
            update: appName + "/role/selectInitData"
        };

    })
</script>
</body>
</html>