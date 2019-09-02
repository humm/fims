/** fims自定义方法 */
;layui.define(function (e) {
    var $ = layui.$,
        form = layui.form;

    var obj = {
        isBlank: function (parameter) {
            if (parameter == null || parameter == '' || parameter == undefined || parameter == 'undefined') {
                return true;
            } else {
                return false;
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
        clearBlank: function (data) {
            var convertData = {};
            if (!this.isBlank(data)) {
                for (var key in data) {
                    if (!this.isBlank(data[key])) {
                        convertData[key] = data[key];
                    }
                }
            }
            return convertData;
        },
        setCondition: function (tag, data) {
            var that = this;
            $("." + tag + " [name]").each(function () {
                var name = $(this).attr("name");
                var type = $(this)[0].tagName.toLowerCase();
                if (type != "select") {
                    return;
                }
                var select = data[name];
                if (!that.isBlank(select)) {
                    for (var i = 0; i < select.length; i++) {
                        var option = "<option value='" + select[i]["dictionaryItem"] + "'>" + select[i]["dictionaryCaption"] + "</option>";
                        $(this).append(option);
                    }
                }
            });
            form.render();
        },
        setValue: function (tag, data) {
            var that = this;
            if (that.isBlank(data)) {
                return;
            }
            $("." + tag + " [name]").each(function () {
                var name = $(this).attr("name");
                var type = $(this)[0].tagName.toLowerCase();
                if (type == "textarea") {
                    $(this).text(data[name]);
                } else {
                    // select input
                    $(this).val(data[name]);
                }
            });
            form.render();
        },
        getValue: function (tag) {
            var data = {};
            $("." + tag + " [name]").each(function () {
                var name = $(this).attr("name");
                var type = $(this)[0].tagName.toLowerCase();
                if (type == "textarea") {
                    data[name] = $(this).text();
                } else {
                    // select input
                    data[name] = $(this).val();
                }
            });
            return data;
        },
        clearValue: function (tag) {
            $("." + tag + " [name]").each(function () {
                var type = $(this)[0].tagName.toLowerCase();
                if (type == "textarea") {
                    $(this).text("");
                } else {
                    // select input
                    $(this).val("");
                }
            });
            form.render();
        },
        getUrlParameter: function (parameter) {
            var reg = new RegExp("(^|&)" + parameter + "=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]);
            return null;
        },
        getDate: function () {
            var date = new Date;
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var day = date.getDate();
            month = (month < 10 ? "0" + month : month);
            day = (day < 10 ? "0" + day : day);
            return year + "-" + month + "-" + day;
        },
        set: {
            resize: false
        },
        operate: {
            add: "add",
            delete: "delete",
            update: "update",
            detail: "detail"
        },
        tips: {
            title: {
                add: "新增",
                update: "修改",
                del: "删除",
                detail: "详情"
            },
            btn: {
                ok: "确定",
                save: "保存",
                cancel: "取消"
            },
            warn: {
                notSelect: "请选择数据",
                selectOne: "请选择单条数据",
                confirmDel: "确定删除吗"
            },
            msg: {
                notSupportEvent: "不支持的事件类型",
                emptyData: "暂无相关数据",
                request: "数据提交中..."
            }
        }
    };

    e('fims', obj);
});