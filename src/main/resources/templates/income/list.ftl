<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>收入信息-列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${appName}/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/admin.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/fims.css" media="all">

</head>
<body>
<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-form layui-card-header layuiadmin-card-header-auto">
            <div class="layui-form-item">
                <!-- 查询条件 -->
                <div class="layui-inline">
                    <label class="layui-form-label">收入人</label>
                    <div class="layui-input-block">
                        <select name="userId"></select>
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">收入来源</label>
                    <div class="layui-input-block">
                        <select name="incomeCompany"></select>
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">收入类型</label>
                    <div class="layui-input-block">
                        <select name="incomeType"></select>
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">收入日期</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input" name="incomeDate" id="incomeDate">
                    </div>
                </div>

                <!-- 查询按钮 -->
                <div class="layui-inline layui-inline-button">
                    <button class="layui-btn layuiadmin-btn-income-list" lay-submit
                            lay-filter="LAY-app-incomelist-search">
                        <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                    </button>
                </div>

                <!-- 重置按钮 -->
                <div class="layui-inline layui-inline-button">
                    <button class="layui-btn layuiadmin-btn-income-list" lay-submit
                            lay-filter="LAY-app-incomelist-refresh">
                        <i class="layui-icon layui-icon-refresh-1 layuiadmin-button-btn"></i>
                    </button>
                </div>

            </div>
        </div>

        <div class="layui-card-body">
            <!-- 头部操作按钮 -->
            <div style="padding-bottom: 10px;" id="LAY-app-income-list-button">
                <button class="layui-btn layuiadmin-btn-income-list" data-type="add">新增</button>
                <button class="layui-btn layuiadmin-btn-income-list" data-type="update">修改</button>
                <button class="layui-btn layuiadmin-btn-income-list" data-type="delete">删除</button>
            </div>

            <!-- 列表数据 -->
            <table id="LAY-app-income-list" lay-filter="LAY-app-income-list"></table>

            <!-- 用户类型 -->
            <script type="text/html" id="incomeType">
                <button class="layui-btn layui-btn-xs layui-bg-{{ d.incomeTypeCode }}">{{ d.incomeType }}</button>
            </script>

            <!-- 来源类型 -->
            <script type="text/html" id="incomeCompany">
                <button class="layui-btn layui-btn-xs layui-bg-{{ d.incomeCompanyCode }}">{{ d.incomeCompany }}</button>
            </script>

        </div>
    </div>
</div>

<script src="${appName}/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '${appName}/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table', 'laydate', 'admin', 'fims'], function () {
        var $ = layui.$,
            form = layui.form,
            table = layui.table,
            admin = layui.admin,
            fims = layui.fims,
            laydate = layui.laydate;

        // 应用名称
        var appName = '${appName}';

        // 是否管理员
        var hasButton = ${hasButton?string('true','false')};

        // 业务类型
        var businessType = "income";

        // 请求url
        var url = {
            init: appName + "/income/selectInitData",
            page: appName + "/income/selectPage",
            del: appName + "/income/delete",
            save: appName + "/income/save",
            add: appName + "/income/view/add",
            update: appName + "/income/view/update",
            detail: appName + "/income/view/detail"
        }

        // 列表字段
        var tableColumn = [[
            {type: "checkbox", fixed: "left"},
            {field: "incomeId", title: "收入序列号", sort: false, hide: true},
            {field: "userId", title: "收入人", sort: true},
            {field: "incomeDate", title: "收入日期", align: 'center', sort: true},
            {field: "incomeCompany", title: "收入来源", templet: "#incomeCompany", sort: true},
            {field: "incomeType", title: "收入类型", templet: "#incomeType", sort: true},
            {field: "incomeAmount", title: "收入金额", sort: true},
            {field: "incomeMemo", title: "收入备注"}
        ]];

        // 年月选择器
        laydate.render({
            elem: '#incomeDate',
            type: 'month'
        });

        // 权限按钮设置
        fims.setAuthority(hasButton, "LAY-app-" + businessType + "-list-button");

        // 初始化页面信息
        admin.req({
            url: url.init,
            type: "get",
            dataType: "json",
            done: function (response) {
                if (response.bizResult) {
                    // 设置查询条件
                    fims.setCondition("layui-form-item", response.data.condition);
                } else {
                    fims.msg(response.msg);
                }
            }
        });

        // 数据删除
        var del = function (data) {
            var incomeIds = [];
            for (var i = 0; i < data.length; i++) {
                incomeIds.push(data[i].incomeId);
            }
            layer.confirm(fims.tips.warn.confirmDel, function (index) {
                admin.req({
                    url: url.del,
                    type: "post",
                    data: {incomeIds: incomeIds.join(",")},
                    done: function (response) {
                        if (response.bizResult) {
                            setTimeout(function () {
                                layer.close(index);
                                reloadData(fims.getValue("layui-form-item"));
                                fims.msg(response.msg);
                            }, 500);
                        } else {
                            fims.msg(response.msg);
                        }
                    }
                });
            });
        }

        // 数据新增
        var add = function (data) {
            layer.open({
                type: 2,
                title: fims.tips.title.add,
                content: url.add,
                area: ["450px", "500px"],
                btn: [fims.tips.btn.save, fims.tips.btn.cancel],
                resize: fims.set.resize,
                yes: function (e, t) {
                    save(e, t, fims.operate.add, data);
                }
            });
        }

        // 数据修改
        var update = function (data) {
            var request = {
                incomeId: data.incomeId,
                isTranslate: "0"
            }
            layer.open({
                type: 2,
                title: fims.tips.title.update,
                content: url.update + "?" + $.param(request),
                area: ["450px", "500px"],
                btn: [fims.tips.btn.save, fims.tips.btn.cancel],
                resize: fims.set.resize,
                yes: function (e, t) {
                    save(e, t, fims.operate.update, data);
                }
            });
        }

        // 数据详情
        var detail = function (data) {
            var request = {
                incomeId: data.incomeId,
                isTranslate: "1"
            }
            layer.open({
                type: 2,
                title: fims.tips.title.detail,
                content: url.detail + "?" + $.param(request),
                area: ["450px", "450px"],
                resize: false
            });
        }

        // 数据保存
        var save = function (e, t, type, data) {
            var iframe = window["layui-layer-iframe" + e],
                button = t.find("iframe").contents().find("#LAY-app-" + businessType + "-" + type);
            iframe.layui.form.on("submit(LAY-app-" + businessType + "-" + type +")", function (data) {
                admin.req({
                    url: url.save,
                    type: "post",
                    data: fims.clearBlank(data.field),
                    done: function (response) {
                        if (response.bizResult) {
                            setTimeout(function () {
                                reloadData(fims.getValue("layui-form-item"));
                                layer.close(e);
                                fims.msg(response.msg);
                            }, 500);
                        } else {
                            fims.msg(response.msg);
                        }
                    }
                });
            }), button.trigger("click");
        }

        // 列表数据渲染
        table.render({
            elem: "#LAY-app-" + businessType + "-list",
            url: url.page,
            cols: tableColumn,
            autoSort: false, // 禁用前端自动排序
            page: true,
            limit: 10,
            limits: [10, 30, 50, 100, 500],
            text: {
                none: fims.tips.msg.emptyData
            }
        });

        // 行数据按钮事件绑定 暂未启用
        table.on("tool(LAY-app-" + businessType + "-list)", function (obj) {
            // 获取数据值
            var data = obj.data;
            switch (obj.event) {
                case fims.operate.delete:
                    var convertData = new Array();
                    convertData.push(data);
                    del(convertData);
                    break;
                case fims.operate.detail:
                    detail(data);
                    break;
                case fims.operate.add:
                    add(data);
                    break;
                case fims.operate.update:
                    update(data);
                    break;
                default:
                    fims.msg(fims.tips.msg.notSupportEvent);
                    break;
            }
        });

        // table按钮事件监听
        $(".layui-btn.layuiadmin-btn-" + businessType + "-list").on("click", function () {

            // 获取选中的数据
            var checkData = table.checkStatus("LAY-app-" + businessType + "-list").data;

            var type = $(this).data("type");
            if (fims.isBlank(type)) {
                return;
            }
            switch (type) {
                case fims.operate.add:
                    add();
                    break;
                case fims.operate.update:
                    if (checkData.length === 0) {
                        return fims.msg(fims.tips.warn.notSelect);
                    }
                    if (checkData.length > 1) {
                        return fims.msg(fims.tips.warn.selectOne);
                    }
                    update(checkData[0]);
                    break;
                case fims.operate.delete:
                    if (checkData.length === 0) {
                        return fims.msg(fims.tips.warn.notSelect);
                    }
                    del(checkData);
                    break;
                default:
                    fims.msg(fims.tips.msg.notSupportEvent);
            }
        });

        // 监听查询
        form.on("submit(LAY-app-" + businessType + "list-search)", function (data) {
            //执行重载
            reloadData(fims.getValue("layui-form-item"));
        });

        // 监听重置
        form.on("submit(LAY-app-" + businessType + "list-refresh)", function (data) {
            fims.clearValue("layui-form-item");
            //执行重载
            reloadData({});
        });

        // 监听列表排序
        table.on("sort(LAY-app-" + businessType + "-list)", function (data) {
            table.reload("LAY-app-" + businessType + "-list", {
                initSort: data,
                where: $.extend({
                    sort: data.field,
                    order: data.type
                }, fims.clearBlank(fims.getValue("layui-form-item")))
            });
        });

        // 监听双击事件
        table.on("rowDouble(LAY-app-" + businessType + "-list)", function (obj) {
            detail(obj.data);
        });

        // 重载列表数据
        var reloadData = function (data) {
            table.reload("LAY-app-" + businessType + "-list", {
                where: fims.clearBlank(data)
            });
        }

    });
</script>
</body>
</html>
