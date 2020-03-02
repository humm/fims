-- 升级脚本
-- 发布版本修改点: sys_version新增记录  pom.xml修改版本  常量SYSTEM_VERSION修改

-- 修复 日期控件缺陷
call add_version('20190000000063', '日期控件加载不出来(一闪而过)', '2020-02-23', 310, '3');

-- 删除 系统参数文件上传路径
delete from sys_parameter where parameter_code = 'uploadLocation';

-- 删除 系统升级菜单
update sys_menu set is_enable = '0' where menu_id = '20190000000015';

-- 功能 自动化升级 Excel备份 优化随礼信息查询条件 发布新版本
call add_version('20190000000064', '随礼信息：送礼人、收礼人修改为模糊查询', '2020-02-23', 315, '2');
call add_version('20190000000065', '自动化系统升级', '2020-02-24', 320, '1');
call add_version('20190000000066', 'Excel备份', '2020-02-25', 325, '1');
call add_version('20190000000067', '发布版本：3.1.10', '2020-02-25', 326, '4');

call update_system_version('3.1.10');

-- 修复 邮件信息重复提醒
call add_version('20190000000068', '邮件信息：业务日期格式错误重复提醒', '2020-02-26', 330, '3');

-- 修改 系统参数描述
update sys_parameter set parameter_caption = '年度开始日期' where parameter_code = 'yearStartDate';

-- 修改 字典项D010
update sys_dictionary set dictionary_item = '2', item_order = '2' where dictionary_code = 'D010' and dictionary_item = '0';

-- 优化 新增备份模式参数
call add_parameter('backupMode', '系统备份模式', 'sql', 'checkbox', 'sql,dmp,xlsx', '1', '1', 36);
call add_version('20190000000069', '系统备份：新增备份模式参数', '2020-02-26', 335, '2');
call add_version('20190000000070', '发布版本：3.1.21', '2020-02-26', 340, '4');

call update_system_version('3.1.21');

delete from sys_dictionary where dictionary_code = 'D013';
insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D013', '#', '是否标识', null, 13, 20190000000001, '0', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D013', '1', '是', 1, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D013', '0', '否', 2, null, 20190000000001, null, null);

-- 微信用户信息
call drop_table('sys_wechat_user');
create table sys_wechat_user
(
    wechat_user_id       varchar2(100) primary key,
    wechat_public_id     varchar2(100) not null,
    is_auth             varchar2(50) default '0',
    user_id              number(30),
    create_date          timestamp(6) default sysdate,
    modify_date          timestamp(6) default sysdate,
    create_user          varchar2(50),
    modify_user          varchar2(50)
);
comment on column sys_wechat_user.wechat_user_id
    is '微信用户ID';
comment on column sys_wechat_user.wechat_public_id
    is '微信公众号ID';
comment on column sys_wechat_user.is_auth
    is '是否身份验证';
comment on column sys_wechat_user.user_id
    is '用户ID';
comment on column sys_wechat_user.create_date
    is '创建时间';
comment on column sys_wechat_user.modify_date
    is '修改时间';
comment on column sys_wechat_user.create_user
    is '创建人';
comment on column sys_wechat_user.modify_user
    is '修改人';


-- 微信操作流程步骤
call drop_table('sys_wechat_flow');
create table sys_wechat_flow
(
    flow_id              number(30) primary key,
    flow_num             varchar2(50),
    flow_code            varchar2(50),
    flow_describe        varchar2(500),
    flow_tips            varchar2(500),
    flow_type            varchar2(50),
    flow_order           number(10),
    is_show              varchar2(50),
    create_date          timestamp(6) default sysdate,
    modify_date          timestamp(6) default sysdate,
    create_user          varchar2(50),
    modify_user          varchar2(50)
);
comment on column sys_wechat_flow.flow_id
    is '流程步骤ID';
comment on column sys_wechat_flow.flow_num
    is '流程步骤序号';
comment on column sys_wechat_flow.flow_code
    is '流程步骤代码';
comment on column sys_wechat_flow.flow_describe
    is '流程步骤描述';
comment on column sys_wechat_flow.flow_tips
    is '流程步骤提示信息';
comment on column sys_wechat_flow.flow_order
    is '流程步骤排序';
comment on column sys_wechat_flow.is_show
    is '流程步骤是否显示';
comment on column sys_wechat_flow.flow_type
    is '流程步骤类型';
comment on column sys_wechat_flow.create_date
    is '创建时间';
comment on column sys_wechat_flow.modify_date
    is '修改时间';
comment on column sys_wechat_flow.create_user
    is '创建人';
comment on column sys_wechat_flow.modify_user
    is '修改人';

call add_parameter('weChatWelcome', '微信公众号欢迎语', '智慧家庭,畅享生活', 'text', null, '1', '1', 70);
call add_parameter('weChatKey', '微信公众号密钥', 'fims', 'text', null, '1', '1', 75);
call add_parameter('weChatOpen', '微信公众号对外开放状态', '2', 'switch', null, '1', '1', 80);
call add_parameter('weChatOperateTime', '微信用户操作时间间隔(秒)', '30', 'number', null, '1', '1', 85);

-- 功能脚本整理
