call drop_table('SY_VERSION');

create table SY_VERSION
(
  id              VARCHAR2(32) default SYS_GUID() not null,
  version_no       VARCHAR2(32),
  version_content VARCHAR2(500),
  version_date    DATE,
  version_order   NUMBER(10)
);

comment on column SY_VERSION.version_no
  is '版本号';
comment on column SY_VERSION.version_content
  is '版本内容';
comment on column SY_VERSION.version_date
  is '版本时间';
comment on column SY_VERSION.version_order
  is '版本排序';


insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00000', '完成: 页面框架选型', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-10-21', 'yyyy-mm-dd'), 5);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00001', '完成: 工程初始化', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-10-26', 'yyyy-mm-dd'), 10);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00002', '完成: 收入信息', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-10-28', 'yyyy-mm-dd'), 15);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00003', '完成: 角色授权菜单信息', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-11-18', 'yyyy-mm-dd'), 20);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00004', '完成: 角色信息', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-11-22', 'yyyy-mm-dd'), 25);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00005', '完成: 首页菜单', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-11-25', 'yyyy-mm-dd'), 30);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00006', '完成: 用户信息', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-01', 'yyyy-mm-dd'), 35);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00007', '完成: 随礼信息', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-01', 'yyyy-mm-dd'), 40);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00008', '完成: 登录拦截,未登录访问跳转登录页面', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-03', 'yyyy-mm-dd'), 45);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00009', '完成: 字典信息', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-03', 'yyyy-mm-dd'), 50);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00010', '完成: Session处理', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-05', 'yyyy-mm-dd'), 55);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00011', '优化: 字典信息列表选值不展示', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-08', 'yyyy-mm-dd'), 56);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00012', '完成: 密码修改', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-08', 'yyyy-mm-dd'), 60);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00013', '完成: 登录日志信息', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-09', 'yyyy-mm-dd'), 70);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00014', '优化: admin用户展示全部菜单,不管菜单是否授权admin用户', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-09', 'yyyy-mm-dd'),65);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00015', '优化: 404页面风格', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-10', 'yyyy-mm-dd'), 66);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00016', '完成: 用户信息密码重置功能', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-10', 'yyyy-mm-dd'), 75);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00017', '完成: 收入预览', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-23', 'yyyy-mm-dd'), 85);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00018', '完成: 菜单新图标', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-23', 'yyyy-mm-dd'), 80);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00019', '完成: 随礼预览', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-30', 'yyyy-mm-dd'), 95);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00020', '完成: 版本信息', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-30', 'yyyy-mm-dd'), 90);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00021', '修复: 登录报错', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-31', 'yyyy-mm-dd'), 100);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00022', '优化: 随礼信息,送礼人或收礼人必须有一个为当前登录人', 'system-2018.10.21.001-SNAPSHOT', to_date('2018-12-31', 'yyyy-mm-dd'), 105);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00023', '完成: 首页信息', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-01-01', 'yyyy-mm-dd'), 110);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00024', '完成: 参数设置', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-01-05', 'yyyy-mm-dd'), 115);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00025', '优化: 首页点击弹窗', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-01-05', 'yyyy-mm-dd'), 120);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00026', '修复: 首页同比增长率统计异常', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-01-12', 'yyyy-mm-dd'), 125);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00027', '优化: 首页收入同比增长率改为同比增长数', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-01-26', 'yyyy-mm-dd'), 130);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00028', '优化: 系统参数设置,调整修改按钮大小', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-01-26', 'yyyy-mm-dd'), 135);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00029', '优化: 版本信息页面风格', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-01-26', 'yyyy-mm-dd'), 140);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00030', '修复: 首页同比增长数统计异常,只统计了当月最后一笔收入', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-03-25', 'yyyy-mm-dd'), 145);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00031', '优化: 版本信息页面风格', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-03-30', 'yyyy-mm-dd'), 150);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00032', '优化: 首页页面风格', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-03-30', 'yyyy-mm-dd'), 155);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00033', '完成: 系统初始化接口', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-03-31', 'yyyy-mm-dd'), 160);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00034', '完成: 数据备份', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-03-31', 'yyyy-mm-dd'), 165);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00035', '优化: 数据备份新增选项是否同步下载选项,新增备份文件本地存储', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-04-05', 'yyyy-mm-dd'), 170);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00036', '优化: 系统初始化接口新增密码校验', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-04-05', 'yyyy-mm-dd'), 175);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00037', '优化: 系统菜单加载', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-04-05', 'yyyy-mm-dd'), 180);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00038', '完成: 首页定时刷新', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-04-05', 'yyyy-mm-dd'), 185);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00039', '完成: 数据恢复', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-04-06', 'yyyy-mm-dd'), 190);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00040', '修复: 当前登录用户修改用户代码后退出异常', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-04-06', 'yyyy-mm-dd'), 195);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00041', '修复: 系统初始化接口Jar包运行找不到文件', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-04-07', 'yyyy-mm-dd'), 200);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00042', '修复: 数据备份同步下载文件中文乱码', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-04-07', 'yyyy-mm-dd'), 205);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00043', '修复: 页面删除按钮不可用', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-04-07', 'yyyy-mm-dd'), 210);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00044', '优化: 首页数据动态显示加载', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-04-13', 'yyyy-mm-dd'), 215);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00045', '优化: 首页刷新频率由系统参数控制', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-04-21', 'yyyy-mm-dd'), 220);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00046', '优化: 应用启动新增配置参数是否备份数据', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-04-21', 'yyyy-mm-dd'), 225);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00047', '完成: 邮件读取收入信息', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-04-25', 'yyyy-mm-dd'), 230);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00048', '优化: 邮件处理结果返回信息', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-04-25', 'yyyy-mm-dd'), 235);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00049', '优化: 配置参数设置默认值', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-05-23', 'yyyy-mm-dd'), 240);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00050', '优化: 应用启动数据库备份 邮件读取异常捕获', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-05-25', 'yyyy-mm-dd'), 245);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00051', '优化: session失效跳转登录页面', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-05-26', 'yyyy-mm-dd'), 250);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00052', '修复: 首页定时任务开启页面无响应', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-06-23', 'yyyy-mm-dd'), 255);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00053', '完成: 使用帮助', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-06-23', 'yyyy-mm-dd'), 260);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00054', '优化: 邮件数据读取存储格式', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-06-30', 'yyyy-mm-dd'), 265);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00055', '修复: 查询条件为空查询不出数据', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-06-30', 'yyyy-mm-dd'), 270);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00056', '完成: 系统升级', 'system-2018.10.21.001-SNAPSHOT', to_date('2019-07-01', 'yyyy-mm-dd'), 275);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00060', '完成：fims工程初始化', 'fims-2019.08.03.001-SNAPSHOT', to_date('2019-08-03', 'yyyy-mm-dd'), 280);

insert into sy_version (ID, VERSION_CONTENT, VERSION_NO, VERSION_DATE, VERSION_ORDER)
values ('VERSION_ABCDEFGHIJKLMNOPQRS00061', '完成：基础配置、集成邮件功能', 'fims-2019.08.03.001-SNAPSHOT', to_date('2019-08-04','yyyy-mm-dd'), 285);