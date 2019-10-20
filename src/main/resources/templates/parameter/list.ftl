<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>通讯录</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${appName}/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/admin.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/template.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/fims.css" media="all">
</head>
<body>


<div class="layui-fluid layadmin-maillist-fluid">
    <div class="layui-row layui-col-space15 parameter"></div>
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

        var url = {
            init: appName + "/parameter/selectList"
        };

        // 初始化页面信息
        admin.req({
            url: url.init,
            type: "get",
            dataType: "json",
            done: function (response) {
                if (response.bizResult) {
                    var parameterList = response.data;
                    if (!$.isEmptyObject(parameterList)) {
                        var item = "";
                        for (var i = 0; i < parameterList.length; i++) {
                            item += '<div class="layui-col-md4 layui-col-sm6">';
                            item += '   <div class="layadmin-contact-box">';
                            item += '       <div class="layui-col-md6 layui-col-sm6">';
                            item += '           <div>';
                            item += '               <div class="layadmin-maillist-img layadmin-font-blod">' + parameterList[i].parameterCaption + '</div>';
                            item += '           </div>';
                            item += '       </div>';
                            item += '       <div class="layui-col-md8 layadmin-padding-left20 layui-col-sm6">';
                            item += '           <p class="layadmin-textimg fims-padding-parameter">' + parameterList[i].parameterValue +
                                '</p>';
                            item += '       </div>';
                            item += '    </div>';
                            item += '</div>';
                        }
                        $(".parameter").append(item);
                    }
                    form.render();
                } else {
                    fims.msg(response.msg);
                }
            }
        });
    });
</script>
</body>
</html>