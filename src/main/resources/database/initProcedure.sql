-- 初始化存储过程

-- 存储过程以 ====== 六个等号分割
-- ====== --
-- 删除数据表
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
-- ====== --