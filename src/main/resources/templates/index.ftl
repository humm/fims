<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>fims</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${appName}/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/admin.css" media="all">
</head>
<body class="layui-layout-body">

<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <!-- 头部区域 -->
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item layadmin-flexible" lay-unselect>
                    <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
                        <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="http://www.layui.com/admin/" target="_blank" title="前台">
                        <i class="layui-icon layui-icon-website"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" layadmin-event="refresh" title="刷新">
                        <i class="layui-icon layui-icon-refresh-3"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search"
                           layadmin-event="serach" lay-action="template/search.html?keywords=">
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">

                <li class="layui-nav-item" lay-unselect>
                    <a lay-href="app/message/index.html" layadmin-event="message" lay-text="消息中心">
                        <i class="layui-icon layui-icon-notice"></i>

                        <!-- 如果有新消息，则显示小圆点 -->
                        <span class="layui-badge-dot"></span>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="theme">
                        <i class="layui-icon layui-icon-theme"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="note">
                        <i class="layui-icon layui-icon-note"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="fullscreen">
                        <i class="layui-icon layui-icon-screen-full"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;">
                        <cite>贤心</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a lay-href="set/user/info.html">基本资料</a></dd>
                        <dd><a lay-href="set/user/password.html">修改密码</a></dd>
                        <hr>
                        <dd layadmin-event="logout" style="text-align: center;"><a>退出</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="about"><i
                                class="layui-icon layui-icon-more-vertical"></i></a>
                </li>
                <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
                    <a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
                </li>
            </ul>
        </div>

        <!-- 侧边菜单 -->
        <div class="layui-side layui-side-menu">
            <div class="layui-side-scroll">
                <div class="layui-logo">
                    <span>FIMS</span>
                </div>
                <ul class="layui-nav layui-nav-tree" lay-shrink="all"
                    id="LAY-system-side-menu"
                    lay-filter="layadmin-system-side-menu">
                </ul>
            </div>
        </div>

        <!-- 页面标签 -->
        <div class="layadmin-pagetabs" id="LAY_app_tabs">
            <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-down">
                <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
                    <li class="layui-nav-item" lay-unselect>
                        <a href="javascript:;"></a>
                        <dl class="layui-nav-child layui-anim-fadein">
                            <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                            <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                            <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
                <ul class="layui-tab-title" id="LAY_app_tabsheader">
                    <li lay-id="home/console" lay-attr="home/console" class="layui-this"><i
                                class="layui-icon layui-icon-home"></i></li>
                </ul>
            </div>
        </div>


        <!-- 主体内容 -->
        <div class="layui-body" id="LAY_app_body">
            <div class="layadmin-tabsbody-item layui-show">
                <iframe src="home/console" frameborder="0" class="layadmin-iframe"></iframe>
            </div>
        </div>

        <!-- 辅助元素，一般用于移动设备下遮罩 -->
        <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
</div>

<script src="${appName}/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '${appName}/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'admin', 'element', 'fims'], function () {
        var $ = layui.$,
            admin = layui.admin,
            element = layui.element,
            fims = layui.fims;

        // 应用名称
        var appName = '${appName}';

        var url = {
            init: appName + "/menu/initMenu"
        };

        // 子菜单
        var childrenMenu = "";

        // 初始化页面信息
        admin.req({
            url: url.init,
            type: "get",
            dataType: "json",
            done: function (response) {
                if (response.bizResult) {
                    initMenu(response.data);
                }
            }
        });

        // 初始化菜单
        function initMenu(data) {
            var menu = '';
            menu += '<li data-name="console" class="layui-nav-item layui-this">';
            menu += '    <a href="javascript:;" lay-tips="首页" lay-direction="2" lay-href="home/console">';
            menu += '       <i class="layui-icon layui-icon-home"></i>';
            menu += '       <cite>首页</cite>';
            menu += '    </a>';
            menu += '</li>';
            if (!$.isEmptyObject(data)) {
                data.forEach(function (item) {
                    if (!fims.isBlank(item.menuUrl)) {
                        if (item.menuUrl != '#') {
                            // 单页面菜单
                            menu += '<li data-name="' + item.menuId + '" class="layui-nav-item">';
                            menu += '    <a href="javascript:;" lay-tips="' + item.menuTitle + '" lay-direction="2" lay-href="' + item.menuUrl + '?menuId=' + item.menuId + '">';
                            menu += '       <i class="layui-icon ' + item.menuIcon + '"></i>';
                            menu += '       <cite>' + item.menuTitle + '</cite>';
                            menu += '    </a>';
                            menu += '</li>';
                        } else {
                            // 父页面菜单
                            menu += '<li data-name="' + item.menuId + '" class="layui-nav-item">';
                            menu += '    <a href="javascript:;" lay-tips="' + item.menuTitle + '" lay-direction="2">';
                            menu += '       <i class="layui-icon ' + item.menuIcon + '"></i>';
                            menu += '       <cite>' + item.menuTitle + '</cite>';
                            menu += '    </a>';
                            if(!fims.isBlank(item.children)){
                                menu += '<dl class="layui-nav-child">';
                                childrenMenu = "";
                                initChildrenMenu(item.children,);
                                menu += childrenMenu;
                                menu += '</dl>';
                            }
                            menu += '</li>';
                        }
                    }
                });
            }
            $("#LAY-system-side-menu").append(menu);
            // 渲染菜单
            element.init();
        }
        // 初始化子菜单
        function initChildrenMenu(data) {
            data.forEach(function (subItem) {
                if(!fims.isBlank(subItem.children)){
                    childrenMenu += '<dd data-name="' + subItem.menuId + '">';
                    childrenMenu += '   <a href="javascript:;">' + subItem.menuTitle + '</a>';
                    childrenMenu += '   <dl class="layui-nav-child">';
                    initChildrenMenu(subItem.children);
                    childrenMenu += '   </dl>';
                    childrenMenu += '</dd>';
                }else{
                    childrenMenu += '<dd data-name="' + subItem.menuId + '">';
                    childrenMenu += '   <a lay-href="' + subItem.menuUrl + '?menuId=' + subItem.menuId + '">' + subItem.menuTitle + '</a>';
                    childrenMenu += '</dd>';
                }
            });
        }
    });
</script>
</body>
</html>


