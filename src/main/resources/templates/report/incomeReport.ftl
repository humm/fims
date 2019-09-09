<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layuiAdmin 控制台主页一</title>
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
                <div class="layui-card-header">数据概览</div>
                <div class="layui-card-body">

                    <div class="layui-carousel layadmin-carousel layadmin-dataview"
                         data-anim="fade" lay-filter="LAY-index-income-dataview">
                        <div carousel-item id="LAY-index-income-dataview">
                            <div><i class="layui-icon layui-icon-loading1 layadmin-loading"></i></div>
                            <div></div>
                            <div></div>
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
    }).use(['index', 'admin', 'carousel', 'echarts'], function () {
        var $ = layui.$,
            report = (layui.admin, layui.carousel),
            element = layui.element,
            device = layui.device(),
            carousel = layui.carousel,
            echarts = layui.echarts;

        $(".layadmin-carousel").each(function () {
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


        var i = [],
            l = [
                    {
                        title : {
                            text: '某地区蒸发量和降水量',
                            subtext: '纯属虚构'
                        },
                        tooltip : {
                            trigger: 'axis'
                        },
                        legend: {
                            data:['蒸发量','降水量']
                        },
                        toolbox: {
                            show : true,
                            feature : {
                                mark : {show: false},
                                dataView : {show: true, readOnly: false},
                                magicType : {show: true, type: ['line', 'bar']},
                                restore : {show: true},
                                saveAsImage : {show: true}
                            }
                        },
                        calculable : true,
                        xAxis : [
                            {
                                type : 'category',
                                data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
                            }
                        ],
                        yAxis : [
                            {
                                type : 'value'
                            }
                        ],
                        series : [
                            {
                                name:'蒸发量',
                                type:'bar',
                                data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
                                markPoint : {
                                    data : [
                                        {type : 'max', name: '最大值'},
                                        {type : 'min', name: '最小值'}
                                    ]
                                },
                                markLine : {
                                    data : [
                                        {type : 'average', name: '平均值'}
                                    ]
                                }
                            },
                            {
                                name:'降水量',
                                type:'bar',
                                data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
                                markPoint : {
                                    data : [
                                        {type : 'max', name: '最大值'},
                                        {type : 'min', name: '最小值'}
                                    ]
                                },
                                markLine : {
                                    data : [
                                        {type : 'average', name: '平均值'}
                                    ]
                                }
                            }
                        ]
                    },
                    {
                        title: {text: "访客浏览器分布", x: "center", textStyle: {fontSize: 14}},
                        tooltip: {trigger: "item", formatter: "{a} <br/>{b} : {c} ({d}%)"},
                        legend: {orient: "vertical", x: "left", data: ["Chrome", "Firefox", "IE 8.0", "Safari", "其它浏览器"]},
                        series: [{
                            name: "访问来源",
                            type: "pie",
                            radius: "55%",
                            center: ["50%", "50%"],
                            data: [{value: 9052, name: "Chrome"}, {value: 1610, name: "Firefox"}, {
                                value: 3200,
                                name: "IE 8.0"
                            }, {value: 535, name: "Safari"}, {value: 1700, name: "其它浏览器"}]
                        }]
                    },
                    {
                        title: {text: "最近一周新增的用户量", x: "center", textStyle: {fontSize: 14}},
                        tooltip: {trigger: "axis", formatter: "{b}<br>新增用户：{c}"},
                        xAxis: [{type: "category", data: ["11-07", "11-08", "11-09", "11-10", "11-11", "11-12", "11-13"]}],
                        yAxis: [{type: "value"}],
                        series: [{type: "line", data: [200, 300, 400, 610, 150, 270, 380]}]
                    }
        ],
        n = $("#LAY-index-income-dataview").children("div"),
        r = function (e) {
            i[e] = echarts.init(n[e], layui.echartsTheme),
            i[e].setOption(l[e]), window.onresize = i[e].resize
        };
        if (n[0]) {
            r(0);
            var o = 0;
            carousel.on("change(LAY-index-income-dataview)", function (e) {
                r(o = e.index);
            }), layui.admin.on("side", function () {
                setTimeout(function () {
                    r(o);
                }, 300);
            }), layui.admin.on("hash(tab)", function () {
                layui.router().path.join("") || r(o);
            });
        }
    });
</script>
</body>
</html>

