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
        <label class="layui-form-label">收入人</label>
        <div class="layui-input-inline">
            <select name="userId" lay-verify="required"></select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">收入来源</label>
        <div class="layui-input-inline">
            <select name="incomeCompany" lay-verify="required"></select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">收入类型</label>
        <div class="layui-input-inline">
            <select name="incomeType" lay-verify="required"></select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">收入金额</label>
        <div class="layui-input-inline">
            <input type="text" name="incomeAmount" class="layui-input" lay-verify="required|number" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">收入日期</label>
        <div class="layui-input-inline">
            <input type="text" name="incomeDate" id="incomeDate" class="layui-input" lay-verify="required" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">收入备注</label>
        <div class="layui-input-inline">
            <textarea name="incomeMemo" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-hide">
        <input type="button" lay-submit lay-filter="LAY-app-income-add" id="LAY-app-income-add">
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

        var url = appName + "/income/selectInitData";

        // 初始化页面信息
        admin.req({
            url: url,
            type: "get",
            dataType: "json",
            done: function (response) {
                if (response.bizResult) {
                    fims.setCondition("layui-form", response.data.condition);
                    if(response.data.mindFill){
                        var incomeType = response.data.lastType.incomeType;
                        $("select[name='incomeType']").val(incomeType);
                        $("select[name='userId']").find("option").last().attr("selected", true);
                        $("select[name='incomeCompany']").find("option").last().attr("selected", true);
                        $("#incomeDate").val(fims.getDate());
                        form.render();
                    }
                } else {
                    fims.msg(response.msg);
                }
            }
        });

        //年月选择器
        laydate.render({
            elem: '#incomeDate'
        });

    })
</script>
</body>
</html>