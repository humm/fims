<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>收入信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${appName}/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${appName}/layuiadmin/style/admin.css" media="all">
</head>
<body>
<input type="hidden" id="appName" value="${appName}">
<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-form layui-card-header layuiadmin-card-header-auto">
            <div class="layui-form-item">
                <!-- 查询条件 -->
                <div class="layui-inline">
                    <label class="layui-form-label">ID</label>
                    <div class="layui-input-block">
                        <input type="text" name="id" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">发帖人</label>
                    <div class="layui-input-block">
                        <input type="text" name="poster" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">发帖内容</label>
                    <div class="layui-input-block">
                        <input type="text" name="content" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">帖子状态</label>
                    <div class="layui-input-block">
                        <select name="top">
                            <option value="0">正常</option>
                            <option value="1">置顶</option>
                            <option value="2">封禁</option>
                        </select>
                    </div>
                </div>

                <!-- 查询按钮 -->
                <div class="layui-inline">
                    <button class="layui-btn layuiadmin-btn-income-list" lay-submit
                            lay-filter="LAY-app-incomelist-search">
                        <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                    </button>
                </div>

            </div>
        </div>

        <div class="layui-card-body">
            <!-- 头部操作按钮 -->
            <div style="padding-bottom: 10px;" id="LAY-app-income-list-button">
                <button class="layui-btn layuiadmin-btn-income-list" data-type="batchdel">删除</button>
            </div>

            <!-- 列表数据 -->
            <table id="LAY-app-income-list" lay-filter="LAY-app-income-list"></table>

            <!--行数据按钮 -->
            <script type="text/html" id="table-income-list">
                <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit">
                    <i class="layui-icon layui-icon-edit"></i>编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">
                    <i class="layui-icon layui-icon-delete"></i>删除</a>
            </script>
        </div>
    </div>
</div>

<script src="${appName}/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '${appName}/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'fims', 'income', 'table'], function () {
        var $ = layui.$, form = layui.form, table = layui.table, fims = layui.fims;

        // 权限设置
        fims.setAuthority(false, "table-income-list,LAY-app-income-list-button");


        //监听搜索
        form.on('submit(LAY-app-incomelist-search)', function (data) {
            var field = data.field;

            //执行重载
            table.reload('LAY-app-income-list', {
                where: field
            });
        });

        //事件
        var active = {
            batchdel: function () {
                var checkStatus = table.checkStatus('LAY-app-income-list')
                    , checkData = checkStatus.data; //得到选中的数据

                if (checkData.length === 0) {
                    return layer.msg('请选择数据');
                }

                layer.confirm('确定删除吗？', function (index) {

                    //执行 Ajax 后重载
                    /*
                    admin.req({
                      url: 'xxx'
                      //,……
                    });
                    */
                    table.reload('LAY-app-income-list');
                    layer.msg('已删除');
                });
            }
        }

        $('.layui-btn.layuiadmin-btn-income-list').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>
</body>
</html>
