-- 升级脚本

-- 发布版本修改点: sys_version新增记录  pom.xml修改版本  常量SYSTEM_VERSION修改
delete from sys_version where version_id = '20190000000063';
insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000063', '日期控件加载不出来(一闪而过)', to_date('23-02-2020', 'dd-mm-yyyy'), 310, '3');

delete from sys_parameter where parameter_code = 'uploadLocation';

update sys_menu set is_enable = '0' where menu_id = '20190000000015';

delete from sys_version where version_id in ('20190000000064', '20190000000065', '20190000000066', '20190000000067');
insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000064', '随礼信息：送礼人、收礼人修改为模糊查询', to_date('23-02-2020', 'dd-mm-yyyy'), 315, '2');
insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000065', '自动化系统升级', to_date('24-02-2020', 'dd-mm-yyyy'), 320, '1');
insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000066', 'Excel备份', to_date('25-02-2020', 'dd-mm-yyyy'), 325, '1');
insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000067', '发布版本：3.1.10', to_date('25-02-2020', 'dd-mm-yyyy'), 325, '4');
update sys_parameter set parameter_value = '3.1.10' where parameter_code = 'version';

delete from sys_version where version_id in ('20190000000068');
insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000068', '邮件信息：业务日期格式错误重复提醒', to_date('26-02-2020', 'dd-mm-yyyy'), 330, '3');
