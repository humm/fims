-- 字段说明
-- 主键 number(30)
-- 备注 varchar2(500)
-- 排序 number(10)
-- 是否 varchar2(1)
-- 金额 number(20, 2)
-- 其他 varchar2(50)

-- 此文件存放建表语句及相关初始化数据 

-- 用户信息
call drop_table('sys_user');
create table sys_user
(
    user_id       number(30) primary key,
    user_code     varchar2(50) not null,
    user_name     varchar2(50) not null,
    user_password varchar2(50) not null,
    user_status   varchar2(50)  not null,
    user_memo     varchar2(500) default '',
    create_date   timestamp(6) default sysdate,
    modify_date   timestamp(6) default sysdate,
    create_user   varchar2(50),
    modify_user   varchar2(50)
);
comment on column sys_user.user_id
    is '用户ID';
comment on column sys_user.user_code
    is '用户代码';
comment on column sys_user.user_name
    is '用户名称';
comment on column sys_user.user_password
    is '用户密码';
comment on column sys_user.user_status
    is '用户状态';
comment on column sys_user.create_date
    is '创建时间';
comment on column sys_user.modify_date
    is '修改时间';
comment on column sys_user.create_user
    is '创建人';
comment on column sys_user.modify_user
    is '修改人';
comment on column sys_user.user_memo
    is '备注';

-- 收入信息
call drop_table('sys_income');
create table sys_income
(
    income_id      number(30) primary key,
    user_id        number(30)    not null,
    income_type    varchar2(50)  not null,
    income_date    date          not null,
    income_company varchar2(50)  not null,
    income_amount  number(20, 2) not null,
    income_memo    varchar2(500) default '',
    create_date    timestamp(6) default sysdate,
    modify_date    timestamp(6) default sysdate,
    create_user    varchar2(50),
    modify_user    varchar2(50)
);
comment on column sys_income.income_id
    is '收入ID';
comment on column sys_income.user_id
    is '收入人';
comment on column sys_income.income_type
    is '收入类型';
comment on column sys_income.income_date
    is '收入日期';
comment on column sys_income.income_company
    is '收入来源';
comment on column sys_income.income_amount
    is '收入金额';
comment on column sys_income.income_memo
    is '收入备注';
comment on column sys_income.create_date
    is '创建时间';
comment on column sys_income.modify_date
    is '修改时间';
comment on column sys_income.create_user
    is '创建人';
comment on column sys_income.modify_user
    is '修改人';

-- 字典信息
call drop_table('sys_dictionary');
create table sys_dictionary
(
    dictionary_code    varchar2(50)  not null,
    dictionary_item    varchar2(50)  not null,
    dictionary_caption varchar2(100) not null,
    item_order         number(10),
    code_order         number(10),
    user_id            number(30),
    is_open            varchar2(1),
    is_show            varchar2(1),
    constraint pk_sys_dictionary primary key (dictionary_code, dictionary_item)
);

comment on column sys_dictionary.dictionary_code
    is '字典代码';
comment on column sys_dictionary.dictionary_item
    is '字典选值';
comment on column sys_dictionary.dictionary_caption
    is '字典描述';
comment on column sys_dictionary.item_order
    is '选值排序';
comment on column sys_dictionary.code_order
    is '代码排序';
comment on column sys_dictionary.user_id
    is '用户ID';
comment on column sys_dictionary.is_open
    is '是否开放';
comment on column sys_dictionary.is_show
    is '是否显示';

-- 通知信息
call drop_table('sys_notice');
create table sys_notice
(
    notice_id           number(30)  primary key,
    user_id             number(30)  not null,
    business_id         number(30)  not null,
    business_type       varchar2(50) not null,
    business_sub_type   varchar2(50) not null,
    business_date       timestamp(6) default sysdate,
    business_amount     number(20, 2) not null,
    notice_status       varchar2(50) not null,
    notice_type         varchar2(50) not null,
    read_status         varchar2(1) not null,
    create_date         timestamp(6) default sysdate,
    modify_date         timestamp(6) default sysdate,
    create_user         varchar2(50),
    modify_user         varchar2(50)
);

comment on column sys_notice.notice_id
    is '通知ID';
comment on column sys_notice.user_id
    is '用户ID';
comment on column sys_notice.business_id
    is '业务ID';
comment on column sys_notice.business_type
    is '业务类型';
comment on column sys_notice.business_sub_type
    is '业务子类型';
comment on column sys_notice.business_date
    is '业务日期';
comment on column sys_notice.business_amount
    is '业务金额';
comment on column sys_notice.notice_status
    is '通知状态';
comment on column sys_notice.notice_type
    is '通知类型';
comment on column sys_notice.read_status
    is '阅读状态';
comment on column sys_notice.create_date
    is '创建时间';
comment on column sys_notice.modify_date
    is '修改时间';
comment on column sys_notice.create_user
    is '创建人';
comment on column sys_notice.modify_user
    is '修改人';

-- 随礼信息
call drop_table('sys_gift');
create table sys_gift
(
    gift_id       number(30)  primary key,
    gift_type     varchar2(50) not null,
    gift_sender   varchar2(50) not null,
    gift_receiver varchar2(50) not null,
    gift_date     date not null,
    gift_amount   number(20,2) not null,
    gift_memo     varchar2(500) default '',
    create_date   timestamp(6) default sysdate,
    modify_date   timestamp(6) default sysdate,
    create_user   varchar2(50),
    modify_user   varchar2(50)
);

comment on column sys_gift.gift_id
    is '随礼ID';
comment on column sys_gift.gift_type
    is '随礼类型';
comment on column sys_gift.gift_sender
    is '送礼人';
comment on column sys_gift.gift_receiver
    is '收礼人';
comment on column sys_gift.gift_date
    is '随礼日期';
comment on column sys_gift.gift_amount
    is '随礼金额';
comment on column sys_gift.gift_memo
    is '随礼备注';
comment on column sys_gift.create_date
    is '创建时间';
comment on column sys_gift.modify_date
    is '修改时间';
comment on column sys_gift.create_user
    is '创建人';
comment on column sys_gift.modify_user
    is '修改人';

-- 菜单信息
call drop_table('sys_menu');
create table sys_menu
(
    menu_id       number(30) primary key,
    menu_title    varchar2(50) not null,
    menu_icon     varchar2(50),
    menu_url      varchar2(500),
    parent_id     number(30),
    menu_order    number(10, 2) not null,
    is_enable     varchar2(1) not null,
    menu_type     varchar2(50) not null,
    create_date   timestamp(6) default sysdate,
    modify_date   timestamp(6) default sysdate,
    create_user   varchar2(50),
    modify_user   varchar2(50)
);

comment on column sys_menu.menu_id
    is '菜单ID';
comment on column sys_menu.menu_title
    is '菜单名称';
comment on column sys_menu.menu_icon
    is '菜单图标';
comment on column sys_menu.menu_url
    is '菜单地址';
comment on column sys_menu.parent_id
    is '父级菜单ID';
comment on column sys_menu.menu_order
    is '菜单排序';
comment on column sys_menu.is_enable
    is '是否启用';
comment on column sys_menu.menu_type
    is '菜单类型';
comment on column sys_menu.create_date
    is '创建时间';
comment on column sys_menu.modify_date
    is '修改时间';
comment on column sys_menu.create_user
    is '创建人';
comment on column sys_menu.modify_user
    is '修改人';

-- 角色信息
call drop_table('sys_role');
create table sys_role
(
    role_id     number(30) primary key,
    role_code   varchar2(50) not null,
    role_name   varchar2(50) not null,
    role_memo   varchar2(500) default '',
    create_date timestamp(6) default sysdate,
    modify_date timestamp(6) default sysdate,
    create_user varchar2(50),
    modify_user varchar2(50)
);

comment on column sys_role.role_id
    is '角色ID';
comment on column sys_role.role_code
    is '角色代码';
comment on column sys_role.role_name
    is '角色名称';
comment on column sys_role.role_memo
    is '角色备注';
comment on column sys_role.create_date
    is '创建时间';
comment on column sys_role.modify_date
    is '修改时间';
comment on column sys_role.create_user
    is '创建人';
comment on column sys_role.modify_user
    is '修改人';

-- 用户角色信息
call drop_table('sys_user_role');
create table sys_user_role
(
    user_role_id  number(30) primary key,
    user_id number(30) not null,
    role_id number(30) not null
);

comment on column sys_user_role.user_role_id
    is '用户角色ID';
comment on column sys_user_role.user_id
    is '用户ID';
comment on column sys_user_role.role_id
    is '角色ID';

-- 角色菜单信息
call drop_table('sys_role_menu');
create table sys_role_menu
(
    role_menu_id  number(30) primary key,
    role_id number(30),
    menu_id number(30)
);

comment on column sys_role_menu.role_menu_id
    is '角色菜单ID';
comment on column sys_role_menu.role_id
    is '角色ID';
comment on column sys_role_menu.menu_id
    is '菜单ID';

-- 参数信息
call drop_table('sys_parameter');
create table sys_parameter
(
    parameter_code    varchar2(50) primary key,
    parameter_caption varchar2(50),
    parameter_value   varchar2(500),
    parameter_type    varchar2(50),
    parameter_ext     varchar2(50),
    is_show           varchar2(1),
    is_edit           varchar2(1),
    parameter_order   number(10)
);

comment on column sys_parameter.parameter_code
    is '参数代码';
comment on column sys_parameter.parameter_caption
    is '参数描述';
comment on column sys_parameter.parameter_value
    is '参数值';
comment on column sys_parameter.parameter_type
    is '参数类型';
comment on column sys_parameter.parameter_ext
    is '扩展参数';
comment on column sys_parameter.is_show
    is '是否显示';
comment on column sys_parameter.is_edit
    is '是否可编辑';
comment on column sys_parameter.parameter_order
    is '参数排序';

-- 登录日志信息
call drop_table('sys_login_log');
create table sys_login_log
(
    log_id        varchar2(30) primary key,
    user_id       varchar2(30),
    login_date    timestamp(6) default sysdate,
    logout_date   timestamp(6),
    login_status  varchar2(50),
    login_message varchar2(50)
);

comment on column sys_login_log.log_id
    is '日志ID';
comment on column sys_login_log.user_id
    is '用户ID';
comment on column sys_login_log.login_date
    is '登录时间';
comment on column sys_login_log.logout_date
    is '登出时间';
comment on column sys_login_log.login_status
    is '登录状态';
comment on column sys_login_log.login_message
    is '登录信息';

-- 修订信息
call drop_table('sys_version');
create table sys_version
(
    version_id        varchar2(30) primary key,
    version_content   varchar2(500),
    version_date      date,
    version_order     number(10),
    version_type      varchar2(50)
);

comment on column sys_version.version_id
    is '修订ID';
comment on column sys_version.version_content
    is '修订内容';
comment on column sys_version.version_date
    is '修订日期';
comment on column sys_version.version_order
    is '修订排序';
comment on column sys_version.version_type
    is '修订类型(1:功能 2:优化 3:修复 4:发版)';

-- 配置信息
call drop_table('sys_config');
create table sys_config
(
    module_group_code   varchar2(50),
    module_group_name   varchar2(50),
    module_code         varchar2(50),
    module_name         varchar2(50),
    module_status       varchar2(50),
    module_ext          varchar2(500),
    constraint sys_config_pk primary key(module_group_code , module_code)
);

comment on column sys_config.module_group_code
    is '模块组代码';
comment on column sys_config.module_group_name
    is '模块组名称';
comment on column sys_config.module_code
    is '模块代码';
comment on column sys_config.module_name
    is '模块名称';
comment on column sys_config.module_status
    is '模块状态';
comment on column sys_config.module_ext
    is '模块扩展参数';


-- 初始化数据 开始
-- 用户信息
truncate table sys_user;
insert into sys_user (USER_ID, USER_CODE, USER_NAME, USER_PASSWORD, USER_STATUS, CREATE_DATE, MODIFY_DATE, CREATE_USER, MODIFY_USER, USER_MEMO)
values (20190000000001, 'admin', '管理员', '123456', 'D001-1', sysdate, sysdate, '20190000000001', '20190000000001', '系统管理员，不能删除');

-- 菜单信息
truncate table sys_menu;
insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000000, '数据权限', null, null, null, 0.00, '1', '4', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000001, '收入信息', 'layui-icon-flag', 'income/view/list', null, 10.00, '1', '1', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000002, '查询权限', null, null, 20190000000001, 15.00, '1', '2', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000003, '设置权限', null, null, 20190000000001, 20.00, '1', '3', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000004, '随礼信息', 'layui-icon-transfer', 'gift/view/list', null, 25.00, '1', '1', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000005, '查询权限', null, null, 20190000000004, 30.00, '1', '2', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000006, '设置权限', null, null, 20190000000004, 35.00, '1', '3', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000007, '统计分析', 'layui-icon-chart', '#', null, 60.00, '1', '1', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000008, '收入分析', null, 'report/view/income', 20190000000007, 65.00, '1', '1', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000009, '送礼分析', null, 'report/view/giftSend', 20190000000007, 70.00, '1', '1', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000010, '收礼分析', null, 'report/view/giftReceive', 20190000000007, 75.00, '1', '1', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000011, '系统设置', 'layui-icon-engine', '#', null, 80.00, '1', '1', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000012, '用户信息', null, 'user/view/list', 20190000000011, 85.00, '1', '1', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000013, '角色信息', null, 'role/view/list', 20190000000011, 90.00, '1', '1', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000014, '字典信息', null, 'dictionary/view/list', 20190000000011, 100.00, '1', '1', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000015, '图标信息', null, 'icon/view/list', 20190000000011, 999999.00, '1', '1', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000016, '参数信息', null, 'parameter/view/list', 20190000000011, 95.00, '1', '1', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000017, '消息通知', 'layui-icon-notice', 'notice/view/list', null, 61.00, '1', '1', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000018, '查询权限', null, null, 20190000000017, 45.00, '1', '2', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000019, '登录日志', 'layui-icon-log', 'loginLog/view/list', null, 62.00, '1', '1', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000020, '查询权限', null, null, 20190000000019, 55.00, '1', '2', sysdate, sysdate, '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000021, '修订信息', null, 'version/view/list', 20190000000011, 110.00, '1', '1', sysdate, sysdate, '20190000000001', '20190000000001');

-- 字典信息
truncate table sys_dictionary;

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D001', '#', '用户状态', null, 1, 20190000000001, '0', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D001', '1', '正常', 1, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D001', '2', '冻结', 2, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D002', '#', '状态标识', null, 2, 20190000000001, '0', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D002', '1', '成功', 1, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D002', '2', '失败', 2, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D003', '#', '收入类型', null, 3, 20190000000001, '1', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D003', '1', '工资', 1, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D003', '2', '年终奖', 2, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D003', '3', '公积金', 3, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D004', '#', '随礼类型', null, 4, 20190000000001, '1', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D004', '1', '结婚', 1, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D004', '2', '生娃', 2, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D005', '#', '收入来源', null, 5, 20190000000001, '1', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D006', '#', '大额支出类型', null, 6, 20190000000001, '1', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D007', '#', '消息通知状态', null, 7, 20190000000001, '0', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D007', '1', '正常', 1, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D007', '2', '撤销', 2, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D008', '#', '消息通知类型', null, 8, 20190000000001, '0', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D008', '1', '自录', 1, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D008', '2', '邮件', 2, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '#', '随礼人', null, 9, 20190000000001, '1', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D010', '#', '参数状态类型', null, 10, 20190000000001, '0', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D010', '1', '开启', 1, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D010', '2', '关闭', 2, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D011', '#', '业务类型', null, 11, 20190000000001, '0', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D011', '1', '收入', 1, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D011', '2', '随礼', 2, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D012', '#', '阅读状态', null, 12, 20190000000001, '0', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D012', '1', '未读', 1, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D012', '2', '已读', 2, null, 20190000000001, null, null);

-- 系统参数
truncate table sys_parameter;
insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('uploadLocation', '文件上传路径', '#', 'text', null, '1', '1', 5);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('backupLocation', '系统备份路径', '#', 'text', null, '1', '1', 10);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('mindFill', '智能填充', '1', 'switch', null, '1', '1', 15);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('startConsoleOutput', '系统启动输出配置参数', '1', 'switch', null, '1', '1', 20);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('consoleOutputLogRequestTag', '控制台输出请求标记', '1', 'switch', null, '1', '1', 25);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('consoleOutputLogRequestParameter', '控制台输出请求入参', '1', 'switch', null, '1', '1', 30);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('startBackup', '系统启动备份数据库', '0', 'switch', null, '1', '1', 35);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('startMail', '系统启动读取邮件', '0', 'switch', null, '1', '1', 40);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('yearStartDate', '年度开始时间(yyyymm)', '201901', 'date', '6', '1', '1', 45);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('sessionTimeout', 'session超时时间(秒)', '60', 'number', '5', '1', '1', 45);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('userDefaultPassword', '用户默认密码', '123456', 'text', null, '1', '1', 50);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('version', '系统版本号', 'V.201911.01', 'text', null, '1', '0', 55);

-- 修订信息
truncate table sys_version;
insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000001', '系统初始化', to_date('19-08-2017', 'dd-mm-yyyy'), 1, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000002', '发布版本：V1.201811.01', to_date('11-08-2018', 'dd-mm-yyyy'), 5, '4');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000003', '系统初始化', to_date('21-10-2018', 'dd-mm-yyyy'), 10, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000004', '发布版本：V2.201907.01', to_date('01-07-2019', 'dd-mm-yyyy'), 15, '4');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000005', '系统初始化', to_date('07-08-2019', 'dd-mm-yyyy'), 20, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000006', '流水号生成、集成Swagger', to_date('08-08-2019', 'dd-mm-yyyy'), 25, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000007', '集成webSocket、通用工具类', to_date('09-08-2019', 'dd-mm-yyyy'), 30, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000008', '集成freemarker、适配前台页面布局', to_date('10-08-2019', 'dd-mm-yyyy'), 35, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000009', '字典转义、日志输出、前台页面布局', to_date('11-08-2019', 'dd-mm-yyyy'), 40, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000010', '日志输出工具类封装、字典转义支持单条数据', to_date('12-08-2019', 'dd-mm-yyyy'), 45, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000011', 'dto目录调整为Model目录、返回实体类返回值整合', to_date('15-08-2019', 'dd-mm-yyyy'), 50, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000012', '适配前台页面布局', to_date('16-08-2019', 'dd-mm-yyyy'), 55, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000013', '按用户加载查询数据字典', to_date('23-08-2019', 'dd-mm-yyyy'), 60, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000014', '收入信息：数据列表、查询条件', to_date('29-08-2019', 'dd-mm-yyyy'), 65, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000015', '收入信息', to_date('01-09-2019', 'dd-mm-yyyy'), 70, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000016', '全局异常处理', to_date('01-09-2019', 'dd-mm-yyyy'), 75, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000017', '随礼信息', to_date('07-09-2019', 'dd-mm-yyyy'), 80, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000018', '收入信息报表：年度、月度', to_date('09-09-2019', 'dd-mm-yyyy'), 85, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000019', '收入信息报表：来源、类型、极值、前台页面渲染', to_date('13-09-2019', 'dd-mm-yyyy'), 90, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000020', '随礼信息报表', to_date('13-09-2019', 'dd-mm-yyyy'), 95, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000021', '字典信息', to_date('21-09-2019', 'dd-mm-yyyy'), 100, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000022', '用户信息', to_date('22-09-2019', 'dd-mm-yyyy'), 105, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000023', '角色信息', to_date('08-10-2019', 'dd-mm-yyyy'), 110, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000024', '业务ID编号规则', to_date('11-10-2019', 'dd-mm-yyyy'), 115, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000025', '登录加载菜单信息', to_date('13-10-2019', 'dd-mm-yyyy'), 120, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000026', '页面按钮权限、字典加载数据权限', to_date('13-10-2019', 'dd-mm-yyyy'), 125, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000027', '用户登录', to_date('15-10-2019', 'dd-mm-yyyy'), 130, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000028', '用户Session信息', to_date('18-10-2019', 'dd-mm-yyyy'), 135, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000029', '登录过滤器', to_date('19-10-2019', 'dd-mm-yyyy'), 140, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000030', '字典信息', to_date('19-10-2019', 'dd-mm-yyyy'), 145, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000031', '图标信息', to_date('20-10-2019', 'dd-mm-yyyy'), 150, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000032', '菜单图标', to_date('21-10-2019', 'dd-mm-yyyy'), 155, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000033', '参数信息', to_date('25-10-2019', 'dd-mm-yyyy'), 160, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000034', '重置用户密码、用户退出、修改用户密码', to_date('26-10-2019', 'dd-mm-yyyy'), 165, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000035', '登入日志、消息通知', to_date('26-10-2019', 'dd-mm-yyyy'), 170, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000036', '修复列表翻页查询数据错误', to_date('26-10-2019', 'dd-mm-yyyy'), 175, '3');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000037', '首页信息', to_date('02-11-2019', 'dd-mm-yyyy'), 180, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000038', '消息通知：页面展示风格', to_date('03-11-2019', 'dd-mm-yyyy'), 185, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000039', '首页信息：展示未读消息通知', to_date('04-11-2019', 'dd-mm-yyyy'), 190, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000040', '报表信息：多用户数据展示', to_date('17-11-2019', 'dd-mm-yyyy'), 195, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000041', '数据转义', to_date('21-11-2019', 'dd-mm-yyyy'), 200, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000042', '修订信息', to_date('23-11-2019', 'dd-mm-yyyy'), 205, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000043', '发布版本：V3.201911.01', to_date('24-11-2019', 'dd-mm-yyyy'), 210, '4');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000044', '消息通知详情页面返回指定列表类型', to_date('25-11-2019', 'dd-mm-yyyy'), 215, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000045', '初始化系统配置数据', to_date('25-11-2019', 'dd-mm-yyyy'), 220, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000046', '自定义首页模块', to_date('27-11-2019', 'dd-mm-yyyy'), 225, '1');

-- 初始化数据 结束