<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>消息通知信息-列表</title>
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
                    <label class="layui-form-label">消息用户</label>
                    <div class="layui-input-block">
                        <select name="userId"></select>
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">业务类型</label>
                    <div class="layui-input-block">
                        <select name="businessType"></select>
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">业务子类型</label>
                    <div class="layui-input-block">
                        <select name="businessSubType"></select>
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">通知状态</label>
                    <div class="layui-input-block">
                        <select name="noticeStatus"></select>
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">通知类型</label>
                    <div class="layui-input-block">
                        <select name="noticeType"></select>
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">阅读状态</label>
                    <div class="layui-input-block">
                        <select name="isRead"></select>
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">业务时间</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input" name="businessDate" id="businessDate">
                    </div>
                </div>

                <!-- 查询按钮 -->
                <div class="layui-inline layui-inline-button">
                    <button class="layui-btn layuiadmin-btn-notice-list" lay-submit
                            lay-filter="LAY-app-noticelist-search">
                        <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                    </button>
                </div>

                <!-- 重置按钮 -->
                <div class="layui-inline layui-inline-button">
                    <button class="layui-btn layuiadmin-btn-notice-list" lay-submit
                            lay-filter="LAY-app-noticelist-refresh">
                        <i class="layui-icon layui-icon-refresh-1 layuiadmin-button-btn"></i>
                    </button>
                </div>

            </div>
        </div>

        <div class="layui-card-body">

            <!-- 列表数据 -->
            <table id="LAY-app-notice-list" lay-filter="LAY-app-notice-list"></table>

            <!-- 通知状态 -->
            <script type="text/html" id="noticeStatus">
                <button class="layui-btn layui-btn-xs layui-bg-{{ d.noticeStatusCode }}">{{ d.noticeStatus }}</button>
            </script>

            <!-- 通知类型 -->
            <script type="text/html" id="noticeType">
                <button class="layui-btn layui-btn-xs layui-bg-{{ d.noticeTypeCode }}">{{ d.noticeType }}</button>
            </script>

            <!-- 阅读状态 -->
            <script type="text/html" id="readStatus">
                <button class="layui-btn layui-btn-xs layui-bg-{{ d.readStatusCode }}">{{ d.readStatus }}</button>
            </script>

            <!-- 业务类型 -->
            <script type="text/html" id="businessType">
                <button class="layui-btn layui-btn-xs layui-bg-{{ d.businessTypeCode }}">{{ d.businessType }}</button>
            </script>

            <!-- 业务子类型 -->
            <script type="text/html" id="businessSubType">
                <button class="layui-btn layui-btn-xs layui-bg-{{ d.businessSubTypeCode }}">{{ d.businessSubType }}</button>
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

        // 业务类型
        var businessType = "notice";

        // 请求url
        var url = {
            init: appName + "/notice/selectInitData",
            page: appName + "/notice/selectPage",
            detail: appName + "/notice/view/detail"
        }

        // 列表字段
        var tableColumn = [[
            {field: "noticeId", title: "消息通知序列号", sort: false, hide: true},
            {field: "businessId", title: "业务序列号", sort: false, hide: true},
            {field: "userId", title: "消息用户", sort: true},
            {field: "businessType", title: "业务类型", templet: "#businessType",  align: 'center', sort: true},
            {field: "businessSubType", title: "业务子类型", templet: "#businessSubType", sort: true},
            {field: "businessDate", title: "业务时间", align: 'center', sort: true},
            {field: "businessAmount", title: "业务金额", sort: true},
            {field: "noticeStatus", title: "通知状态", templet: "#noticeStatus", align: 'center', sort: true},
            {field: "noticeType", title: "通知类型", templet: "#noticeType", align: 'center', sort: true},
            {field: "readStatus", title: "阅读状态", templet: "#readStatus", align: 'center', sort: true}
        ]];

        // 时间选择器
        laydate.render({
            elem: '#businessDate'
        });

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


        // 数据详情
        var detail = function (data) {
            var request = {
                noticeId: data.noticeId,
                isTranslate: "1"
            }
            layer.open({
                type: 2,
                title: fims.tips.title.detail,
                content: url.detail + "?" + $.param(request),
                area: ["450px", "500px"],
                resize: false
            });
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
            setTimeout(function () {
                reloadData(fims.getValue("layui-form-item"));
            }, 500);
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
