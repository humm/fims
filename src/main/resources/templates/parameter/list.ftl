<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>参数信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${appName}/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/admin.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/template.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/fims.css" media="all">
</head>
<body>


<div class="layui-fluid layadmin-maillist-fluid">
    <div class="layui-row layui-col-space15 parameter"></div>
</div>


<script src="${appName}/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '${appName}/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form', 'admin', 'fims'], function () {
        var $ = layui.$,
            form = layui.form,
            admin = layui.admin,
            fims = layui.fims;

        // 应用名称
        var appName = '${appName}';

        var url = {
            init: appName + "/parameter/selectList",
            update: appName + "/parameter/view/update",
            save: appName + "/parameter/save"
        };

        var init = function () {
            // 初始化页面信息
            admin.req({
                url: url.init,
                type: "get",
                dataType: "json",
                done: function (response) {
                    if (response.bizResult) {
                        var parameterList = response.data;
                        if (!$.isEmptyObject(parameterList)) {
                            var item = "";
                            for (var i = 0; i < parameterList.length; i++) {
                                item += '<div class="layui-col-md4 layui-col-sm6" code="' + parameterList[i].parameterCode + '">';
                                item += '   <div class="layadmin-contact-box">';
                                item += '       <div class="layui-col-md6 layui-col-sm6">';
                                item += '           <div>';
                                item += '               <div class="layadmin-maillist-img layadmin-font-blod">' + parameterList[i].parameterCaption + '</div>';
                                item += '           </div>';
                                item += '       </div>';
                                item += '       <div class="layui-col-md8 layadmin-padding-left20 layui-col-sm6">';
                                item += '           <p class="layadmin-textimg fims-padding-parameter">' + parameterList[i].parameterValue + '</p>';
                                item += '       </div>';
                                item += '    </div>';
                                item += '</div>';
                            }
                            $(".parameter").append(item);
                        }
                        form.render();
                    } else {
                        fims.msg(response.msg);
                    }
                }
            });
        }

        init();

        // 绑定双击事件
        $(document).on('dblclick', 'div.layui-col-md4', function () {
            var parameterCode = $(this).attr("code");
            var parameterCaption = $(this).find("div.layadmin-font-blod").text();
            var parameterValue = $(this).find("p").text();
            console.log(parameterCode + "-" + parameterCaption + "-" + parameterValue);
            var request = {
                parameterCode: parameterCode,
                parameterCaption: parameterCaption,
                parameterValue: parameterValue
            }
            layer.open({
                type: 2,
                title: fims.tips.title.update,
                content: url.update + "?" + $.param(request),
                area: ["450px", "500px"],
                btn: [fims.tips.btn.save, fims.tips.btn.cancel],
                resize: fims.set.resize,
                yes: function (e, t) {
                    save(e, t, fims.operate.update, data);
                }
            });
        });

        // 数据保存
        var save = function (e, t, type, data) {
            var iframe = window["layui-layer-iframe" + e],
                button = t.find("iframe").contents().find("#LAY-app-" + businessType + "-" + type);
            iframe.layui.form.on("submit(LAY-app-" + businessType + "-" + type + ")", function (data) {
                admin.req({
                    url: url.save,
                    type: "post",
                    data: fims.clearBlank(data.field),
                    done: function (response) {
                        if (response.bizResult) {
                            setTimeout(function () {
                                init();
                                layer.close(e);
                                fims.msg(response.msg);
                            }, 500);
                        } else {
                            fims.msg(response.msg);
                        }
                    }
                });
            }), button.trigger("click");
        }

    });
</script>
</body>
</html>