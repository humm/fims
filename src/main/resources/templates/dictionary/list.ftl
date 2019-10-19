<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>字典信息-列表</title>
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
                    <label class="layui-form-label">字典代码</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input" name="dictionaryCode">
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">字典描述</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input" name="dictionaryCaption">
                    </div>
                </div>


                <!-- 重置按钮 -->
                <div class="layui-inline layui-inline-button">
                    <button class="layui-btn layuiadmin-btn-dictionary-list" lay-submit
                            lay-filter="LAY-app-dictionarylist-refresh">
                        <i class="layui-icon layui-icon-refresh-1 layuiadmin-button-btn"></i>
                    </button>
                </div>
                <!-- 查询按钮 -->
                <div class="layui-inline layui-inline-button">
                    <button class="layui-btn layuiadmin-btn-dictionary-list" lay-submit
                            lay-filter="LAY-app-dictionarylist-search">
                        <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                    </button>
                </div>

            </div>
        </div>

        <div class="layui-card-body">
            <!-- 头部操作按钮 -->
            <div style="padding-bottom: 10px;" id="LAY-app-dictionary-list-button">
                <button class="layui-btn layuiadmin-btn-dictionary-list" data-type="update">修改</button>
            </div>

            <!-- 列表数据 -->
            <table id="LAY-app-dictionary-list" lay-filter="LAY-app-dictionary-list"></table>

            <!-- 用户类型 -->
            <script type="text/html" id="openStatus">
                {{#  if(d.isOpen == '1'){ }}
                <button class="layui-btn layui-bg-gray layui-btn-xs">开放</button>
                {{#  } else{ }}
                <button class="layui-btn layui-bg-black layui-btn-xs">封闭</button>
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

        // 是否按钮权限
        var hasButton = ${hasButton?string('true','false')};

        // 业务类型
        var businessType = "dictionary";

        // 请求url
        var url = {
            page: appName + "/dictionary/selectPage",
            save: appName + "/dictionary/save",
            update: appName + "/dictionary/view/update",
            detail: appName + "/dictionary/view/detail"
        }

        // 列表字段
        var tableColumn = [[
            {type: "checkbox", fixed: "left"},
            {field: "dictionaryCode", title: "字典代码", sort: true,},
            {field: "dictionaryCaption", title: "字典描述", sort: true},
            {field: "dictionaryCaption", title: "开放状态", align: "center", templet: "#openStatus", sort: true},
            {field: "userId", title: "字典用户", hide: true},
        ]];

        // 权限按钮设置
        fims.setAuthority(hasButton, "LAY-app-" + businessType + "-list-button");

        // 数据删除
        var del = function (data) {

        }

        // 数据新增
        var add = function (data) {

        }

        // 数据修改
        var update = function (data) {
            if('0' == data.isOpen ){
                fims.msg(fims.tips.msg.closeDictionaryNotUpdate, {time: 1000});
                return;
            }
            var request = {
                dictionaryCode: data.dictionaryCode,
                dictionaryCaption: encodeURI(data.dictionaryCaption),
                isOpen: data.isOpen,
                isTranslate: "0"
            }
            layer.open({
                type: 2,
                title: fims.tips.title.update,
                content: url.update + "?" + $.param(request),
                area: ["1100px", "450px"],
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
                dictionaryCode: data.dictionaryCode,
                dictionaryCaption: encodeURI(data.dictionaryCaption),
                isOpen: data.isOpen,
                isTranslate: "1"
            }
            layer.open({
                type: 2,
                title: fims.tips.title.detail,
                content: url.detail + "?" + $.param(request),
                area: ["1000px", "450px"],
                resize: false
            });
        }

        // 数据保存
        var save = function (e, t, type, data) {
            var iframe = window["layui-layer-iframe" + e],
                button = t.find("iframe").contents().find("#LAY-app-" + businessType + "-" + type);
            var elements = [];
            var flag = false;
            t.find("iframe").contents().find(".layui-form-item-dictionary").each(function (index) {
                if (flag) {
                    return;
                }
                var that = this;
                var item = {};
                $(that).find("[name]").each(function () {
                    var name = $(this).attr("name");
                    var value = $(this).val();
                    item[name] = value;
                    if ((name == "userId" && data.isOpen == '0') || fims.isBlank(name)) {
                        // 选值用户 未开放状态 不校验
                    } else if (fims.isBlank(value)) {
                        var title = $(this).parent().prev().html();
                        fims.msg(title + " " + fims.tips.msg.notEmpty, {time: 1000});
                        flag = true;
                        return;
                    }
                });
                item["dictionaryCode"] = data.dictionaryCode;
                item["isOpen"] = data.isOpen;
                item["itemOrder"] = index + 1;
                elements.push(item);
            });
            if (flag) {
                return;
            }
            // 若为空添加默认字典代码
            if($.isEmptyObject(elements)){
                var item = {
                    dictionaryCode: data.dictionaryCode,
                    isOpen: data.isOpen
                }
                elements.push(item);
            }
            iframe.layui.form.on("submit(LAY-app-" + businessType + "-" + type + ")", function (data) {
                admin.req({
                    url: url.save,
                    type: "post",
                    contentType:"application/json",
                    data: JSON.stringify(elements),
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
                where: {
                    sort: data.field,
                    order: data.type
                },
                done: function (res, curr, count) {
                    this.where = {};
                }
            });
        });

        // 监听双击事件
        table.on("rowDouble(LAY-app-" + businessType + "-list)", function (obj) {
            detail(obj.data);
        });

        // 重载列表数据
        var reloadData = function (data) {
            table.reload("LAY-app-" + businessType + "-list", {
                where: fims.clearBlank(data),
                done: function (res, curr, count) {
                    this.where = {};
                }
            });
        }

    });
</script>
</body>
</html>
