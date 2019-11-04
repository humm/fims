<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户信息-列表</title>
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
                    <label class="layui-form-label">用户代码</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input" name="userCode">
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">用户名称</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input" name="userName">
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">用户状态</label>
                    <div class="layui-input-block">
                        <select name="userStatus"></select>
                    </div>
                </div>

                <!-- 查询按钮 -->
                <div class="layui-inline layui-inline-button">
                    <button class="layui-btn layuiadmin-btn-user-list" lay-submit
                            lay-filter="LAY-app-userlist-search">
                        <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                    </button>
                </div>

                <!-- 重置按钮 -->
                <div class="layui-inline layui-inline-button">
                    <button class="layui-btn layuiadmin-btn-user-list" lay-submit
                            lay-filter="LAY-app-userlist-refresh">
                        <i class="layui-icon layui-icon-refresh-1 layuiadmin-button-btn"></i>
                    </button>
                </div>
            </div>
        </div>

        <div class="layui-card-body">
            <!-- 头部操作按钮 -->
            <div style="padding-bottom: 10px;" id="LAY-app-user-list-button">
                <button class="layui-btn layuiadmin-btn-user-list" data-type="add">新增</button>
                <button class="layui-btn layuiadmin-btn-user-list" data-type="update">修改</button>
                <button class="layui-btn layuiadmin-btn-user-list" data-type="delete">删除</button>
                <button class="layui-btn layuiadmin-btn-user-list" data-type="reset">重置用户密码</button>
            </div>

            <!-- 列表数据 -->
            <table id="LAY-app-user-list" lay-filter="LAY-app-user-list"></table>

            <!-- 用户状态 -->
            <script type="text/html" id="userStatus">
                <button class="layui-btn layui-btn-xs layui-bg-{{ d.userStatusCode }}">{{ d.userStatus }}</button>
            </script>

            <!-- 用户类型 -->
            <script type="text/html" id="userType">
                {{#  if(d.userCode == 'admin'){ }}
                <button class="layui-btn layui-bg-1 layui-btn-xs">系统用户</button>
                {{#  } else{ }}
                <button class="layui-btn layui-bg-2 layui-btn-xs">普通用户</button>
                {{#  } }}
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
            fims = layui.fims;

        // 应用名称
        var appName = '${appName}';

        // 业务类型
        var businessType = "user";

        // 请求url
        var url = {
            init: appName + "/user/selectInitData",
            page: appName + "/user/selectPage",
            del: appName + "/user/delete",
            reset: appName + "/user/reset",
            save: appName + "/user/save",
            add: appName + "/user/view/add",
            update: appName + "/user/view/update",
            detail: appName + "/user/view/detail",
            check: appName + "/user/checkUserCode"
        }

        // 列表字段
        var tableColumn = [[
            {type: "checkbox", fixed: "left"},
            {field: "userId", title: "用户ID", sort: false, hide: true},
            {field: "userCode", title: "用户代码", sort: true},
            {field: "userName", title: "用户名称", sort: true},
            {field: "userStatus", title: "用户状态", align: "center", templet: "#userStatus", sort: true},
            {field: "userCode", title: "用户类型", align: "center", templet: "#userType"},
            {field: "userMemo", title: "用户备注"}
        ]];

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
            var userIds = [];
            var hasAdmin = false;
            for (var i = 0; i < data.length; i++) {
                userIds.push(data[i].userId);
                if (fims.config.adminCode == data[i].userCode) {
                    fims.msg(fims.tips.msg.systemUserNotDelete);
                    hasAdmin = true;
                    return;
                }
            }
            if (hasAdmin) {
                return;
            }
            layer.confirm(fims.tips.warn.confirmDel, function (index) {
                admin.req({
                    url: url.del,
                    type: "post",
                    data: {userIds: userIds.join(",")},
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

        // 重置用户密码
        var reset = function (data) {
            var userIds = [];
            for (var i = 0; i < data.length; i++) {
                userIds.push(data[i].userId);
            }
            layer.confirm(fims.tips.warn.confirmResetPassword, function (index) {
                admin.req({
                    url: url.reset,
                    type: "post",
                    data: {userIds: userIds.join(",")},
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
            if (fims.config.adminCode == data.userCode) {
                fims.msg(fims.tips.msg.systemUserNotUpdate);
                return;
            }
            var request = {
                userId: data.userId,
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
                userId: data.userId,
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
            // 获取角色信息
            var roleId = [];
            iframe.document.getElementsByName("roleId").forEach(function (item) {
                if (item.checked) {
                    roleId.push(item.value);
                }
            });
            iframe.layui.form.on("submit(LAY-app-" + businessType + "-" + type + ")", function (data) {
                // 校验用户代码格式
                var param = fims.clearBlank(data.field);
                var reg = /^[0-9a-zA-Z_]+$/;
                if (!reg.test(param.userCode)) {
                    fims.msg(fims.tips.msg.isNumberOrLetter);
                    return;
                }
                var userIsExist = false;
                // 校验用户代码是否存在
                admin.req({
                    url: url.check,
                    type: "get",
                    async: false,
                    data: fims.clearBlank(data.field),
                    done: function (response) {
                        if (response.bizResult) {
                            if (response.data) {
                                userIsExist = true;
                            }
                        } else {
                            fims.msg(response.msg);
                        }
                    }
                });
                if (!userIsExist) {
                    fims.msg(fims.tips.msg.userIsExist);
                    return;
                }
                data.field.roleId = roleId.join(",");
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
                case fims.operate.reset:
                    var convertData = new Array();
                    convertData.push(data);
                    reset(convertData);
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
                case fims.operate.reset:
                    if (checkData.length === 0) {
                        return fims.msg(fims.tips.warn.notSelect);
                    }
                    reset(checkData);
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
