

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>收入信息-详情</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="${appName}/layuiadmin/layui/css/layui.css" media="all">
</head>
<body>

<div class="layui-form" lay-filter="layuiadmin-app-form-list" id="layuiadmin-app-form-list" style="padding: 20px 30px 0 0;">
  <div class="layui-form-item">
    <label class="layui-form-label">文章标题</label>
    <div class="layui-input-inline">
      <input type="text" name="title" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">发布人</label>
    <div class="layui-input-inline">
      <input type="text" name="author" lay-verify="required" placeholder="请输入号码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">文章内容</label>
    <div class="layui-input-inline">
      <textarea name="content" lay-verify="required" style="width: 400px; height: 100px;" autocomplete="off"
                class="layui-textarea"></textarea>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">标签</label>
    <div class="layui-input-inline">
      <select name="label" lay-verify="required">
        <option value="">请选择标签</option>
        <option value="美食">美食</option>
        <option value="新闻">新闻</option>
        <option value="八卦">八卦</option>
        <option value="体育">体育</option>
        <option value="音乐">音乐</option>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">发布状态</label>
    <div class="layui-input-inline">
      <input type="checkbox" lay-verify="required" lay-filter="status" name="status" lay-skin="switch" lay-text="已发布|待修改">
    </div>
  </div>
  <div class="layui-form-item layui-hide">
    <input type="button" lay-submit lay-filter="layuiadmin-app-form-submit" id="layuiadmin-app-form-submit" value="确认添加">
    <input type="button" lay-submit lay-filter="layuiadmin-app-form-edit" id="layuiadmin-app-form-edit" value="确认编辑">
  </div>
</div>

<script src="${appName}/layuiadmin/layui/layui.js"></script>
<script>
  layui.config({
    base: '${appName}/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'form'], function(){
    var $ = layui.$,
        form = layui.form;

  })
</script>
</body>
</html>