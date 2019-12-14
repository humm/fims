create user hoomoomoo identified by hoomoomoo;
grant connect, create session, resource, create table, select any table, create any view, drop any view to hoomoomoo;
grant create any directory to hoomoomoo;
grant select on dba_directories to hoomoomoo;

-- todo 表空间 权限等设置

