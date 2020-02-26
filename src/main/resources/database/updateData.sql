-- 升级脚本

-- 发布版本修改点: sys_version新增记录  pom.xml修改版本  常量SYSTEM_VERSION修改

-- 修复 日期控件缺陷
delete from sys_version where version_id = '20190000000063';
insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000063', '日期控件加载不出来(一闪而过)', to_date('23-02-2020', 'dd-mm-yyyy'), 310, '3');

-- 删除 系统参数文件上传路径
delete from sys_parameter where parameter_code = 'uploadLocation';

-- 删系 统升级菜单
update sys_menu set is_enable = '0' where menu_id = '20190000000015';

-- 功能 自动化升级 Excel备份 优化随礼信息查询条件 发布新版本
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

-- 修复 邮件信息重复提醒
delete from sys_version where version_id in ('20190000000068');
insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000068', '邮件信息：业务日期格式错误重复提醒', to_date('26-02-2020', 'dd-mm-yyyy'), 330, '3');

-- 修改 系统参数描述
update sys_parameter set parameter_caption = '年度开始日期' where parameter_code = 'yearStartDate';

-- 修改 字典项D010
update sys_dictionary set dictionary_item = '2', item_order = '2' where dictionary_code = 'D010' and dictionary_item = '0';

-- 优化 新增备份模式参数
delete from sys_parameter where parameter_code = 'backupMode';
insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('backupMode', '系统备份模式', 'sql', 'checkbox', 'sql,dmp,xlsx', '1', '1', 36);

delete from sys_version where version_id in ('20190000000069', '20190000000070');
insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000069', '系统备份：新增备份模式参数', to_date('26-02-2020', 'dd-mm-yyyy'), 335, '2');
insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000070', '发布版本：3.1.20', to_date('26-02-2020', 'dd-mm-yyyy'), 340, '4');

update sys_parameter set parameter_value = '3.1.20' where parameter_code = 'version';