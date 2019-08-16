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
                        <select name="userId">
                            <option value=""></option>
                            <option value="111">AAA</option>
                            <option value="222">BBB</option>
                            <option value="333">CCC</option>
                        </select>
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">收入来源</label>
                    <div class="layui-input-block">
                        <select name="incomeCompany">
                            <option value=""></option>
                            <option value="DDD">DDD</option>
                            <option value="EEE">EEE</option>
                            <option value="FFF">FFF</option>
                        </select>
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">收入类型</label>
                    <div class="layui-input-block">
                        <select name="incomeType">
                            <option value=""></option>
                            <option value="GGG">GGG</option>
                            <option value="JJJ">JJJ</option>
                            <option value="HHH">HHH</option>
                        </select>
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">收入日期</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input" name="incomeDate" id="incomeDate" placeholder="yyyy-MM">
                    </div>
                </div>


                <!-- 查询按钮 -->
                <div class="layui-inline">
                    <button class="layui-btn layuiadmin-btn-income-list" lay-submit
                            lay-filter="LAY-app-incomelist-search">
                        <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                    </button>
                </div>

            </div>
        </div>

        <div class="layui-card-body">
            <!-- 头部操作按钮 -->
            <div style="padding-bottom: 10px;" id="LAY-app-income-list-button">
                <button class="layui-btn layuiadmin-btn-income-list" data-type="add">新增</button>
                <button class="layui-btn layuiadmin-btn-income-list" data-type="edit">修改</button>
                <button class="layui-btn layuiadmin-btn-income-list" data-type="delete">删除</button>
            </div>

            <!-- 列表数据 -->
            <table id="LAY-app-income-list" lay-filter="LAY-app-income-list"></table>

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

        // 业务类型
        var businessType = "income";

        // 请求url
        var url = {
            page: appName + "/income/selectPage",
            select: appName + "/income/selectOne",
            del: appName + "/income/delete",
            add: appName + "/income/view/add",
            edit: appName + "/income/view/edit",
            detail: appName + "/income/view/detail"
        }

        // 列表字段
        var tableColumn = [[
            {type: "checkbox", fixed: "left"},
            {field: "incomeId", title: "收入序列号", sort: false, hide: true},
            {field: "userId", title: "收入人", sort: true},
            {field: "incomeDate", title: "收入日期", align: 'center', sort: true},
            {field: "incomeCompany", title: "收入来源", sort: true},
            {field: "incomeType", title: "收入类型", sort: true},
            {field: "incomeAmount", title: "收入金额", sort: true},
            {field: "incomeMemo", title: "收入备注"}
        ]];

        //年月选择器
        laydate.render({
            elem: '#incomeDate'
            , type: 'month'
        });

        // 数据删除
        var del = function (data) {
            console.log(data);
            layer.confirm(fims.tips.warn.confirmDel, function (index) {
                admin.req({
                    url: url.del,
                    type: "post",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(data),
                    done: function (response) {
                        if (response.bizResult) {
                            setTimeout(function () {
                                layer.close(index);
                                table.reload("LAY-app-" + businessType + "-list");
                                layer.msg(fims.tips.msg.delSuccess);
                            }, 500);
                        } else {
                            layer.msg(response.msg);
                        }
                    }
                });
            });
        }

        // 数据新增
        var add = function (data) {
            console.log(data);
            layer.open({
                type: 2,
                title: fims.tips.title.add,
                content: url.add,
                area: fims.set.area.defaut,
                btn: [fims.tips.btn.ok, fims.tips.btn.cancel],
                resize: false
            });
        }

        // 数据修改
        var edit = function (data) {
            console.log(data);
            layer.open({
                type: 2,
                title: fims.tips.title.edit,
                content: url.edit,
                area: fims.set.area.defaut,
                btn: [fims.tips.btn.ok, fims.tips.btn.cancel],
                resize: false
            });
        }

        // 数据详情
        var detail = function (data) {
            console.log(data);
            layer.open({
                type: 2,
                title: fims.tips.title.detail,
                content: url.detail,
                area: fims.set.area.defaut,
                btn: [fims.tips.btn.ok, fims.tips.btn.cancel],
                resize: false
            });
        }

        // 权限按钮设置
        fims.setAuthority(false, "LAY-app-" + businessType + "-list-button");

        // 列表数据渲染
        table.render({
            elem: "#LAY-app-" + businessType + "-list",
            url: url.page,
            cols: tableColumn,
            autoSort: false, // 禁用前端自动排序
            page: true,
            limit: 10,
            limits: [10, 15, 20, 25, 30],
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
                case fims.operate.edit:
                    edit(data);
                    break;
                default:
                    layer.alert(fims.tips.msg.notSupportEvent);
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
                case fims.operate.edit:
                    if (checkData.length === 0) {
                        return layer.msg(fims.tips.warn.notSelect);
                    }
                    if (checkData.length > 1) {
                        return layer.msg(fims.tips.warn.selectOne);
                    }
                    edit(checkData[0]);
                    break
                case fims.operate.delete:
                    if (checkData.length === 0) {
                        return layer.msg(fims.tips.warn.notSelect);
                    }
                    del(checkData);
                    break;
                default:
                    layer.alert(fims.tips.msg.notSupportEvent);
            }
        });

        //监听查询
        form.on("submit(LAY-app-" + businessType + "list-search)", function (data) {
            console.log(fims.clearBlank(data.field));
            //执行重载
            table.reload("LAY-app-" + businessType + "-list", {
                where: fims.clearBlank(data.field)
            });
        });

        //  监听列表排序
        table.on("sort(LAY-app-" + businessType + "-list)", function (data) {
            table.reload("LAY-app-" + businessType + "-list", {
                initSort: data,
                where: {
                    sort: data.field,
                    order: data.type
                }
            });
        });

        // 监听双击事件
        table.on("rowDouble(LAY-app-" + businessType + "-list)", function (obj) {
            detail(obj.data);
        });

    });
</script>
</body>
</html>
