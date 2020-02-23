-- 升级脚本
delete from sys_version where version_id = '20190000000063';
insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000063', '日期控件加载不出来(一闪而过)', to_date('23-02-2020', 'dd-mm-yyyy'), 310, '3');

delete from sys_parameter where parameter_code = 'uploadLocation';

update sys_menu set is_enable = '0' where menu_id = '20190000000015';

delete from sys_version where version_id = '20190000000064';
insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values ('20190000000064', '随礼信息：送礼人、收礼人修改为模糊查询', to_date('23-02-2020', 'dd-mm-yyyy'), 315, '2');

delete from sys_menu where menu_id = '20190000000022';
insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000022, '系统升级', null, 'system/view/update', 20190000000011, 115.00, '1', '1', sysdate, sysdate, '20190000000001', '20190000000001');

-- 功能修订信息补充


