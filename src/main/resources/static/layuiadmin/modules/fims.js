/** fims自定义方法 */
;layui.define(function (e) {
    var $ = layui.$;

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
            if(this.isBlank(data)){
                return null;
            }
            var convertData = {}
            for(var key in data){
                if(!this.isBlank(data[key])){
                    convertData[key] = data[key];
                }
            }
            return convertData;
        },
        setCondition: function(tag, data){
            var that = this;
            $("." + tag + " [name]").each(function () {
                var name =  $(this).attr("name");
                var type = $(this)[0].tagName.toLowerCase();
                if(type != "select"){
                    return;
                }
                var select = data[name];
                if(!that.isBlank(select)){
                    for(var i=0; i<select.length; i++){
                        var option = "<option value='" + select[i]["dictionaryItem"] + "'>" + select[i]["dictionaryCaption"] + "</option>";
                        $(this).append(option);
                    }
                }
            });
        },
        set: {
            area: {
                defaut: [
                    "550px",
                    "550px"
                ]
            },
            rowBtn: false
        },
        operate: {
            add: "add",
            delete: "delete",
            edit: "edit",
            detail: "detail"
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
                addSuccess: "新增成功",
                notSupportEvent: "不支持的事件类型",
                emptyData: "暂无相关数据"
            }
        }
    };

    e('fims', obj);
});