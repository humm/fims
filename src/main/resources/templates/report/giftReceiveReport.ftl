<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>收礼信息报表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${appName}/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/admin.css" media="all">
</head>
<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-sm12">
            <div class="layui-card">
                <div class="layui-card-header">收礼年度分析</div>
                <div class="layui-card-body">
                    <div class="layui-carousel layadmin-carousel layadmin-dataview layadmin-carousel-year"
                         data-anim="fade" lay-filter="LAY-index-giftReceive-year">
                        <div carousel-item id="LAY-index-giftReceive-year">
                            <div><i class="layui-icon layui-icon-loading1 layadmin-loading"></i></div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="layui-col-sm12">
            <div class="layui-card">
                <div class="layui-card-header">收礼类型分析</div>
                <div class="layui-card-body">
                    <div class="layui-carousel layadmin-carousel layadmin-dataview layadmin-carousel-type"
                         data-anim="fade" lay-filter="LAY-index-giftReceive-type">
                        <div carousel-item id="LAY-index-giftReceive-type">
                            <div><i class="layui-icon layui-icon-loading1 layadmin-loading"></i></div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="layui-col-sm12">
            <div class="layui-card">
                <div class="layui-card-header">收礼极值分析</div>
                <div class="layui-card-body">
                    <div class="layui-carousel layadmin-carousel layadmin-dataview layadmin-carousel-peak"
                         data-anim="fade" lay-filter="LAY-index-giftReceive-peak">
                        <div carousel-item id="LAY-index-giftReceive-peak">
                            <div><i class="layui-icon layui-icon-loading1 layadmin-loading"></i></div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="layui-col-sm12">
            <div class="layui-card">
                <div class="layui-card-header">随礼分析</div>
                <div class="layui-card-body">
                    <div class="layui-carousel layadmin-carousel layadmin-dataview layadmin-carousel-gift"
                         data-anim="fade" lay-filter="LAY-index-giftReceive-gift">
                        <div carousel-item id="LAY-index-giftReceive-gift">
                            <div><i class="layui-icon layui-icon-loading1 layadmin-loading"></i></div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<script src="${appName}/layuiadmin/layui/layui.js?t=1"></script>
<script>
    layui.config({
        base: '${appName}/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'admin', 'carousel', 'echarts', 'fims'], function () {
        var $ = layui.$,
            form = layui.form,
            admin = layui.admin,
            report = (layui.admin, layui.carousel),
            fims = layui.fims,
            element = layui.element,
            device = layui.device(),
            carousel = layui.carousel,
            echarts = layui.echarts;

        var appName = '${appName}';
        var url = appName + "/report/initData?";
        var request = {
            reportMode: "bar",
            reportType: "giftReceive",
            reportSubType: "year",
            reportValue: ""
        }

        var reportList = [];

        // 收礼年度分析
        var initYearReport = function (index, type) {
            var year = $("#LAY-index-giftReceive-year").children("div")[index];
            if (index == 0) {
                request.reportMode = "bar";
                request.reportSubType = "year";
            } else {
                var select = $(year).attr("year");
                request.reportMode = "bar";
                request.reportSubType = "month";
                request.reportValue = select;
            }
            admin.req({
                url: url + $.param(JSON.parse(JSON.stringify(request))),
                type: "get",
                dataType: "json",
                done: function (response) {
                    if (response.bizResult) {
                        if (type == "init") {
                            loopYear(response.data);
                        }
                        reportList[index] = echarts.init(year, layui.echartsTheme);
                        reportList[index].setOption(fims.getBarData(response.data));
                        window.onresize = reportList[index].resize;
                        if($.isEmptyObject(response.data.legendData)){
                            layer.msg(fims.tips.msg.emptyData, {time: 500});
                        }
                    } else {
                        fims.msg(response.msg);
                    }
                }
            });
        }
        initYearReport(0, "init");

        // 收礼类型分析
        request.reportMode = "pie";
        request.reportSubType = "type";
        reportRender("layadmin-carousel-type");
        admin.req({
            url: url + $.param(JSON.parse(JSON.stringify(request))),
            type: "get",
            dataType: "json",
            done: function (response) {
                if (response.bizResult) {
                    var type = $("#LAY-index-giftReceive-type").children("div")[0];
                    var typePie = echarts.init(type, layui.echartsTheme);
                    typePie.setOption(fims.getPieData(response.data));
                    window.onresize = typePie.resize;
                } else {
                    fims.msg(response.msg);
                }
            }
        });

        // 收礼极值分析
        request.reportMode = "pie";
        request.reportSubType = "peak";
        reportRender("layadmin-carousel-peak");
        admin.req({
            url: url + $.param(JSON.parse(JSON.stringify(request))),
            type: "get",
            dataType: "json",
            done: function (response) {
                if (response.bizResult) {
                    var peak = $("#LAY-index-giftReceive-peak").children("div")[0];
                    var peakPie = echarts.init(peak, layui.echartsTheme);
                    peakPie.setOption(fims.getPieData(response.data));
                    window.onresize = peakPie.resize;
                } else {
                    fims.msg(response.msg);
                }
            }
        });

        // 随礼分析
        request.reportMode = "pie";
        request.reportSubType = "gift";
        reportRender("layadmin-carousel-gift");
        admin.req({
            url: url + $.param(JSON.parse(JSON.stringify(request))),
            type: "get",
            dataType: "json",
            done: function (response) {
                if (response.bizResult) {
                    var gift = $("#LAY-index-giftReceive-gift").children("div")[0];
                    var giftPie = echarts.init(gift, layui.echartsTheme);
                    giftPie.setOption(fims.getPieData(response.data));
                    window.onresize = giftPie.resize;
                } else {
                    fims.msg(response.msg);
                }
            }
        });

        // 收礼年度分析后续操作
        function loopYear(data) {
            var years = JSON.parse(JSON.stringify(data.xaxisData)).reverse();
            var options = "";
            for (var i = 0; i < years.length; i++) {
                options += "<div year='" + years[i].replace("年","") + "'></div>";
            }
            $("#LAY-index-giftReceive-year").append(options);

            reportRender("layadmin-carousel-year");

            var index = 0;
            carousel.on("change(LAY-index-giftReceive-year)", function (e) {
                initYearReport(index = e.index);
            }), layui.admin.on("side", function () {
                setTimeout(function () {
                    initYearReport(index);
                }, 500);
            }), layui.admin.on("hash(tab)", function () {
                layui.router().path.join("") || initYearReport(index);
                ;
            });

        }

        // 渲染报表
        function reportRender(className) {
            $("." + className).each(function () {
                var that = $(this);
                report.render({
                    elem: this,
                    width: "100%",
                    arrow: "none",
                    interval: that.data("interval"),
                    autoplay: that.data("autoplay") === true,
                    trigger: device.ios || device.android ? "click" : "hover",
                    anim: that.data("anim")
                });
            }), element.render("progress");
        }

    });
</script>
</body>
</html>

