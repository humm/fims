<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>首页信息</title>
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
        <div class="layui-col-md8">
            <div class="layui-row layui-col-space15 business"></div>
        </div>

        <div class="layui-col-md4 other">
            <#--
                        <div class="layui-card">
                            <div class="layui-card-header">效果报告</div>
                            <div class="layui-card-body layadmin-takerates">
                                <div class="layui-progress" lay-showPercent="yes">
                                    <h3>转化率（日同比 28% <span class="layui-edge layui-edge-top" lay-tips="增长" lay-offset="-15"></span>）
                                    </h3>
                                    <div class="layui-progress-bar" lay-percent="65%"></div>
                                </div>
                                <div class="layui-progress" lay-showPercent="yes">
                                    <h3>签到率（日同比 11% <span class="layui-edge layui-edge-bottom" lay-tips="下降"
                                                          lay-offset="-15"></span>）</h3>
                                    <div class="layui-progress-bar" lay-percent="32%"></div>
                                </div>
                            </div>
                        </div>

                        <div class="layui-card">
                            <div class="layui-card-header">实时监控</div>
                            <div class="layui-card-body layadmin-takerates">
                                <div class="layui-progress" lay-showPercent="yes">
                                    <h3>CPU使用率</h3>
                                    <div class="layui-progress-bar" lay-percent="58%"></div>
                                </div>
                                <div class="layui-progress" lay-showPercent="yes">
                                    <h3>内存占用率</h3>
                                    <div class="layui-progress-bar layui-bg-red" lay-percent="90%"></div>
                                </div>
                            </div>
                        </div>

                        <div class="layui-card">
                            <div class="layui-card-header">产品动态</div>
                            <div class="layui-card-body">
                                <div class="layui-carousel layadmin-carousel layadmin-news" data-autoplay="true" data-anim="fade"
                                     lay-filter="news">
                                    <div carousel-item>
                                        <div><a href="http://fly.layui.com/docs/2/" target="_blank" class="layui-bg-red">layuiAdmin
                                                快速上手文档</a></div>
                                        <div><a href="http://fly.layui.com/vipclub/list/layuiadmin/" target="_blank"
                                                class="layui-bg-green">layuiAdmin 会员讨论专区</a></div>
                                        <div><a href="http://www.layui.com/admin/#get" target="_blank" class="layui-bg-blue">获得
                                                layui 官方后台模板系统</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="layui-card">
                            <div class="layui-card-header">
                                作者心语
                                <i class="layui-icon layui-icon-tips" lay-tips="要支持的噢" lay-offset="5"></i>
                            </div>
                            <div class="layui-card-body layui-text layadmin-text">
                                <p>一直以来，layui 秉承无偿开源的初心，虔诚致力于服务各层次前后端 Web
                                    开发者，在商业横飞的当今时代，这一信念从未动摇。即便身单力薄，仍然重拾决心，埋头造轮，以尽可能地填补产品本身的缺口。</p>
                                <p>在过去的一段的时间，我一直在寻求持久之道，已维持你眼前所见的一切。而 layuiAdmin 是我们尝试解决的手段之一。我相信真正有爱于 layui 生态的你，定然不会错过这一拥抱吧。</p>
                                <p>子曰：君子不用防，小人防不住。请务必通过官网正规渠道，获得 <a href="http://www.layui.com/admin/"
                                                                    target="_blank">layuiAdmin</a>！</p>
                                <p>—— 贤心（<a href="http://www.layui.com/" target="_blank">layui.com</a>）</p>
                            </div>
                        </div>-->
        </div>

    </div>
</div>

<script src="${appName}/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '${appName}/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form', 'admin', 'carousel', 'fims'], function () {
        var $ = layui.$,
            form = layui.form,
            admin = layui.admin,
            carousel = (layui.admin, layui.carousel),
            element = layui.element,
            device = layui.device(),
            fims = layui.fims;

        // 应用名称
        var appName = '${appName}';

        var url = {
            init: appName + "/console/selectConsoleData",
            websocketUrl: ""
        }

        var init = function (data) {
// todo 模块功能控制
            $(".business").html('');
            // 初始化业务数据
            if (!$.isEmptyObject(data.businessModel)) {
                initBusiness(data.businessModel);
            }

            $(".other").html('');
            // 初始化提示信息
            var common = new Array();
            if (!$.isEmptyObject(data.yearStartDate)) {
                common.push(data.yearStartDate);
            }
            if (!$.isEmptyObject(common)) {
                $(".other").append(initCommon(common));
            }
            // 初始化登入日志信息
            if (!$.isEmptyObject(data.loginModel)) {
                $(".other").append(initLogin(data.loginModel));
            }
            // 初始化版本信息
            if (!$.isEmptyObject(data.versionModel)) {
                $(".other").append(initVersion(data.versionModel));
            }
        }

        // 初始化业务数据
        var initBusiness = function (data) {
            var item = '';
            var size = data.length % 2;
            for (var i = 0; i < data.length; i++) {
                var business = data[i];
                var mode = size == 1 && i == 0 ? 12 : 6;
                item += '<div class="layui-col-md' + mode + '">';
                item += '   <div class="layui-card">';
                item += '       <div class="layui-card-header">' + business.title + '</div>';
                item += '           <div class="layui-card-body">';
                item += '               <div class="layui-carousel layadmin-carousel layadmin-backlog">';
                item += '                   <div carousel-item>';
                item += initBusinessItem(business.income);
                item += initBusinessItem(business.incomeAnalysis);
                item += initBusinessItem(business.giftSend);
                item += initBusinessItem(business.giftReceive);
                item += '                   </div>';
                item += '               </div>';
                item += '           </div>';
                item += '       </div>';
                item += '   </div>';
                item += '</div>';
            }
            $(".business").append(item);

            $(".layadmin-carousel").each(function () {
                var that = $(this);
                carousel.render({
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
        // 初始化业务数据
        var initBusinessItem = function (data) {
            var item = '<ul class="layui-row layui-col-space10">';
            for (var j = 0; j < data.length; j++) {
                item += '<li class="layui-col-xs6">';
                item += '   <a lay-href="' + data[j].href + '" ' + 'class="layadmin-backlog-body">';
                item += '       <h3>' + data[j].title + '</h3>';
                item += '       <p>' + setValue(data[j].value) + '</p>';
                item += '   </a>';
                item += '</li>';
            }
            item += '</ul>';
            return item;
        }

        // 设置值
        var setValue = function (value) {
            if (fims.isBlank(value) || value == '0' || value == '0.0' || value == '0.00') {
                return '<cite style="font-size: 25px; color: #666;">0</cite>';
            }
            if (value.indexOf("-") == -1) {
                return '<cite style="font-size: 25px; color: #FF5722;">' + value + '</cite>';
            } else {
                return '<cite style="font-size: 25px;">' + value + '</cite>';
            }
        }

        // 初始登入日志信息
        var initLogin = function (data) {
            var item = '<div class="layui-card">';
            item += '       <div class="layui-card-header">' + data[0].title + '</div>';
            item += '           <div class="layui-card-body layui-text">';
            item += '               <div class="layui-card-body layui-text">';
            item += '                   <table class="layui-table">';
            item += '                       <colgroup>';
            item += '                           <col width="50%" />';
            item += '                           <col />';
            item += '                       </colgroup>';
            item += '                       <colgroup>';
            item += '                           <tbody>';
            for (var i = 1; i < data.length; i++) {
                item += '                           <tr>';
                item += '                               <td>' + data[i].title + '</td>';
                item += '                               <td>' + data[i].value + '</td>';
                item += '                           </tr>';
            }
            item += '                           </tbody>';
            item += '                       </colgroup>';
            item += '                   </table>';
            item += '               </div>';
            item += '           </div>';
            item += '       </div>';
            item += '</div>';
            return item;
        }

        // 初始化版本信息
        var initVersion = function (data) {
            var item = '<div class="layui-card">';
            item += '       <div class="layui-card-header">' + data[0].title + '</div>';
            item += '           <div class="layui-card-body layui-text">';
            item += '               <div class="layui-card-body layui-text">';
            item += '                   <table class="layui-table">';
            item += '                       <colgroup>';
            item += '                           <col width="100" />';
            item += '                           <col />';
            item += '                       </colgroup>';
            item += '                       <colgroup>';
            item += '                           <tbody>';
            for (var i = 1; i < data.length; i++) {
                item += '                           <tr>';
                item += '                               <td>' + data[i].title + '</td>';
                item += '                               <td>';
                if (!fims.isBlank(data[i].href)) {
                    item += '                               <a lay-href="' + data[i].href + '">' + data[i].value + '</a>';
                } else {
                    item += '                               ' + data[i].value;
                }
                item += '                               </td>';
                item += '                           </tr>';
            }
            item += '                           </tbody>';
            item += '                       </colgroup>';
            item += '                   </table>';
            item += '               </div>';
            item += '           </div>';
            item += '       </div>';
            item += '</div>';
            return item;
        }

        // 初始化提示信息
        var initCommon = function (data) {
            var item = '<div class="layui-card">';
            item += '       <div class="layui-card-header">提示信息</div>';
            item += '           <div class="layui-card-body layui-text">';
            item += '               <div class="layui-card-body layui-text">';
            item += '                   <table class="layui-table">';
            item += '                       <colgroup>';
            item += '                           <col width="50%" />';
            item += '                           <col />';
            item += '                       </colgroup>';
            item += '                       <colgroup>';
            item += '                           <tbody>';
            for (var i = 0; i < data.length; i++) {
                item += '                           <tr>';
                item += '                               <td>' + data[i].title + '</td>';
                item += '                               <td>' + data[i].value + '</td>';
                item += '                           </tr>';
            }
            item += '                           </tbody>';
            item += '                       </colgroup>';
            item += '                   </table>';
            item += '               </div>';
            item += '           </div>';
            item += '       </div>';
            item += '</div>';
            return item;
        }

        // 获取首页数据
        var initData = function () {
            // 初始化页面信息
            admin.req({
                url: url.init,
                type: "get",
                async: false,
                dataType: "json",
                done: function (response) {
                    if (response.bizResult) {
                        url.websocketUrl = response.data.websocketUrl + appName;
                        init(response.data);
                    } else {
                        fims.msg(response.msg);
                    }
                }
            });
        }

        initData();

        // websocket连接
        fims.webSocket(url.websocketUrl, "console", function (data) {
            initData();
        });
    });
</script>
</body>
</html>

