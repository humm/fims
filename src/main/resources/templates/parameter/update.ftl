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

<div class="layui-form parameter" style="padding: 20px 30px 0 0;">

    <div class="layui-form-item layui-hide">
        <input type="button" lay-submit lay-filter="LAY-app-parameter-update" id="LAY-app-parameter-update"/>
    </div>
</div>

<script src="${appName}/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '${appName}/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form', 'admin', 'fims', 'laydate'], function () {
        var $ = layui.$,
            form = layui.form,
            admin = layui.admin,
            laydate = layui.laydate,
            fims = layui.fims;

        // 应用名称
        var parameterCode = fims.getUrlParameter("parameterCode");
        var parameterValue = decodeURI(fims.getUrlParameter("parameterValue"));
        var parameterOldValue = decodeURI(fims.getUrlParameter("parameterOldValue"));
        var parameterType = fims.getUrlParameter("parameterType");
        var parameterExt = fims.getUrlParameter("parameterExt");
        var maxlength = fims.isBlank(parameterExt) ? 150 : parameterExt;
        var item = "";
        if (parameterType == 'text' || fims.isBlank(parameterType)) {
            item += '<div class="layui-form-item">';
            item += '   <div class="layui-input-inline" style="margin: 0 0 10px 30px;">';
            item += '       <input type="text" name="' + parameterCode + '" class="layui-input"';
            item += '        lay-verify="required" maxlength="' + maxlength + '" />';
            item += '   </div>';
            item += '</div>';
        } else if (parameterType == 'number') {
            item += '<div class="layui-form-item input">';
            item += '   <div class="layui-input-inline" style="margin: 0 0 10px 30px;">';
            item += '       <input type="text" name="' + parameterCode + '" class="layui-input"';
            item += '        lay-verify="required|number" maxlength="' + maxlength+ '" />';
            item += '   </div>';
            item += '</div>';
        } else if (parameterType == 'switch') {
            item += '<div class="layui-form-item">';
            item += '    <div class="layui-input-inline" style="margin: 0 0 10px 30px;">';
            item += '       <input type="checkbox" name="' + parameterCode + '" lay-skin="switch"';
            item += '        lay-text="开启|关闭" />';
            item += '    </div>';
            item += '</div>';
        } else if (parameterType == 'date') {
            item += '<div class="layui-form-item">';
            item += '   <div class="layui-input-inline" style="margin: 0 0 10px 30px;">';
            item += '       <input type="text" name="' + parameterCode + '" class="layui-input"';
            item += '        lay-verify="required|number" maxlength="' + maxlength + '" />';
            item += '   </div>';
            item += '</div>';
        }
        $(".parameter").append(item);
        // 设置value值
        if (parameterType == 'switch' && parameterOldValue == '1') {
            $("input[name='" + parameterCode + "']").attr("checked", true);
        } else {
            $("input[name='" + parameterCode + "']").val(parameterValue);
        }
        form.render();

    })
</script>
</body>
</html>