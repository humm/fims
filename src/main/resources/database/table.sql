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


call drop_table('sys_version');
create table sys_version
(
    version_id      number(15) primary key,
    version_no      varchar2(30)  not null,
    version_type    varchar2(30)  not null,
    version_content varchar2(500) not null,
    version_date    date,
    version_order   number(10)    not null
);
comment on column sys_version.version_id
    is '修订id';
comment on column sys_version.version_no
    is '修订版本';
comment on column sys_version.version_type
    is '修订类型';
comment on column sys_version.version_content
    is '修订内容';
comment on column sys_version.version_date
    is '修订时间';
comment on column sys_version.version_order
    is '修订排序';



call drop_table('sys_user');
create table sys_user
(
    user_id       number(15) primary key,
    user_code     varchar2(50) not null,
    user_name     varchar2(50) not null,
    user_password varchar2(50) not null,
    user_status   varchar2(1)  not null,
    is_admin      varchar2(1)  default '0',
    create_date   timestamp(6) default sysdate,
    modify_date   timestamp(6) default sysdate,
    create_user   varchar2(50),
    modify_user   varchar2(50),
    user_memo     varchar2(50)
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
comment on column sys_user.is_admin
    is '是否管理员';
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


call drop_table('sys_salary');
create table sys_salary
(
    salary_id      number(15) primary key,
    user_id        number(15)    not null,
    salary_type    varchar2(50)  not null,
    salary_date    date          not null,
    salary_company varchar2(500) not null,
    salary_amount  number(20, 2) not null,
    salary_memo    varchar2(500),
    create_date    timestamp(6) default sysdate,
    modify_date    timestamp(6) default sysdate,
    create_user    varchar2(50),
    modify_user    varchar2(50)
);
comment on column sys_salary.salary_id
    is '收入ID';
comment on column sys_salary.user_id
    is '收入人';
comment on column sys_salary.salary_type
    is '收入类型';
comment on column sys_salary.salary_date
    is '收入日期';
comment on column sys_salary.salary_company
    is '收入来源';
comment on column sys_salary.salary_amount
    is '收入金额';
comment on column sys_salary.salary_memo
    is '收入备注';
comment on column sys_salary.create_date
    is '创建时间';
comment on column sys_salary.modify_date
    is '修改时间';
comment on column sys_salary.create_user
    is '创建人';
comment on column sys_salary.modify_user
    is '修改人';


call drop_table('sys_dictionary');
create table sys_dictionary
(
    dictionary_code    VARCHAR2(50)  not null,
    dictionary_item    VARCHAR2(50)  not null,
    dictionary_caption VARCHAR2(100) not null,
    item_order         NUMBER(10),
    code_order         NUMBER(10),
    user_id            VARCHAR2(32)  not null,
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
    is '用户id';