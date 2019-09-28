<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>角色信息-新增</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, role-scalable=0">
    <link rel="stylesheet" href="${appName}/layuiadmin/layui/css/layui.css" media="all">
</head>
<body>

<div class="layui-form" style="padding: 20px 30px 0 0;">
    <div class="layui-form-item">
        <label class="layui-form-label">角色代码</label>
        <div class="layui-input-inline">
            <input type="text" name="roleCode" class="layui-input" lay-verify="required" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">角色名称</label>
        <div class="layui-input-inline">
            <input type="text" name="roleName" class="layui-input" lay-verify="required" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">角色备注</label>
        <div class="layui-input-inline">
            <textarea name="roleMemo" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">菜单信息</label>
        <div class="layui-input-inline">
            <div id="test12" class="demo-tree-more"></div>
        </div>
    </div>
    <div class="layui-form-item layui-hide">
        <input type="button" lay-submit lay-filter="LAY-app-role-add" id="LAY-app-role-add">
    </div>
</div>

<script src="${appName}/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '${appName}/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form', 'laydate', 'tree', 'util', 'admin', 'fims'], function () {
        var $ = layui.$,
            form = layui.form,
            admin = layui.admin,
            tree = layui.tree,
            util = layui.util,
            fims = layui.fims;

        // 应用名称
        var appName = '${appName}';

        var url = appName + "/role/selectInitData";

        // 初始化页面信息
        admin.req({
            url: url,
            type: "get",
            dataType: "json",
            done: function (response) {
                if (response.bizResult) {
                    fims.setCondition("layui-form", response.data.condition);
                    form.render();
                } else {
                    fims.msg(response.msg);
                }
            }
        });

        data = [{
            title: '一级1'
            ,id: 1
            ,field: 'name1'
            ,checked: true
            ,spread: true
            ,children: [{
                title: '二级1-1 可允许跳转'
                ,id: 3
                ,field: 'name11'
                ,href: 'https://www.layui.com/'
                ,children: [{
                    title: '三级1-1-3'
                    ,id: 23
                    ,field: ''
                    ,children: [{
                        title: '四级1-1-3-1'
                        ,id: 24
                        ,field: ''
                        ,children: [{
                            title: '五级1-1-3-1-1'
                            ,id: 30
                            ,field: ''
                        },{
                            title: '五级1-1-3-1-2'
                            ,id: 31
                            ,field: ''
                        }]
                    }]
                },{
                    title: '三级1-1-1'
                    ,id: 7
                    ,field: ''
                    ,children: [{
                        title: '四级1-1-1-1 可允许跳转'
                        ,id: 15
                        ,field: ''
                        ,href: 'https://www.layui.com/doc/'
                    }]
                },{
                    title: '三级1-1-2'
                    ,id: 8
                    ,field: ''
                    ,children: [{
                        title: '四级1-1-2-1'
                        ,id: 32
                        ,field: ''
                    }]
                }]
            },{
                title: '二级1-2'
                ,id: 4
                ,spread: true
                ,children: [{
                    title: '三级1-2-1'
                    ,id: 9
                    ,field: ''
                    ,disabled: true
                },{
                    title: '三级1-2-2'
                    ,id: 10
                    ,field: ''
                }]
            },{
                title: '二级1-3'
                ,id: 20
                ,field: ''
                ,children: [{
                    title: '三级1-3-1'
                    ,id: 21
                    ,field: ''
                },{
                    title: '三级1-3-2'
                    ,id: 22
                    ,field: ''
                }]
            }]
        },{
            title: '一级2'
            ,id: 2
            ,field: ''
            ,spread: true
            ,children: [{
                title: '二级2-1'
                ,id: 5
                ,field: ''
                ,spread: true
                ,children: [{
                    title: '三级2-1-1'
                    ,id: 11
                    ,field: ''
                },{
                    title: '三级2-1-2'
                    ,id: 12
                    ,field: ''
                }]
            },{
                title: '二级2-2'
                ,id: 6
                ,field: ''
                ,children: [{
                    title: '三级2-2-1'
                    ,id: 13
                    ,field: ''
                },{
                    title: '三级2-2-2'
                    ,id: 14
                    ,field: ''
                    ,disabled: true
                }]
            }]
        },{
            title: '一级3'
            ,id: 16
            ,field: ''
            ,children: [{
                title: '二级3-1'
                ,id: 17
                ,field: ''
                ,fixed: true
                ,children: [{
                    title: '三级3-1-1'
                    ,id: 18
                    ,field: ''
                },{
                    title: '三级3-1-2'
                    ,id: 19
                    ,field: ''
                }]
            },{
                title: '二级3-2'
                ,id: 27
                ,field: ''
                ,children: [{
                    title: '三级3-2-1'
                    ,id: 28
                    ,field: ''
                },{
                    title: '三级3-2-2'
                    ,id: 29
                    ,field: ''
                }]
            }]
        }]

        //基本演示
        tree.render({
            elem: '#test12',
            id: 'demoId1',
            data: data,
            showLine: false, // 是否显示连接线
            showCheckbox: true,  //是否显示复选框
            isJump: false, //是否允许点击节点时弹出新窗口跳转
            click: function(obj){
                var data = obj.data;  //获取当前点击的节点数据
                layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(data));
            }
        });

    })
</script>
</body>
</html>