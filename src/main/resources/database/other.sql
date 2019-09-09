call drop_table('sys_version');
create table sys_version
(
    version_id      number(30) primary key,
    version_no      varchar2(50)  not null,
    version_type    varchar2(50)  not null,
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


