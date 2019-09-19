/** fims自定义方法 */
;layui.define(function (e) {
    var $ = layui.$,
        form = layui.form;

    var obj = {
        msg: function (msg, param) {
            if ($.isEmptyObject(param)) {
                layer.msg(msg, {time: 500});
            } else {
                layer.msg(msg, param);
            }
        },
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
        getBarData: function (bar) {
            var data = {
                title: {text: bar.title, subtext: bar.subTitle},
                tooltip: {trigger: 'axis'},
                legend: {data: bar.legendData},
                toolbox: {
                    show: true,
                    feature: {
                        mark: {show: false},
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                xAxis: [{type: 'category', data: bar.xaxisData}],
                yAxis: [{type: 'value'}],
                series: []
            }
            var element = {
                name: "",
                type: 'bar',
                data: [],
                markPoint: {data: [{type: 'max', name: '最大值'}, {type: 'min', name: '最小值'}]},
                markLine: {data: [{type: 'average', name: '平均值'}]}
            }
            for (var i = 0; i < bar.yaxisData.length; i++) {
                var ele = JSON.parse(JSON.stringify(element));
                ele.name = bar.yaxisData[i].name;
                ele.data = bar.yaxisData[i].data;
                data.series.push(ele);
            }
            return data;
        },
        getPieData: function (pie) {
            var data = {
                title: {text: pie.title, subtext: pie.subTitle, x: "center", textStyle: {fontSize: 14}},
                tooltip: {trigger: "item", formatter: "{a} <br/>{b} : {c} ({d}%)"},
                legend: {orient: "vertical", x: "left", data: pie.legendData},
                toolbox: {
                    show: true,
                    feature: {
                        mark: {show: false},
                        dataView: {show: true, readOnly: false},
                        magicType: {
                            show: true,
                            type: ['pie', 'funnel'],
                            option: {
                                funnel: {
                                    x: '25%',
                                    width: '50%',
                                    funnelAlign: 'left',
                                    max: 1548
                                }
                            }
                        },
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                series: []
            }
            var element = {
                name: "",
                type: "pie",
                radius: "55%",
                center: ["50%", "50%"],
                data: []
            }
            for (var i = 0; i < pie.pieData.length; i++) {
                var ele = JSON.parse(JSON.stringify(element));
                ele.name = pie.pieData[i].name;
                ele.data = pie.pieData[i].data;
                data.series.push(ele);
            }
            return data;
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
                request: "数据提交中...",
                notSameOne: "送礼人和收礼人不能为同一人",
                isLoginOne: "送礼人或者收礼人必须有一个为当前登录人",
                notEmpty: "不能为空"
            }
        }
    };

    e('fims', obj);
});