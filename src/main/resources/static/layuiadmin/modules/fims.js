/** fims自定义方法 */
;layui.define(function (e) {
    var $ = layui.$;

    var obj = {
        isBlank: function (parameter) {
            if (parameter == null || parameter == '' || parameter == undefined || parameter == 'undefined') {
                return true;
            }
        },
        setAuthority: function (isAdmin, buttonId) {
            if (isAdmin && !this.isBlank(buttonId)) {
                var ids = buttonId.split(",");
                for (var i = 0; i < ids.length; i++) {
                    $("#" + ids[i]).remove();
                }
            }
        },
        set:{
            area: {
                width: "550px",
                height: "400px"
            }
        },
        tips: {
            title: {
                add: "新增",
                edit: "修改",
                del: "删除",
                detail: "详情"
            },
            btn: {
                ok: "确定",
                cancel: "取消"
            },
            warn: {
                notSelect: "请选择数据",
                selectOne: "请选择单条数据",
                confirmDel: "确定删除吗"
            },
            msg: {
                delSuccess: "删除成功",
                editSuccess: "修改成功",
                addSuccess: "新增成功"
            }
        }
    };

    e('fims', obj);
});