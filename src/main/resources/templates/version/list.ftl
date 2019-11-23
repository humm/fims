<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修订信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${appName}/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/admin.css" media="all">
</head>
<body>

<style>
    #LAY-component-timeline .layui-card-body {
        padding: 15px;
    }
    .layui-timeline-item-fims {
        position: relative;
        padding-bottom: 20px;
    }
    .layui-timeline-content {
        padding-left: 30px;
    }
</style>

<div class="layui-fluid" id="LAY-component-timeline">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">当前版本：${version}</div>
                <div class="layui-card-body">

                    <ul class="layui-timeline"></ul>

                </div>
            </div>
        </div>
    </div>
</div>

<script src="${appName}/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '${appName}/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'admin', 'fims'], function () {
        var $ = layui.$,
            admin = layui.admin,
            fims = layui.fims;

        // 应用名称
        var appName = '${appName}';
        
        var url = {
            init: appName + "/version/selectList"
        };
        
        // 初始化页面信息
        admin.req({
            url: url.init,
            type: "get",
            dataType: "json",
            done: function (response) {
                if (response.bizResult) {
                    initVersion(response.data);
                }
            }
        });
        
        // 初始化修订信息
        var initVersion = function (data) {
            if(!$.isEmptyObject(data)){
                for (var i=0; i<data.length; i++) {
                    var versionContent = data[i].versionContent;
                    var versionDate = data[i].versionDate;
                    var versionType = data[i].versionType;
                    if (fims.isBlank($("." + versionDate).html())) {
                        var item  = '<li class="layui-timeline-item-fims">';
                            item += '   <i class="layui-icon layui-timeline-axis"></i>';
                            item += '   <div class="layui-timeline-content layui-text">';
                            item += '       <h3 class="layui-timeline-title ' + versionDate + '">' + versionDate + '</h3>';
                            item += '       <ul>';
                            item += addItem(versionType, versionContent);
                            item +='        </ul>';
                            item += '   </div>';
                            item += '</li>';
                        $(".layui-timeline").append(item);
                    } else {
                        $("." + versionDate).next().append(addItem(versionType, versionContent));
                    }
                }
            }
        }

        // 添加修订信息
        var addItem = function (type, content) {
            var item  = '<li>';
                if (type == '1') {
                    item += '<span class="layui-btn-fims layui-btn-xs-fims layui-bg-orange">功能</span>';
                } else if (type == '2') {
                    item += '<span class="layui-btn-fims layui-btn-xs-fims layui-bg-blue">优化</span>';
                } else if (type == '3') {
                    item += '<span class="layui-btn-fims layui-btn-xs-fims layui-bg-gray">修复</span>';
                }else if (type == '4') {
                    item += '<span class="layui-btn-fims layui-btn-xs-fims layui-bg-red">定版</span>';
                }
                item += '&nbsp;&nbsp;&nbsp;';
                item += content;
                item += '</li>';
            return item;
        }
    });
</script>
</body>
</html>