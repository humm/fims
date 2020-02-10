-- 数据备份清单 开始
-- sys_user
-- sys_role
-- sys_user_role
-- sys_menu
-- sys_role_menu
-- sys_dictionary
-- sys_parameter
-- sys_notice
-- sys_version
-- sys_login_log
-- sys_income
-- sys_gift
-- sys_interface
-- sys_config
-- 数据备份清单 结束

-- 数据备份 开始
-- sys_user
truncate table sys_user;
commit;

insert into sys_user (user_id, user_code, user_name, user_password, user_status, user_memo, create_date, modify_date, create_user, modify_user)
values (20190000000001, 'admin', '管理员', '2UDNzITM', 'D001-1', '系统管理员，不能删除', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_user (user_id, user_code, user_name, user_password, user_status, user_memo, create_date, modify_date, create_user, modify_user)
values (20190000000002, 'maomao', '二毛', '2UDNzITM', 'D001-1', ' ', to_timestamp('2020-02-07 15:55:30', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 17:11:18', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_user (user_id, user_code, user_name, user_password, user_status, user_memo, create_date, modify_date, create_user, modify_user)
values (20190000000003, 'yali', '雅丽', '2UDNzITM', 'D001-1', ' ', to_timestamp('2020-02-07 15:55:30', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 17:11:28', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

commit;
-- sys_role
truncate table sys_role;
commit;

insert into sys_role (role_id, role_code, role_name, role_memo, create_date, modify_date, create_user, modify_user)
values (20200000000001, 'admin', '系统管理员角色', '系统管理员角色', to_timestamp('2020-02-07 17:10:38', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 17:10:38', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

commit;
-- sys_user_role
truncate table sys_user_role;
commit;

insert into sys_user_role (user_role_id, user_id, role_id)
values (20200000000001, 20190000000002, 20200000000001);

insert into sys_user_role (user_role_id, user_id, role_id)
values (20200000000002, 20190000000003, 20200000000001);

commit;
-- sys_menu
truncate table sys_menu;
commit;

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000000, '数据权限', null, null, null, 0, '1', '4', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000001, '收入信息', 'layui-icon-flag', 'income/view/list', null, 10, '1', '1', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000002, '查询权限', null, null, 20190000000001, 15, '1', '2', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000003, '设置权限', null, null, 20190000000001, 20, '1', '3', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000004, '随礼信息', 'layui-icon-transfer', 'gift/view/list', null, 25, '1', '1', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000005, '查询权限', null, null, 20190000000004, 30, '1', '2', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000006, '设置权限', null, null, 20190000000004, 35, '1', '3', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000007, '统计分析', 'layui-icon-chart', '#', null, 60, '1', '1', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000008, '收入分析', null, 'report/view/income', 20190000000007, 65, '1', '1', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000009, '送礼分析', null, 'report/view/giftSend', 20190000000007, 70, '1', '1', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000010, '收礼分析', null, 'report/view/giftReceive', 20190000000007, 75, '1', '1', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000011, '系统设置', 'layui-icon-engine', '#', null, 80, '1', '1', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000012, '用户信息', null, 'user/view/list', 20190000000011, 85, '1', '1', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000013, '角色信息', null, 'role/view/list', 20190000000011, 90, '1', '1', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000014, '字典信息', null, 'dictionary/view/list', 20190000000011, 100, '1', '1', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000015, '图标信息', null, 'icon/view/list', 20190000000011, 999999, '1', '1', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000016, '参数信息', null, 'parameter/view/list', 20190000000011, 95, '1', '1', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000017, '消息通知', 'layui-icon-notice', 'notice/view/list', null, 61, '1', '1', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000018, '查询权限', null, null, 20190000000017, 45, '1', '2', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000019, '登录日志', 'layui-icon-log', 'loginLog/view/list', null, 62, '1', '1', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000020, '查询权限', null, null, 20190000000019, 55, '1', '2', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

insert into sys_menu (menu_id, menu_title, menu_icon, menu_url, parent_id, menu_order, is_enable, menu_type, create_date, modify_date, create_user, modify_user)
values (20190000000021, '修订信息', null, 'version/view/list', 20190000000011, 110, '1', '1', to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:11:50', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001');

commit;
-- sys_role_menu
truncate table sys_role_menu;
commit;

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000001, 20200000000001, 20190000000001);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000002, 20200000000001, 20190000000002);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000003, 20200000000001, 20190000000003);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000004, 20200000000001, 20190000000004);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000005, 20200000000001, 20190000000005);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000006, 20200000000001, 20190000000006);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000007, 20200000000001, 20190000000007);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000008, 20200000000001, 20190000000008);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000009, 20200000000001, 20190000000009);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000010, 20200000000001, 20190000000010);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000011, 20200000000001, 20190000000017);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000012, 20200000000001, 20190000000018);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000013, 20200000000001, 20190000000019);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000014, 20200000000001, 20190000000020);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000015, 20200000000001, 20190000000011);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000016, 20200000000001, 20190000000012);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000017, 20200000000001, 20190000000013);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000018, 20200000000001, 20190000000016);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000019, 20200000000001, 20190000000014);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000020, 20200000000001, 20190000000021);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000021, 20200000000001, 20190000000015);

insert into sys_role_menu (role_menu_id, role_id, menu_id)
values (20200000000022, 20200000000001, 20190000000000);

commit;
-- sys_dictionary
truncate table sys_dictionary;
commit;

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
values ('D003', '3', '公积金', 3, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D003', '4', '奖金', 4, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D003', '5', '出差补贴', 5, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D003', '6', '失业保险金', 6, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D004', '#', '随礼类型', null, 4, 20190000000001, '1', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D004', '1', '结婚', 1, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D004', '2', '生娃', 2, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D005', '#', '收入来源', null, 5, 20190000000001, '1', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D005', '1', '宁波慈星股份有限公司', 1, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D005', '2', '招商银行杭州分行', 2, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D005', '3', '浙江恒强科技股份有限公司', 3, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D005', '4', '浙江久拓科技有限公司', 4, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D005', '5', '华信咨询设计研究院有限公司', 5, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D005', '6', '杭州吉利易云科技有限公司', 6, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D005', '7', '恒生电子股份有限公司', 7, null, 20190000000002, null, null);

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
values ('D009', '1', '周大林', 3, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '10', '肖海刚', 12, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '11', '胡永兵', 13, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '12', '廖龙龙', 14, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '13', '胡琳', 15, null, 20190000000003, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '14', '二毛-云南姐姐', 16, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '15', '二毛-女女姐姐', 17, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '16', '二毛-大姑姑', 18, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '17', '二毛-三姑姑', 19, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '18', '二毛-小姑姑', 20, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '19', '二毛-青青老表', 21, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '2', '易明', 4, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '20', '二毛-大伯母', 22, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '20190000000002', '二毛', null, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '20190000000003', '雅丽', null, null, 20190000000003, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '21', '二毛-小伯母', 23, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '22', '二毛-胡小聪', 24, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '23', '二毛-奶奶', 25, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '24', '二毛-大姨', 26, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '25', '二毛-李娟', 27, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '26', '二毛-李敏', 28, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '27', '二毛-外婆', 29, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '28', '雅丽-奶奶', 30, null, 20190000000003, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '29', '雅丽-大姑姑', 31, null, 20190000000003, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '3', '韩声海', 5, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '30', '雅丽-小姑姑', 32, null, 20190000000003, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '31', '雅丽-叔叔', 33, null, 20190000000003, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '32', '雅丽-颖韬', 34, null, 20190000000003, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '33', '雅丽-大舅妈', 35, null, 20190000000003, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '34', '雅丽-二舅妈', 36, null, 20190000000003, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '35', '雅丽-小舅妈', 37, null, 20190000000003, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '36', '雅丽-艳梅', 38, null, 20190000000003, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '37', '雅丽-雪梅', 39, null, 20190000000003, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '38', '雅丽-雨晴', 40, null, 20190000000003, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '39', '雅丽-梅兰', 41, null, 20190000000003, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '4', '刘诱', 6, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '40', '雅丽-小姨', 42, null, 20190000000003, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '41', '雅丽-二姨', 43, null, 20190000000003, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '5', '敖丽平', 7, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '6', '郭锦', 8, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '7', '朱凌钦', 9, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '8', '孙俪', 10, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '9', '黄霄', 11, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D010', '#', '参数状态类型', null, 10, 20190000000001, '0', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D010', '0', '关闭', 0, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D010', '1', '开启', 1, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D011', '#', '业务类型', null, 11, 20190000000001, '0', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D011', '1', '收入', 1, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D011', '2', '送礼', 2, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D011', '3', '收礼', 3, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D012', '#', '阅读状态', null, 12, 20190000000001, '0', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D012', '1', '未读', 1, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D012', '2', '已读', 2, null, 20190000000001, null, null);

commit;
-- sys_parameter
truncate table sys_parameter;
commit;

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('backupLocation', '系统备份路径', 'D:\fims\backup', 'text', null, '1', '1', 10);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('consoleOutputLogRequestParameter', '控制台输出请求入参', '1', 'switch', null, '1', '1', 30);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('consoleOutputLogRequestTag', '控制台输出请求标记', '1', 'switch', null, '1', '1', 25);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('cookieTimeout', 'cookie有效时间(天)', '15', 'number', '5', '1', '1', 55);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('messageTip', '未读消息提醒', '1', 'switch', null, '1', '1', 65);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('mindFill', '智能填充', '1', 'switch', null, '1', '1', 15);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('sessionTimeout', 'session有效时间(秒)', '300', 'number', '5', '1', '1', 50);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('startBackup', '系统启动备份数据库', '1', 'switch', null, '1', '1', 35);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('startConsoleOutput', '系统启动输出配置参数', '1', 'switch', null, '1', '1', 20);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('startMail', '系统启动读取邮件', '1', 'switch', null, '1', '1', 40);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('uploadLocation', '文件上传路径', '#', 'text', null, '1', '1', 5);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('userDefaultPassword', '用户默认密码', '123456', 'text', null, '1', '1', 60);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('version', '系统版本号', '3.1.00', 'text', null, '1', '0', 999);

insert into sys_parameter (parameter_code, parameter_caption, parameter_value, parameter_type, parameter_ext, is_show, is_edit, parameter_order)
values ('yearStartDate', '年度开始时间(yyyymm)', '202002', 'date', '6', '1', '1', 45);

commit;
-- sys_notice
truncate table sys_notice;
commit;

commit;
-- sys_version
truncate table sys_version;
commit;

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000001, '系统初始化', to_timestamp('2017-08-19', 'yyyy-MM-dd'), 1, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000002, '发布版本：1.0.00', to_timestamp('2018-08-11', 'yyyy-MM-dd'), 5, '4');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000003, '系统初始化', to_timestamp('2018-10-21', 'yyyy-MM-dd'), 10, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000004, '发布版本：2.0.00', to_timestamp('2019-07-01', 'yyyy-MM-dd'), 15, '4');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000005, '系统初始化', to_timestamp('2019-08-07', 'yyyy-MM-dd'), 20, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000006, '流水号生成、集成Swagger', to_timestamp('2019-08-08', 'yyyy-MM-dd'), 25, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000007, '集成webSocket、通用工具类', to_timestamp('2019-08-09', 'yyyy-MM-dd'), 30, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000008, '集成freemarker、适配前台页面布局', to_timestamp('2019-08-10', 'yyyy-MM-dd'), 35, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000009, '字典转义、日志输出、前台页面布局', to_timestamp('2019-08-11', 'yyyy-MM-dd'), 40, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000010, '日志输出工具类封装、字典转义支持单条数据', to_timestamp('2019-08-12', 'yyyy-MM-dd'), 45, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000011, 'dto目录调整为Model目录、返回实体类返回值整合', to_timestamp('2019-08-15', 'yyyy-MM-dd'), 50, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000012, '适配前台页面布局', to_timestamp('2019-08-16', 'yyyy-MM-dd'), 55, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000013, '按用户加载查询数据字典', to_timestamp('2019-08-23', 'yyyy-MM-dd'), 60, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000014, '收入信息：数据列表、查询条件', to_timestamp('2019-08-29', 'yyyy-MM-dd'), 65, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000015, '收入信息', to_timestamp('2019-09-01', 'yyyy-MM-dd'), 70, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000016, '全局异常处理', to_timestamp('2019-09-01', 'yyyy-MM-dd'), 75, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000017, '随礼信息', to_timestamp('2019-09-07', 'yyyy-MM-dd'), 80, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000018, '收入信息报表：年度、月度', to_timestamp('2019-09-09', 'yyyy-MM-dd'), 85, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000019, '收入信息报表：来源、类型、极值、前台页面渲染', to_timestamp('2019-09-13', 'yyyy-MM-dd'), 90, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000020, '随礼信息报表', to_timestamp('2019-09-13', 'yyyy-MM-dd'), 95, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000021, '字典信息', to_timestamp('2019-09-21', 'yyyy-MM-dd'), 100, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000022, '用户信息', to_timestamp('2019-09-22', 'yyyy-MM-dd'), 105, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000023, '角色信息', to_timestamp('2019-10-08', 'yyyy-MM-dd'), 110, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000024, '业务ID编号规则', to_timestamp('2019-10-11', 'yyyy-MM-dd'), 115, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000025, '登录加载菜单信息', to_timestamp('2019-10-13', 'yyyy-MM-dd'), 120, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000026, '页面按钮权限、字典加载数据权限', to_timestamp('2019-10-13', 'yyyy-MM-dd'), 125, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000027, '用户登录', to_timestamp('2019-10-15', 'yyyy-MM-dd'), 130, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000028, '用户Session信息', to_timestamp('2019-10-18', 'yyyy-MM-dd'), 135, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000029, '登录过滤器', to_timestamp('2019-10-19', 'yyyy-MM-dd'), 140, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000030, '字典信息', to_timestamp('2019-10-19', 'yyyy-MM-dd'), 145, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000031, '图标信息', to_timestamp('2019-10-20', 'yyyy-MM-dd'), 150, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000032, '菜单图标', to_timestamp('2019-10-21', 'yyyy-MM-dd'), 155, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000033, '参数信息', to_timestamp('2019-10-25', 'yyyy-MM-dd'), 160, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000034, '重置用户密码、用户退出、修改用户密码', to_timestamp('2019-10-26', 'yyyy-MM-dd'), 165, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000035, '登入日志、消息通知', to_timestamp('2019-10-26', 'yyyy-MM-dd'), 170, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000036, '列表翻页查询数据错误', to_timestamp('2019-10-26', 'yyyy-MM-dd'), 175, '3');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000037, '首页信息', to_timestamp('2019-11-02', 'yyyy-MM-dd'), 180, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000038, '消息通知：页面展示风格', to_timestamp('2019-11-03', 'yyyy-MM-dd'), 185, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000039, '首页信息：展示未读消息通知', to_timestamp('2019-11-04', 'yyyy-MM-dd'), 190, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000040, '报表信息：多用户数据展示', to_timestamp('2019-11-17', 'yyyy-MM-dd'), 195, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000041, '数据转义', to_timestamp('2019-11-21', 'yyyy-MM-dd'), 200, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000042, '修订信息', to_timestamp('2019-11-23', 'yyyy-MM-dd'), 205, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000043, '发布版本：3.0.00', to_timestamp('2019-11-24', 'yyyy-MM-dd'), 210, '4');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000044, '消息通知详情页面返回指定列表类型', to_timestamp('2019-11-25', 'yyyy-MM-dd'), 215, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000045, '初始化系统配置数据', to_timestamp('2019-11-25', 'yyyy-MM-dd'), 220, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000046, '自定义首页显示模块', to_timestamp('2019-11-27', 'yyyy-MM-dd'), 225, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000047, '系统备份：sql文件模式、dmp文件模式', to_timestamp('2019-11-30', 'yyyy-MM-dd'), 230, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000048, '首页未读消息提醒新增参数控制', to_timestamp('2019-12-07', 'yyyy-MM-dd'), 235, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000049, '首页提示信息、登录信息新增菜单跳转链接', to_timestamp('2019-12-07', 'yyyy-MM-dd'), 240, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000050, '首页链接跳转TAB名称统一处理', to_timestamp('2019-12-14', 'yyyy-MM-dd'), 245, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000051, '下拉选择框显示key值、字典信息修改页面隐藏key值', to_timestamp('2020-02-03', 'yyyy-MM-dd'), 250, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000052, '随礼信息修改时不能显示随礼人信息', to_timestamp('2020-02-03', 'yyyy-MM-dd'), 255, '3');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000053, '数据权限修改后session刷新不及时导致查询到脏数据', to_timestamp('2020-02-03', 'yyyy-MM-dd'), 260, '3');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000054, '发布版本：3.0.01', to_timestamp('2020-02-03', 'yyyy-MM-dd'), 265, '4');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000055, '删除角色时不删除sys_role_menu数据造成脏数据', to_timestamp('2020-02-05', 'yyyy-MM-dd'), 270, '3');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000056, '删除角色时不删除sys_user_role数据造成脏数据', to_timestamp('2020-02-05', 'yyyy-MM-dd'), 275, '3');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000057, 'session失效列表数据查询报错不跳转登录页面', to_timestamp('2020-02-05', 'yyyy-MM-dd'), 280, '3');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000058, '登入：记住密码', to_timestamp('2020-02-08', 'yyyy-MM-dd'), 285, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000059, '添加系统logo', to_timestamp('2020-02-09', 'yyyy-MM-dd'), 290, '2');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000060, '邮件申请数据处理：支持业务类型为收入、随礼', to_timestamp('2020-02-10', 'yyyy-MM-dd'), 295, '1');

insert into sys_version (version_id, version_content, version_date, version_order, version_type)
values (20190000000061, '发布版本：3.1.00', to_timestamp('2020-02-10', 'yyyy-MM-dd'), 300, '4');

commit;
-- sys_login_log
truncate table sys_login_log;
commit;

insert into sys_login_log (log_id, user_id, login_date, logout_date, login_status, login_message)
values (20200000000001, 20190000000001, to_timestamp('2020-02-07 15:30:44', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 15:38:38', 'yyyy-MM-dd hh24:mi:ss'), 'D002-1', '登入成功');

insert into sys_login_log (log_id, user_id, login_date, logout_date, login_status, login_message)
values (20200000000002, 20190000000001, to_timestamp('2020-02-07 15:56:24', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 16:08:16', 'yyyy-MM-dd hh24:mi:ss'), 'D002-1', '登入成功');

insert into sys_login_log (log_id, user_id, login_date, logout_date, login_status, login_message)
values (20200000000003, 20190000000001, to_timestamp('2020-02-07 16:18:42', 'yyyy-MM-dd hh24:mi:ss'), null, 'D002-1', '登入成功');

insert into sys_login_log (log_id, user_id, login_date, logout_date, login_status, login_message)
values (20200000000004, 20190000000001, to_timestamp('2020-02-07 16:39:52', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 16:49:37', 'yyyy-MM-dd hh24:mi:ss'), 'D002-1', '登入成功');

insert into sys_login_log (log_id, user_id, login_date, logout_date, login_status, login_message)
values (20200000000005, 20190000000001, to_timestamp('2020-02-07 16:57:42', 'yyyy-MM-dd hh24:mi:ss'), null, 'D002-1', '登入成功');

insert into sys_login_log (log_id, user_id, login_date, logout_date, login_status, login_message)
values (20200000000006, 20190000000001, to_timestamp('2020-02-07 17:08:26', 'yyyy-MM-dd hh24:mi:ss'), null, 'D002-1', '登入成功');

insert into sys_login_log (log_id, user_id, login_date, logout_date, login_status, login_message)
values (20200000000007, 20190000000002, to_timestamp('2020-02-07 17:15:52', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-10 14:00:08', 'yyyy-MM-dd hh24:mi:ss'), 'D002-1', '登入成功');

insert into sys_login_log (log_id, user_id, login_date, logout_date, login_status, login_message)
values (20200000000008, 20190000000002, to_timestamp('2020-02-10 14:10:33', 'yyyy-MM-dd hh24:mi:ss'), null, 'D002-1', '登入成功');

insert into sys_login_log (log_id, user_id, login_date, logout_date, login_status, login_message)
values (20200000000009, 20190000000002, to_timestamp('2020-02-10 14:22:24', 'yyyy-MM-dd hh24:mi:ss'), null, 'D002-1', '登入成功');

commit;
-- sys_income
truncate table sys_income;
commit;

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000001, 20190000000002, 'D003-1', to_timestamp('2010-04-28', 'yyyy-MM-dd'), 'D005-1', 1300, null, to_timestamp('2010-04-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2010-04-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000002, 20190000000002, 'D003-1', to_timestamp('2010-05-28', 'yyyy-MM-dd'), 'D005-1', 3600, null, to_timestamp('2010-05-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2010-05-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000003, 20190000000002, 'D003-1', to_timestamp('2010-06-28', 'yyyy-MM-dd'), 'D005-1', 3500, null, to_timestamp('2010-06-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2010-06-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000004, 20190000000002, 'D003-1', to_timestamp('2010-07-28', 'yyyy-MM-dd'), 'D005-1', 1900, null, to_timestamp('2010-07-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2010-07-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000005, 20190000000002, 'D003-1', to_timestamp('2010-08-28', 'yyyy-MM-dd'), 'D005-1', 3200, null, to_timestamp('2010-08-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2010-08-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000006, 20190000000002, 'D003-1', to_timestamp('2010-09-28', 'yyyy-MM-dd'), 'D005-1', 2700, null, to_timestamp('2010-09-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2010-09-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000007, 20190000000002, 'D003-1', to_timestamp('2010-10-28', 'yyyy-MM-dd'), 'D005-1', 2900, null, to_timestamp('2010-10-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2010-10-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000008, 20190000000002, 'D003-1', to_timestamp('2010-11-28', 'yyyy-MM-dd'), 'D005-1', 3213, null, to_timestamp('2010-11-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2010-11-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000009, 20190000000002, 'D003-1', to_timestamp('2010-12-28', 'yyyy-MM-dd'), 'D005-1', 3345, null, to_timestamp('2010-12-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2010-12-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000010, 20190000000002, 'D003-1', to_timestamp('2011-01-28', 'yyyy-MM-dd'), 'D005-1', 2645, null, to_timestamp('2011-01-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2011-01-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000011, 20190000000002, 'D003-1', to_timestamp('2011-02-28', 'yyyy-MM-dd'), 'D005-1', 3223, null, to_timestamp('2011-02-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2011-02-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000012, 20190000000002, 'D003-1', to_timestamp('2011-03-28', 'yyyy-MM-dd'), 'D005-1', 2798, null, to_timestamp('2011-03-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2011-03-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000013, 20190000000002, 'D003-1', to_timestamp('2011-04-28', 'yyyy-MM-dd'), 'D005-1', 4777, null, to_timestamp('2011-04-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2011-04-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000014, 20190000000002, 'D003-1', to_timestamp('2011-05-28', 'yyyy-MM-dd'), 'D005-1', 3811, null, to_timestamp('2011-05-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2011-05-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000015, 20190000000002, 'D003-1', to_timestamp('2011-06-28', 'yyyy-MM-dd'), 'D005-1', 3945, null, to_timestamp('2011-06-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2011-06-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000016, 20190000000002, 'D003-1', to_timestamp('2011-07-28', 'yyyy-MM-dd'), 'D005-1', 3212, null, to_timestamp('2011-07-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2011-07-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000017, 20190000000002, 'D003-1', to_timestamp('2011-08-28', 'yyyy-MM-dd'), 'D005-1', 2057, null, to_timestamp('2011-08-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2011-08-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000018, 20190000000002, 'D003-1', to_timestamp('2011-09-28', 'yyyy-MM-dd'), 'D005-1', 1722, null, to_timestamp('2011-09-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2011-09-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000019, 20190000000002, 'D003-1', to_timestamp('2011-10-28', 'yyyy-MM-dd'), 'D005-1', 1850, null, to_timestamp('2011-10-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2011-10-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000020, 20190000000002, 'D003-1', to_timestamp('2011-11-28', 'yyyy-MM-dd'), 'D005-1', 1529, null, to_timestamp('2011-11-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2011-11-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000021, 20190000000002, 'D003-1', to_timestamp('2011-12-28', 'yyyy-MM-dd'), 'D005-1', 2456, null, to_timestamp('2011-12-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2011-12-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000022, 20190000000002, 'D003-1', to_timestamp('2012-01-13', 'yyyy-MM-dd'), 'D005-1', 2756, null, to_timestamp('2012-01-13 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2012-01-13 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000023, 20190000000002, 'D003-1', to_timestamp('2012-04-20', 'yyyy-MM-dd'), 'D005-2', 1310, null, to_timestamp('2012-04-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2012-04-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000024, 20190000000002, 'D003-1', to_timestamp('2012-05-18', 'yyyy-MM-dd'), 'D005-2', 4196, null, to_timestamp('2012-05-18 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2012-05-18 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000025, 20190000000002, 'D003-1', to_timestamp('2012-06-20', 'yyyy-MM-dd'), 'D005-2', 5696, null, to_timestamp('2012-06-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2012-06-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000026, 20190000000002, 'D003-1', to_timestamp('2012-07-20', 'yyyy-MM-dd'), 'D005-2', 6041, null, to_timestamp('2012-07-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2012-07-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000027, 20190000000002, 'D003-1', to_timestamp('2012-08-20', 'yyyy-MM-dd'), 'D005-2', 5978, null, to_timestamp('2012-08-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2012-08-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000028, 20190000000002, 'D003-1', to_timestamp('2012-09-20', 'yyyy-MM-dd'), 'D005-2', 6353, null, to_timestamp('2012-09-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2012-09-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000029, 20190000000002, 'D003-1', to_timestamp('2012-10-19', 'yyyy-MM-dd'), 'D005-2', 6558, null, to_timestamp('2012-10-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2012-10-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000030, 20190000000002, 'D003-1', to_timestamp('2012-11-20', 'yyyy-MM-dd'), 'D005-2', 8033, null, to_timestamp('2012-11-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2012-11-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000031, 20190000000002, 'D003-1', to_timestamp('2012-12-20', 'yyyy-MM-dd'), 'D005-2', 4970, null, to_timestamp('2012-12-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2012-12-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000032, 20190000000002, 'D003-1', to_timestamp('2013-01-18', 'yyyy-MM-dd'), 'D005-2', 6291, null, to_timestamp('2013-01-18 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-01-18 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000033, 20190000000002, 'D003-1', to_timestamp('2013-02-20', 'yyyy-MM-dd'), 'D005-2', 5400, null, to_timestamp('2013-02-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-02-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000034, 20190000000002, 'D003-1', to_timestamp('2013-03-20', 'yyyy-MM-dd'), 'D005-2', 3995, null, to_timestamp('2013-03-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-03-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000035, 20190000000002, 'D003-1', to_timestamp('2013-04-19', 'yyyy-MM-dd'), 'D005-2', 6543, null, to_timestamp('2013-04-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-04-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000036, 20190000000002, 'D003-1', to_timestamp('2013-05-20', 'yyyy-MM-dd'), 'D005-2', 5813, null, to_timestamp('2013-05-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-05-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000037, 20190000000002, 'D003-6', to_timestamp('2013-06-20', 'yyyy-MM-dd'), 'D005-2', 1474, '失业保险金', to_timestamp('2013-06-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-06-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000038, 20190000000002, 'D003-1', to_timestamp('2013-06-20', 'yyyy-MM-dd'), 'D005-3', 322, null, to_timestamp('2013-06-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-06-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000039, 20190000000002, 'D003-1', to_timestamp('2013-07-20', 'yyyy-MM-dd'), 'D005-3', 2043, null, to_timestamp('2013-07-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-07-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000040, 20190000000002, 'D003-3', to_timestamp('2013-06-13', 'yyyy-MM-dd'), 'D005-2', 4747.96, null, to_timestamp('2013-06-13 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-06-13 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000041, 20190000000002, 'D003-1', to_timestamp('2013-08-20', 'yyyy-MM-dd'), 'D005-3', 2699, null, to_timestamp('2013-08-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-08-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000042, 20190000000002, 'D003-1', to_timestamp('2013-09-22', 'yyyy-MM-dd'), 'D005-3', 2540, null, to_timestamp('2013-09-22 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-09-22 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000043, 20190000000002, 'D003-1', to_timestamp('2013-10-23', 'yyyy-MM-dd'), 'D005-3', 2119, null, to_timestamp('2013-10-23 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-10-23 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000044, 20190000000002, 'D003-1', to_timestamp('2013-11-20', 'yyyy-MM-dd'), 'D005-3', 3249, null, to_timestamp('2013-11-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-11-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000045, 20190000000002, 'D003-1', to_timestamp('2013-12-20', 'yyyy-MM-dd'), 'D005-3', 2119, null, to_timestamp('2013-12-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-12-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000046, 20190000000002, 'D003-5', to_timestamp('2013-12-21', 'yyyy-MM-dd'), 'D005-3', 6320, null, to_timestamp('2013-12-21 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-12-21 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000047, 20190000000002, 'D003-1', to_timestamp('2014-01-21', 'yyyy-MM-dd'), 'D005-3', 4353, null, to_timestamp('2014-01-21 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2014-01-21 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000048, 20190000000002, 'D003-2', to_timestamp('2014-01-21', 'yyyy-MM-dd'), 'D005-3', 2344, null, to_timestamp('2014-01-21 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2014-01-21 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000049, 20190000000002, 'D003-1', to_timestamp('2014-02-20', 'yyyy-MM-dd'), 'D005-3', 2869, null, to_timestamp('2014-02-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2014-02-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000050, 20190000000002, 'D003-1', to_timestamp('2014-03-20', 'yyyy-MM-dd'), 'D005-3', 2824, null, to_timestamp('2014-03-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2014-03-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000051, 20190000000002, 'D003-1', to_timestamp('2014-04-20', 'yyyy-MM-dd'), 'D005-3', 2944, null, to_timestamp('2014-04-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2014-04-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000052, 20190000000002, 'D003-1', to_timestamp('2014-05-20', 'yyyy-MM-dd'), 'D005-3', 2929, null, to_timestamp('2014-05-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2014-05-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000053, 20190000000002, 'D003-1', to_timestamp('2014-06-20', 'yyyy-MM-dd'), 'D005-3', 3019, null, to_timestamp('2014-06-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2014-06-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000054, 20190000000002, 'D003-1', to_timestamp('2014-07-20', 'yyyy-MM-dd'), 'D005-3', 2916, null, to_timestamp('2014-07-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2014-07-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000055, 20190000000002, 'D003-5', to_timestamp('2014-07-21', 'yyyy-MM-dd'), 'D005-3', 7680, null, to_timestamp('2014-07-21 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2014-07-21 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000056, 20190000000002, 'D003-1', to_timestamp('2014-08-20', 'yyyy-MM-dd'), 'D005-3', 3694, null, to_timestamp('2014-08-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2014-08-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000057, 20190000000002, 'D003-1', to_timestamp('2014-09-20', 'yyyy-MM-dd'), 'D005-3', 3756, null, to_timestamp('2014-09-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2014-09-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000058, 20190000000002, 'D003-1', to_timestamp('2014-10-20', 'yyyy-MM-dd'), 'D005-3', 3766, null, to_timestamp('2014-10-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2014-10-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000059, 20190000000002, 'D003-1', to_timestamp('2014-11-20', 'yyyy-MM-dd'), 'D005-3', 4315, null, to_timestamp('2014-11-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2014-11-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000060, 20190000000002, 'D003-1', to_timestamp('2014-12-20', 'yyyy-MM-dd'), 'D005-3', 4885, null, to_timestamp('2014-12-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2014-12-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000061, 20190000000002, 'D003-1', to_timestamp('2015-01-20', 'yyyy-MM-dd'), 'D005-3', 4789, null, to_timestamp('2015-01-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2015-01-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000062, 20190000000002, 'D003-1', to_timestamp('2015-02-10', 'yyyy-MM-dd'), 'D005-3', 4821, null, to_timestamp('2015-02-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2015-02-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000063, 20190000000002, 'D003-1', to_timestamp('2015-02-11', 'yyyy-MM-dd'), 'D005-3', 3414, null, to_timestamp('2015-02-11 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2015-02-11 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000064, 20190000000002, 'D003-1', to_timestamp('2015-03-20', 'yyyy-MM-dd'), 'D005-3', 4045, null, to_timestamp('2015-03-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2015-03-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000065, 20190000000002, 'D003-1', to_timestamp('2015-04-20', 'yyyy-MM-dd'), 'D005-3', 1309, null, to_timestamp('2015-04-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2015-04-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000066, 20190000000002, 'D003-3', to_timestamp('2015-05-20', 'yyyy-MM-dd'), 'D005-3', 7837, null, to_timestamp('2015-05-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2015-05-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000067, 20190000000002, 'D003-1', to_timestamp('2015-08-10', 'yyyy-MM-dd'), 'D005-4', 2340, null, to_timestamp('2015-08-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2015-08-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000068, 20190000000002, 'D003-1', to_timestamp('2015-09-10', 'yyyy-MM-dd'), 'D005-4', 4743, null, to_timestamp('2015-09-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2015-09-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000069, 20190000000002, 'D003-1', to_timestamp('2015-10-10', 'yyyy-MM-dd'), 'D005-4', 4324, null, to_timestamp('2015-10-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2015-10-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000070, 20190000000002, 'D003-1', to_timestamp('2015-11-10', 'yyyy-MM-dd'), 'D005-4', 5439, null, to_timestamp('2015-11-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2015-11-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000071, 20190000000002, 'D003-1', to_timestamp('2015-12-10', 'yyyy-MM-dd'), 'D005-4', 4980, null, to_timestamp('2015-12-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2015-12-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000072, 20190000000002, 'D003-1', to_timestamp('2016-01-10', 'yyyy-MM-dd'), 'D005-4', 4980, null, to_timestamp('2016-01-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-01-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000073, 20190000000002, 'D003-1', to_timestamp('2016-02-10', 'yyyy-MM-dd'), 'D005-4', 4911, null, to_timestamp('2016-02-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-02-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000074, 20190000000002, 'D003-2', to_timestamp('2016-02-10', 'yyyy-MM-dd'), 'D005-4', 1303, null, to_timestamp('2016-02-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-02-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000075, 20190000000002, 'D003-1', to_timestamp('2016-03-10', 'yyyy-MM-dd'), 'D005-4', 4200, null, to_timestamp('2016-03-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-03-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000076, 20190000000002, 'D003-1', to_timestamp('2016-04-20', 'yyyy-MM-dd'), 'D005-5', 3884, null, to_timestamp('2016-04-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-04-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000077, 20190000000002, 'D003-1', to_timestamp('2016-04-25', 'yyyy-MM-dd'), 'D005-5', 6660, null, to_timestamp('2016-04-25 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-04-25 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000078, 20190000000002, 'D003-1', to_timestamp('2016-05-25', 'yyyy-MM-dd'), 'D005-5', 5500, null, to_timestamp('2016-05-25 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-05-25 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000079, 20190000000002, 'D003-1', to_timestamp('2016-06-27', 'yyyy-MM-dd'), 'D005-5', 5000, null, to_timestamp('2016-06-27 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-06-27 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000080, 20190000000002, 'D003-1', to_timestamp('2016-07-25', 'yyyy-MM-dd'), 'D005-5', 6800, null, to_timestamp('2016-07-25 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-07-25 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000081, 20190000000002, 'D003-1', to_timestamp('2016-09-12', 'yyyy-MM-dd'), 'D005-5', 7351, null, to_timestamp('2016-09-12 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-09-12 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000082, 20190000000002, 'D003-5', to_timestamp('2016-09-22', 'yyyy-MM-dd'), 'D005-5', 1040, null, to_timestamp('2016-09-22 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-09-22 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000083, 20190000000002, 'D003-1', to_timestamp('2016-10-10', 'yyyy-MM-dd'), 'D005-5', 6703, null, to_timestamp('2016-10-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-10-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000084, 20190000000002, 'D003-1', to_timestamp('2016-11-10', 'yyyy-MM-dd'), 'D005-5', 6703, null, to_timestamp('2016-11-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-11-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000085, 20190000000002, 'D003-1', to_timestamp('2016-12-10', 'yyyy-MM-dd'), 'D005-5', 6928, null, to_timestamp('2016-12-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-12-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000086, 20190000000002, 'D003-5', to_timestamp('2016-12-27', 'yyyy-MM-dd'), 'D005-5', 2100, null, to_timestamp('2016-12-27 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-12-27 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000087, 20190000000002, 'D003-4', to_timestamp('2017-01-10', 'yyyy-MM-dd'), 'D005-5', 3600, '项目奖金', to_timestamp('2017-01-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-01-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000088, 20190000000002, 'D003-2', to_timestamp('2017-01-10', 'yyyy-MM-dd'), 'D005-5', 4700, null, to_timestamp('2017-01-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-01-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000089, 20190000000002, 'D003-1', to_timestamp('2017-01-10', 'yyyy-MM-dd'), 'D005-5', 6800, null, to_timestamp('2017-01-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-01-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000090, 20190000000002, 'D003-1', to_timestamp('2017-02-10', 'yyyy-MM-dd'), 'D005-5', 6704, null, to_timestamp('2017-02-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-02-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000091, 20190000000002, 'D003-5', to_timestamp('2017-03-10', 'yyyy-MM-dd'), 'D005-5', 1120, null, to_timestamp('2017-03-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-03-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000092, 20190000000002, 'D003-1', to_timestamp('2017-03-10', 'yyyy-MM-dd'), 'D005-5', 6704, null, to_timestamp('2017-03-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-03-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000093, 20190000000002, 'D003-4', to_timestamp('2017-04-10', 'yyyy-MM-dd'), 'D005-5', 1500, '优秀员工奖金', to_timestamp('2017-04-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-04-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000094, 20190000000002, 'D003-1', to_timestamp('2017-04-10', 'yyyy-MM-dd'), 'D005-5', 6998, null, to_timestamp('2017-04-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-04-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000095, 20190000000002, 'D003-4', to_timestamp('2017-05-10', 'yyyy-MM-dd'), 'D005-5', 2979, '项目奖金', to_timestamp('2017-05-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-05-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000096, 20190000000002, 'D003-1', to_timestamp('2017-05-10', 'yyyy-MM-dd'), 'D005-5', 6700, null, to_timestamp('2017-05-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-05-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000097, 20190000000002, 'D003-1', to_timestamp('2017-06-09', 'yyyy-MM-dd'), 'D005-5', 6299, null, to_timestamp('2017-06-09 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-06-09 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000098, 20190000000002, 'D003-1', to_timestamp('2017-06-15', 'yyyy-MM-dd'), 'D005-5', 1335, null, to_timestamp('2017-06-15 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-06-15 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000099, 20190000000002, 'D003-5', to_timestamp('2017-06-16', 'yyyy-MM-dd'), 'D005-5', 1260, null, to_timestamp('2017-06-16 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-06-16 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000100, 20190000000002, 'D003-1', to_timestamp('2017-07-20', 'yyyy-MM-dd'), 'D005-6', 3637, null, to_timestamp('2017-07-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-07-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000101, 20190000000002, 'D003-3', to_timestamp('2017-08-04', 'yyyy-MM-dd'), 'D005-5', 5937, null, to_timestamp('2017-08-04 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-08-04 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000102, 20190000000002, 'D003-1', to_timestamp('2017-08-20', 'yyyy-MM-dd'), 'D005-6', 7149, null, to_timestamp('2017-08-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-08-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000103, 20190000000002, 'D003-1', to_timestamp('2017-09-20', 'yyyy-MM-dd'), 'D005-6', 6942, null, to_timestamp('2017-09-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-09-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000104, 20190000000002, 'D003-1', to_timestamp('2017-10-20', 'yyyy-MM-dd'), 'D005-6', 8490, null, to_timestamp('2017-10-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-10-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000105, 20190000000002, 'D003-1', to_timestamp('2017-11-20', 'yyyy-MM-dd'), 'D005-6', 9786, null, to_timestamp('2017-11-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-11-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000106, 20190000000002, 'D003-1', to_timestamp('2017-12-20', 'yyyy-MM-dd'), 'D005-6', 13297, null, to_timestamp('2017-12-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-12-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000107, 20190000000002, 'D003-1', to_timestamp('2018-01-19', 'yyyy-MM-dd'), 'D005-6', 11947, null, to_timestamp('2018-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000108, 20190000000002, 'D003-1', to_timestamp('2018-01-26', 'yyyy-MM-dd'), 'D005-7', 8148, null, to_timestamp('2018-01-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-01-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000109, 20190000000002, 'D003-1', to_timestamp('2018-02-10', 'yyyy-MM-dd'), 'D005-6', 2286, null, to_timestamp('2018-02-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-02-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000110, 20190000000002, 'D003-1', to_timestamp('2018-02-26', 'yyyy-MM-dd'), 'D005-7', 9089, null, to_timestamp('2018-02-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-02-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000111, 20190000000002, 'D003-1', to_timestamp('2018-03-26', 'yyyy-MM-dd'), 'D005-7', 9041, null, to_timestamp('2018-03-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-03-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000112, 20190000000002, 'D003-1', to_timestamp('2018-04-26', 'yyyy-MM-dd'), 'D005-7', 11209, null, to_timestamp('2018-04-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-04-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000113, 20190000000002, 'D003-1', to_timestamp('2018-05-26', 'yyyy-MM-dd'), 'D005-7', 11384, null, to_timestamp('2018-05-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-05-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000114, 20190000000002, 'D003-1', to_timestamp('2018-06-26', 'yyyy-MM-dd'), 'D005-7', 10645, null, to_timestamp('2018-06-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-06-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000115, 20190000000002, 'D003-1', to_timestamp('2018-07-26', 'yyyy-MM-dd'), 'D005-7', 10493, null, to_timestamp('2018-07-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-07-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000116, 20190000000002, 'D003-1', to_timestamp('2018-08-26', 'yyyy-MM-dd'), 'D005-7', 11634, null, to_timestamp('2018-08-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-08-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000117, 20190000000002, 'D003-1', to_timestamp('2018-09-26', 'yyyy-MM-dd'), 'D005-7', 11642, null, to_timestamp('2018-09-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-09-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000118, 20190000000002, 'D003-1', to_timestamp('2018-10-26', 'yyyy-MM-dd'), 'D005-7', 12221, null, to_timestamp('2018-10-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-10-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000119, 20190000000002, 'D003-1', to_timestamp('2018-11-26', 'yyyy-MM-dd'), 'D005-7', 12068, null, to_timestamp('2018-11-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-11-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000120, 20190000000002, 'D003-1', to_timestamp('2018-12-26', 'yyyy-MM-dd'), 'D005-7', 12082, null, to_timestamp('2018-12-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-12-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000121, 20190000000002, 'D003-1', to_timestamp('2019-01-25', 'yyyy-MM-dd'), 'D005-7', 12913, null, to_timestamp('2019-01-25 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-25 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000122, 20190000000002, 'D003-2', to_timestamp('2019-01-31', 'yyyy-MM-dd'), 'D005-7', 19400, null, to_timestamp('2019-01-31 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-31 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000123, 20190000000002, 'D003-1', to_timestamp('2019-02-26', 'yyyy-MM-dd'), 'D005-7', 12536.43, null, to_timestamp('2019-02-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-02-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000124, 20190000000002, 'D003-1', to_timestamp('2019-03-26', 'yyyy-MM-dd'), 'D005-7', 12283.26, null, to_timestamp('2019-03-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-03-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000125, 20190000000002, 'D003-1', to_timestamp('2019-04-26', 'yyyy-MM-dd'), 'D005-7', 16294.21, '补发1月至3月3000', to_timestamp('2019-04-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-04-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000126, 20190000000002, 'D003-1', to_timestamp('2019-05-26', 'yyyy-MM-dd'), 'D005-7', 13442.41, null, to_timestamp('2019-05-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-05-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000127, 20190000000002, 'D003-1', to_timestamp('2019-06-26', 'yyyy-MM-dd'), 'D005-7', 12692.73, null, to_timestamp('2019-06-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-06-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000128, 20190000000002, 'D003-1', to_timestamp('2019-07-26', 'yyyy-MM-dd'), 'D005-7', 12615.14, null, to_timestamp('2019-07-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-07-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000129, 20190000000002, 'D003-1', to_timestamp('2019-08-26', 'yyyy-MM-dd'), 'D005-7', 12926.7, null, to_timestamp('2019-08-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-08-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000130, 20190000000002, 'D003-1', to_timestamp('2019-09-26', 'yyyy-MM-dd'), 'D005-7', 15689.7, '补发7月至8月2100', to_timestamp('2019-09-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-09-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000131, 20190000000002, 'D003-1', to_timestamp('2019-10-26', 'yyyy-MM-dd'), 'D005-7', 13745.7, null, to_timestamp('2019-10-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-10-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000132, 20190000000002, 'D003-1', to_timestamp('2019-11-26', 'yyyy-MM-dd'), 'D005-7', 13606.2, null, to_timestamp('2019-11-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-11-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000133, 20190000000002, 'D003-1', to_timestamp('2019-12-26', 'yyyy-MM-dd'), 'D005-7', 13606.2, null, to_timestamp('2019-12-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-12-26 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000134, 20190000000002, 'D003-3', to_timestamp('2018-04-23', 'yyyy-MM-dd'), 'D005-6', 11000, null, to_timestamp('2018-04-23 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-04-23 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000135, 20190000000002, 'D003-3', to_timestamp('2019-05-28', 'yyyy-MM-dd'), 'D005-7', 12000, null, to_timestamp('2019-05-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-05-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000136, 20190000000002, 'D003-3', to_timestamp('2016-06-04', 'yyyy-MM-dd'), 'D005-4', 1795.17, null, to_timestamp('2016-06-04 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-06-04 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000137, 20190000000002, 'D003-1', to_timestamp('2020-01-22', 'yyyy-MM-dd'), 'D005-7', 14223.26, null, to_timestamp('2020-01-22 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-22 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000138, 20190000000002, 'D003-2', to_timestamp('2020-01-23', 'yyyy-MM-dd'), 'D005-7', 29100, null, to_timestamp('2020-01-23 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-23 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000139, 20190000000002, 'D003-3', to_timestamp('2020-01-31', 'yyyy-MM-dd'), 'D005-7', 9000, ' ', to_timestamp('2020-02-07 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-07 17:16:29', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

commit;
-- sys_gift
truncate table sys_gift;
commit;

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000000, 'D004-2', 'D009-20190000000003', 'D009-32', to_timestamp('2018-01-19', 'yyyy-MM-dd'), 1600, '日期已忘记', to_timestamp('2018-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000003', '20190000000003');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000001, 'D004-1', 'D009-20190000000002', 'D009-2', to_timestamp('2014-01-01', 'yyyy-MM-dd'), 666, '日期已忘记', to_timestamp('2014-01-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2014-01-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000002, 'D004-1', 'D009-20190000000002', 'D009-1', to_timestamp('2014-01-01', 'yyyy-MM-dd'), 666, '日期已忘记', to_timestamp('2014-01-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2014-01-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000003, 'D004-1', 'D009-20190000000002', 'D009-5', to_timestamp('2016-02-01', 'yyyy-MM-dd'), 300, null, to_timestamp('2016-02-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-02-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000004, 'D004-1', 'D009-20190000000002', 'D009-4', to_timestamp('2016-02-01', 'yyyy-MM-dd'), 300, null, to_timestamp('2016-02-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-02-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000005, 'D004-1', 'D009-20190000000002', 'D009-3', to_timestamp('2015-01-01', 'yyyy-MM-dd'), 666, '日期已忘记', to_timestamp('2015-01-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2015-01-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000006, 'D004-1', 'D009-20190000000002', 'D009-6', to_timestamp('2016-10-01', 'yyyy-MM-dd'), 600, null, to_timestamp('2016-10-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2016-10-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000007, 'D004-1', 'D009-20190000000002', 'D009-7', to_timestamp('2017-10-01', 'yyyy-MM-dd'), 1000, null, to_timestamp('2017-10-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2017-10-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000008, 'D004-2', 'D009-20190000000002', 'D009-7', to_timestamp('2018-10-01', 'yyyy-MM-dd'), 300, '日期已忘记', to_timestamp('2018-10-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-10-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000009, 'D004-1', 'D009-20190000000002', 'D009-9', to_timestamp('2018-01-02', 'yyyy-MM-dd'), 600, null, to_timestamp('2018-01-02 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-01-02 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000010, 'D004-1', 'D009-20190000000002', 'D009-8', to_timestamp('2018-01-02', 'yyyy-MM-dd'), 500, null, to_timestamp('2018-01-02 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-01-02 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000011, 'D004-1', 'D009-20190000000002', 'D009-10', to_timestamp('2018-11-10', 'yyyy-MM-dd'), 400, '日期已忘记', to_timestamp('2018-11-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-11-10 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000012, 'D004-1', 'D009-20190000000002', 'D009-11', to_timestamp('2019-10-01', 'yyyy-MM-dd'), 600, null, to_timestamp('2019-10-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-10-01 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000013, 'D004-2', 'D009-12', 'D009-20190000000002', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000014, 'D004-2', 'D009-7', 'D009-20190000000002', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 300, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000015, 'D004-2', 'D009-13', 'D009-20190000000003', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 300, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000003', '20190000000003');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000016, 'D004-2', 'D009-14', 'D009-20190000000002', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000017, 'D004-2', 'D009-15', 'D009-20190000000002', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000018, 'D004-2', 'D009-16', 'D009-20190000000002', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000019, 'D004-2', 'D009-17', 'D009-20190000000002', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000020, 'D004-2', 'D009-18', 'D009-20190000000002', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000021, 'D004-2', 'D009-19', 'D009-20190000000002', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000022, 'D004-2', 'D009-20', 'D009-20190000000002', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000023, 'D004-2', 'D009-21', 'D009-20190000000002', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000024, 'D004-2', 'D009-22', 'D009-20190000000002', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 600, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000025, 'D004-2', 'D009-23', 'D009-20190000000002', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 400, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000026, 'D004-2', 'D009-24', 'D009-20190000000002', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000027, 'D004-2', 'D009-25', 'D009-20190000000002', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000028, 'D004-2', 'D009-26', 'D009-20190000000002', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000029, 'D004-2', 'D009-27', 'D009-20190000000002', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000030, 'D004-2', 'D009-28', 'D009-20190000000003', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 600, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000003', '20190000000003');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000031, 'D004-2', 'D009-29', 'D009-20190000000003', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 800, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000003', '20190000000003');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000032, 'D004-2', 'D009-30', 'D009-20190000000003', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 400, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000003', '20190000000003');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000033, 'D004-2', 'D009-31', 'D009-20190000000003', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 400, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000003', '20190000000003');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000034, 'D004-2', 'D009-32', 'D009-20190000000003', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 1600, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000003', '20190000000003');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000035, 'D004-2', 'D009-33', 'D009-20190000000003', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000003', '20190000000003');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000036, 'D004-2', 'D009-34', 'D009-20190000000003', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000003', '20190000000003');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000037, 'D004-2', 'D009-35', 'D009-20190000000003', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000003', '20190000000003');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000038, 'D004-2', 'D009-36', 'D009-20190000000003', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000003', '20190000000003');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000039, 'D004-2', 'D009-37', 'D009-20190000000003', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000003', '20190000000003');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000040, 'D004-2', 'D009-38', 'D009-20190000000003', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000003', '20190000000003');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000041, 'D004-2', 'D009-39', 'D009-20190000000003', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 300, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000003', '20190000000003');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000042, 'D004-2', 'D009-40', 'D009-20190000000003', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000003', '20190000000003');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000043, 'D004-2', 'D009-41', 'D009-20190000000003', to_timestamp('2020-01-19', 'yyyy-MM-dd'), 200, null, to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-01-19 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000003', '20190000000003');

commit;
-- sys_interface
truncate table sys_interface;
commit;

commit;
-- sys_config
truncate table sys_config;
commit;

insert into sys_config (module_group_code, module_group_name, module_code, module_name, module_status, module_ext)
values ('console', '首页信息', 'login', '登录信息', '1', null);

insert into sys_config (module_group_code, module_group_name, module_code, module_name, module_status, module_ext)
values ('console', '首页信息', 'tips', '提示信息', '1', null);

insert into sys_config (module_group_code, module_group_name, module_code, module_name, module_status, module_ext)
values ('console', '首页信息', 'user', '用户信息', '1', null);

insert into sys_config (module_group_code, module_group_name, module_code, module_name, module_status, module_ext)
values ('console', '首页信息', 'version', '版本信息', '1', null);

commit;
-- 数据备份 结束