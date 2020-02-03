<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登入</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${appName}/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/admin.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/login.css" media="all">
</head>
<body>

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2>${appDescribe}</h2>
        </div>
        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-username"
                       for="LAY-user-login-username"></label>
                <input type="text" name="userCode" id="LAY-user-login-username" lay-verify="required"
                       placeholder="账号" class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password"
                       for="LAY-user-login-password"></label>
                <input type="password" name="userPassword" id="LAY-user-login-password" lay-verify="required"
                       placeholder="密码" class="layui-input">
            </div>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit">登 入</button>
            </div>
        </div>
    </div>

    <div class="layui-trans layadmin-user-login-footer">
        <p>版本号：${version}</p>
    </div>
</div>

<script src="${appName}/layuiadmin/layui/layui.js"></script>
<script src="${appName}/layuiadmin/lib/extend/base64.min.js"></script>
<script>
    layui.config({
        base: '${appName}/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'user', 'fims'], function () {
        var $ = layui.$,
            admin = layui.admin,
            fims = layui.fims,
            form = layui.form;

        form.render();

        // 应用名称
        var appName = '${appName}';

        //提交
        form.on('submit(LAY-user-login-submit)', function (obj) {
            obj.field.userPassword = Base64.encode(obj.field.userPassword);
            //请求登入接口
            admin.req({
                url: appName + '/user/login',
                type: 'post',
                data: obj.field,
                done: function (response) {
                    if (response.bizResult) {
                        location.href = appName + fims.config.index;
                    } else {
                        fims.msg(response.msg);
                    }
                }
            });
        });

        // 监听回车事件
        document.onkeydown = function (ev) {
            var event = ev || event
            if (event.keyCode == 13) {
                $(".layui-btn").click();
            }
        }
    });
</script>
</body>
</html>