<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>收入信息-修改</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${appName}/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/fims.css" media="all">

</head>
<body>

<div class="layui-form" style="padding: 20px 30px 0 0;">
    <input type="hidden" name="incomeId"/>
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
            <input type="text" name="incomeAmount" class="layui-input" lay-verify="required|number">
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
        <input type="button" lay-submit lay-filter="LAY-app-income-update" id="LAY-app-income-update" />
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

        var request = {
            incomeId: fims.getUrlParameter("incomeId"),
            isTranslate: fims.getUrlParameter("isTranslate")
        }

        var url = {
            init: appName + "/income/selectInitData",
            load: appName + "/income/selectOne?" + $.param(request)
        };

        // 初始化页面信息
        admin.req({
            url: url.init,
            type: "get",
            dataType: "json",
            done: function (response) {
                if (response.bizResult) {
                    fims.setCondition("layui-form", response.data.condition);
                    form.render();
                    // 数据回填
                    admin.req({
                        url: url.load,
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
                } else {
                    fims.msg(response.msg);
                }
            }
        });

        //年月选择器
        laydate.render({
            elem: '#incomeDate',
            trigger: 'click'
        });

    })
</script>
</body>
</html>