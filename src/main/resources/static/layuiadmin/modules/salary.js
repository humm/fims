/** layuiAdmin.std-v1.0.0 LPPL License By http://www.layui.com/admin/ */
;layui.define(["table", "form"], function (e) {
    var i = layui.table, $ = layui.$;
    layui.form;

    var appName = $("#appName").val();

    i.render({
        elem: "#LAY-app-salary-list",
        url: appName + "/salary/selectPage",
        cols: [
            [
                {type: "checkbox", fixed: "left"},
                {field: "salaryId", title: "收入序列号", sort: false, hide: true},
                {field: "userId", title: "收入人", sort: true},
                {field: "salaryDate", title: "收入日期", sort: true},
                {field: "salaryCompany", title: "收入来源", sort: true},
                {field: "salaryType", title: "收入类型", sort: true},
                {field: "salaryAmount", title: "收入金额", sort: true},
                {field: "salaryMemo", title: "收入备注"},
                {title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-salary-list"}
            ]
        ],
        page: !0,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: "数据加载出现异常"
    }), i.on("tool(LAY-app-salary-list)", function (e) {
        e.data;
        if ("del" === e.event) layer.confirm("确定删除此条帖子？", function (t) {
            e.del(), layer.close(t)
        }); else if ("edit" === e.event) {
            $(e.tr);
            layer.open({
                type: 2,
                title: "编辑帖子",
                content: "../../../views/app/salary/listform.html",
                area: ["550px", "400px"],
                btn: ["确定", "取消"],
                resize: !1,
                yes: function (e, t) {
                    var l = window["layui-layer-iframe" + e], r = "LAY-app-salary-submit",
                        o = t.find("iframe").contents().find("#" + r);
                    l.layui.form.on("submit(" + r + ")", function (t) {
                        t.field;
                        i.reload("LAY-app-salary-list"), layer.close(e)
                    }), o.trigger("click")
                },
                success: function (e, t) {
                }
            })
        }
    }),e("salary", {});
});