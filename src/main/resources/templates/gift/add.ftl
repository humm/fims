<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>收入信息-新增</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${appName}/layuiadmin/layui/css/layui.css" media="all">
</head>
<body>

<div class="layui-form" style="padding: 20px 30px 0 0;">
    <div class="layui-form-item">
        <label class="layui-form-label">送礼人</label>
        <div class="layui-input-inline">
            <select name="giftSender" lay-verify="required"></select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">收礼人</label>
        <div class="layui-input-inline">
            <select name="giftReceiver" lay-verify="required"></select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">随礼类型</label>
        <div class="layui-input-inline">
            <select name="giftType" lay-verify="required"></select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">随礼金额</label>
        <div class="layui-input-inline">
            <input type="text" name="giftAmount" class="layui-input" lay-verify="required|number" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">随礼日期</label>
        <div class="layui-input-inline">
            <input type="text" name="giftDate" id="giftDate" class="layui-input" lay-verify="required" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">随礼备注</label>
        <div class="layui-input-inline">
            <textarea name="giftMemo" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-hide">
        <input type="button" lay-submit lay-filter="LAY-app-gift-add" id="LAY-app-gift-add">
    </div>
</div>

<script src="${appName}/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '${appName}/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form', 'laydate', 'admin', 'fims'], function () {
        var $ = layui.$,
            form = layui.form,
            admin = layui.admin,
            laydate = layui.laydate,
            fims = layui.fims;

        // 应用名称
        var appName = '${appName}';

        var url = appName + "/gift/selectInitData";

        // 初始化页面信息
        admin.req({
            url: url,
            type: "get",
            dataType: "json",
            done: function (response) {
                if (response.bizResult) {
                    fims.setCondition("layui-form", response.data.condition);
                    if(response.data.mindFill){
                        var giftType = response.data.lastType.giftType;
                        $("select[name='giftType']").val(giftType);
                        $("#giftDate").val(fims.getDate());
                        form.render();
                    }
                } else {
                    layer.msg(response.msg);
                }
            }
        });

        //年月选择器
        laydate.render({
            elem: '#giftDate'
        });

    })
</script>
</body>
</html>