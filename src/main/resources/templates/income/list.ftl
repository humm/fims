<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>收入信息</title>
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
                    <label class="layui-form-label">ID</label>
                    <div class="layui-input-block">
                        <input type="text" name="id" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">发帖人</label>
                    <div class="layui-input-block">
                        <input type="text" name="poster" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">帖子状态</label>
                    <div class="layui-input-block">
                        <select name="top">
                            <option value="0">正常</option>
                            <option value="1">置顶</option>
                            <option value="2">封禁</option>
                        </select>
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

            <!--行数据按钮 -->
            <script type="text/html" id="table-income-list">
                <a class="layui-btn layui-btn-xs" lay-event="edit">
                    <i class="layui-icon"></i>修改</a>
                <a class="layui-btn layui-btn-xs" lay-event="delete">
                    <i class="layui-icon"></i>删除</a>
                <a class="layui-btn layui-btn-xs" lay-event="detail">
                    <i class="layui-icon"></i>详情</a>
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
    }).use(['index', 'fims', 'table'], function () {
        var $ = layui.$, form = layui.form, table = layui.table, fims = layui.fims;

        var appName = '${appName}';

        var url = {
            page: appName + "/income/selectPage",
            select: appName + "/income/selectOne",
            del: appName + "/income/delete",
            add: appName + "/income/view/add",
            edit: appName + "/income/view/edit",
            detail: appName + "/income/view/detail"
        }

        // 权限设置
        fims.setAuthority(false, "table-income-list,LAY-app-income-list-button");

        // 列表数据渲染
        table.render({
            elem: "#LAY-app-income-list",
            url: url.page,
            cols: [
                [
                    {type: "checkbox", fixed: "left"},
                    {field: "incomeId", title: "收入序列号", sort: false, hide: true},
                    {field: "userId", title: "收入人", sort: true},
                    {field: "incomeDate", title: "收入日期", sort: true},
                    {field: "incomeCompany", title: "收入来源", sort: true},
                    {field: "incomeType", title: "收入类型", sort: true},
                    {field: "incomeAmount", title: "收入金额", sort: true},
                    {field: "incomeMemo", title: "收入备注"},
                    {title: "操作", width: 180, align: "center", fixed: "right", toolbar: "#table-income-list"}
                ]
            ],
            page: true,
            limit: 10,
            limits: [10, 15, 20, 25, 30],
            text: "数据加载出现异常"
        });

        // 行数据按钮事件绑定
        table.on("tool(LAY-app-income-list)", function (obj) {
            // 获取数据值
            var data = obj.data;
            switch (obj.event) {
                case "delete":
                    var convertData = new Array();
                    convertData.push(data);
                    del(convertData);
                    break;
                case "detail":
                    detail(data);
                    break;
                case "add":
                    add(data);
                    break;
                case "edit":
                    edit(data);
                    break;
                default:
                    layer.alert("不支持的事件类型");
                    break;
            }
        });

        table.on('rowDouble(LAY-app-income-list)', function(obj){
            detail(obj.data);
        });

        // table按钮事件监听
        $('.layui-btn.layuiadmin-btn-income-list').on('click', function () {

            // 获取选中的数据
            var checkData = table.checkStatus('LAY-app-income-list').data;

            var type = $(this).data('type');
            switch (type) {
                case "add":
                    add();
                    break;
                case "edit":
                    if (checkData.length === 0) {
                        return layer.msg(fims.tips.warn.notSelect);
                    }
                    if (checkData.length > 1) {
                        return layer.msg(fims.tips.warn.selectOne);
                    }
                    edit(checkData[0]);
                    break
                case "delete":
                    if (checkData.length === 0) {
                        return layer.msg(fims.tips.warn.notSelect);
                    }
                    del(checkData);
                    break;
                default:
                    layer.alert("不支持的事件类型");
            }
        });

        //监听搜索
        form.on('submit(LAY-app-incomelist-search)', function (data) {
            var field = data.field;
            //执行重载
            table.reload('LAY-app-income-list', {
                where: field
            });
        });

        // 数据删除
        var del = function (data) {
            console.log(data);
            layer.confirm(fims.tips.warn.confirmDel, function (index) {
                // 删除数据
                layer.close(index);
            });
            table.reload('LAY-app-income-list');
        }

        // 数据新增
        var add = function (data) {
            console.log(data);
            layer.open({
                type: 2,
                title: fims.tips.title.add,
                content: url.add,
                area: [fims.set.area.height, fims.set.area.width],
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
                area: [fims.set.area.height, fims.set.area.width],
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
                area: [fims.set.area.height, fims.set.area.width],
                btn: [fims.tips.btn.ok, fims.tips.btn.cancel],
                resize: false
            });
        }


        /* if ("del" === e.event) layer.confirm("确定删除此条帖子？", function (t) {
             e.del(), layer.close(t)
         }); else if ("edit" === e.event) {
             $(e.tr);
             layer.open({
                 type: 2,
                 title: "编辑帖子",
                 content: "../../../views/app/income/listform.html",
                 area: ["550px", "400px"],
                 btn: ["确定", "取消"],
                 resize: !1,
                 yes: function (e, t) {
                     var l = window["layui-layer-iframe" + e], r = "LAY-app-income-submit",
                         o = t.find("iframe").contents().find("#" + r);
                     l.layui.form.on("submit(" + r + ")", function (t) {
                         t.field;
                         i.reload("LAY-app-income-list"), layer.close(e)
                     }), o.trigger("click")
                 },
                 success: function (e, t) {
                 }
             })
         }
     });
*/


    });
</script>
</body>
</html>
