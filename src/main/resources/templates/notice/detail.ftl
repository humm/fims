<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>消息通知信息-详情</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${appName}/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/fims.css" media="all">
</head>
<body>

<div class="layui-form" style="padding: 20px 30px 0 0;">
    <div class="layui-form-item">
        <label class="layui-form-label">消息用户</label>
        <div class="layui-input-inline">
            <input type="text" name="userId" class="layui-input layui-detail" disabled="disabled" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">业务类型</label>
        <div class="layui-input-inline">
            <input type="text" name="businessType" class="layui-input layui-detail" disabled="disabled" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">业务子类型</label>
        <div class="layui-input-inline">
            <input type="text" name="businessSubType" class="layui-input layui-detail" disabled="disabled" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">业务时间</label>
        <div class="layui-input-inline">
            <input type="text" name="businessDate" class="layui-input layui-detail" disabled="disabled" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">业务金额</label>
        <div class="layui-input-inline">
            <input type="text" name="businessAmount" class="layui-input layui-detail" disabled="disabled" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">通知状态</label>
        <div class="layui-input-inline">
            <input type="text" name="noticeStatus" class="layui-input layui-detail" disabled="disabled" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">通知类型</label>
        <div class="layui-input-inline">
            <input type="text" name="noticeType" class="layui-input layui-detail" disabled="disabled" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">阅读状态</label>
        <div class="layui-input-inline">
            <input type="text" name="readStatus" class="layui-input layui-detail" disabled="disabled" />
        </div>
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

        var request = {
            noticeId: fims.getUrlParameter("noticeId"),
            isTranslate: fims.getUrlParameter("isTranslate")
        }

        // 请求url
        var url = appName + "/notice/selectOne?" + $.param(request);

        // 初始化页面信息
        admin.req({
            url: url,
            type: "get",
            dataType: "json",
            done: function (response) {
                if (response.bizResult) {
                    fims.setValue("layui-form", response.data);
                } else {
                    fims.msg(response.msg);
                }
            }
        });

    })
</script>
</body>
</html>