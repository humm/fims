-- 字段说明
-- 主键 number(30)
-- 备注 varchar2(500)
-- 排序 number(10)
-- 是否 varchar2(1)
-- 金额 number(20, 2)
-- 其他 varchar2(50)

-- 建表存储过程
create or replace procedure drop_table(tableName in varchar2)
is
    v_count number(10);
begin
    select count(1) into v_count from user_tables where table_name = upper(tableName);
    if v_count > 0
    then
        execute immediate 'drop table ' || tableName || ' purge';
    end if;
end drop_table;

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
    constraint pk_sys_dictionary primary key (dictionary_code, dictionary_item)
);

comment on column sy_dictionary.dictionary_code
    is '字典代码';
comment on column sy_dictionary.dictionary_item
    is '字典选值';
comment on column sy_dictionary.dictionary_caption
    is '字典描述';
comment on column sy_dictionary.item_order
    is '选值排序';
comment on column sy_dictionary.code_order
    is '代码排序';
comment on column sy_dictionary.user_id
    is '用户ID';
comment on column sy_dictionary.is_open
    is '是否开放';

-- 通知信息
call drop_table('sys_notice');
create table sys_notice
(
    notice_id           number(30)  primary key,
    user_id             number(30)  not null,
    business_id         number(30)  not null,
    business_type       varchar2(50) not null,
    business_sub_type   varchar2(50),
    business_date       timestamp(6) default sysdate,
    business_amount     number(20, 2),
    notice_status       varchar2(50) not null,
    notice_type         varchar2(50) not null,
    is_read             varchar2(1) not null,
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
comment on column sys_notice.is_read
    is '是否已读';
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
    menu_order    number(10) not null,
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