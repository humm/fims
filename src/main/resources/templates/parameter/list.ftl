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
</head>
<body>


<div class="layui-fluid layadmin-maillist-fluid">
    <div class="layui-row layui-col-space15">
        <div class='layui-col-md4 layui-col-sm6'>
            <div class='layadmin-contact-box'>
                <div class='layui-col-md8 layadmin-padding-left20 layui-col-sm6'>
                    <a href='javascript:;'><p class='layadmin-textimg'><i class='layui-icon layui-icon-reply-fill'></i>
                        </p>layui-icon-reply-fill </a>
                </div>
            </div>
        </div>
        <div class='layui-col-md4 layui-col-sm6'>
            <div class='layadmin-contact-box'>
                <div class='layui-col-md8 layadmin-padding-left20 layui-col-sm6'>
                    <a href='javascript:;'><p class='layadmin-textimg'><i class='layui-icon layui-icon-set-fill'></i>
                        </p>layui-icon-set-fill </a>
                </div>
            </div>
        </div>
        <div class='layui-col-md4 layui-col-sm6'>
            <div class='layadmin-contact-box'>
                <div class='layui-col-md8 layadmin-padding-left20 layui-col-sm6'>
                    <a href='javascript:;'><p class='layadmin-textimg'><i class='layui-icon layui-icon-menu-fill'></i>
                        </p>layui-icon-menu-fill </a>
                </div>
            </div>
        </div>
        <div class='layui-col-md4 layui-col-sm6'>
            <div class='layadmin-contact-box'>
                <div class='layui-col-md8 layadmin-padding-left20 layui-col-sm6'>
                    <a href='javascript:;'><p class='layadmin-textimg'><i class='layui-icon layui-icon-search'></i></p>
                        layui-icon-search </a>
                </div>
            </div>
        </div>
        <div class='layui-col-md4 layui-col-sm6'>
            <div class='layadmin-contact-box'>
                <div class='layui-col-md8 layadmin-padding-left20 layui-col-sm6'>
                    <a href='javascript:;'><p class='layadmin-textimg'><i class='layui-icon layui-icon-share'></i></p>
                        layui-icon-share </a>
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
    }).use(['index']);
</script>
</body>
</html>