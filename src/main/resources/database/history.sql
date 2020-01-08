delete from sys_dictionary where dictionary_code = 'D009' and dictionary_item != '#';
insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '1', '周大林', 1, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '2', '易明', 2, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '3', '韩声海', 3, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '4', '刘诱', 4, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '5', '敖丽平', 5, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '6', '郭锦', 6, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '7', '朱凌钦', 7, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '8', '孙俪', 8, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '9', '黄霄', 9, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '10', '肖海刚', 10, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D009', '11', '胡永兵', 11, null, 20190000000002, null, null);
commit;

delete from sys_dictionary t where t.dictionary_code = 'D003' and t.dictionary_item in ('3', '4', '5');
insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D003', '3', '公积金', 3, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D003', '4', '奖金', 4, null, 20190000000002, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D003', '5', '出差补贴', 5, null, 20190000000002, null, null);
commit;

delete from sys_dictionary t where t.dictionary_code = 'D005' and t.dictionary_item != '#';
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
commit;

/* sys_gift */
truncate table sys_gift;
commit;

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000001, 'D004-1', '20190000000002', 'D009-2', to_timestamp('2014-01-01', 'yyyy-MM-dd'), 666, '日期已忘记', to_timestamp('2019-01-11 23:04:43', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 23:04:43', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000002, 'D004-1', '20190000000002', 'D009-1', to_timestamp('2014-01-01', 'yyyy-MM-dd'), 666, '日期已忘记', to_timestamp('2019-01-11 23:05:06', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 23:05:06', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000003, 'D004-1', '20190000000002', 'D009-5', to_timestamp('2016-02-01', 'yyyy-MM-dd'), 300, null, to_timestamp('2019-01-11 23:06:13', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 23:06:13', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000004, 'D004-1', '20190000000002', 'D009-4', to_timestamp('2016-02-01', 'yyyy-MM-dd'), 300, null, to_timestamp('2019-01-11 23:06:39', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 23:06:39', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000005, 'D004-1', '20190000000002', 'D009-3', to_timestamp('2015-01-01', 'yyyy-MM-dd'), 666, '日期已忘记', to_timestamp('2019-01-11 23:07:06', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 23:07:06', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000006, 'D004-1', '20190000000002', 'D009-6', to_timestamp('2016-10-01', 'yyyy-MM-dd'), 600, null, to_timestamp('2019-01-11 23:08:03', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 23:08:03', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000007, 'D004-1', '20190000000002', 'D009-7', to_timestamp('2017-10-01', 'yyyy-MM-dd'), 1000, null, to_timestamp('2019-01-11 23:08:42', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 23:08:42', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000008, 'D004-2', '20190000000002', 'D009-7', to_timestamp('2018-10-01', 'yyyy-MM-dd'), 300, '日期已忘记', to_timestamp('2019-01-11 23:09:21', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 23:09:21', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000009, 'D004-1', '20190000000002', 'D009-9', to_timestamp('2018-01-02', 'yyyy-MM-dd'), 600, null, to_timestamp('2019-01-11 23:10:15', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 23:10:15', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000010, 'D004-1', '20190000000002', 'D009-8', to_timestamp('2018-01-02', 'yyyy-MM-dd'), 500, null, to_timestamp('2019-01-11 23:10:48', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 23:10:48', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000011, 'D004-1', '20190000000002', 'D009-10', to_timestamp('2018-11-10', 'yyyy-MM-dd'), 400, '日期已忘记', to_timestamp('2019-01-11 23:13:08', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-05-08 19:25:55', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_gift (gift_id, gift_type, gift_sender, gift_receiver, gift_date, gift_amount, gift_memo, create_date, modify_date, create_user, modify_user)
values (20190000000012, 'D004-1', '20190000000002', 'D009-11', to_timestamp('2019-10-01', 'yyyy-MM-dd'), 600, '', to_timestamp('2019-10-01 23:13:08', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-10-01 19:25:55', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

commit;

/* sys_income */
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
values (20190000000037, 20190000000002, 'D003-4', to_timestamp('2013-06-20', 'yyyy-MM-dd'), 'D005-2', 1474, '失业保险金', to_timestamp('2013-06-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-06-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000038, 20190000000002, 'D003-1', to_timestamp('2013-06-20', 'yyyy-MM-dd'), 'D005-3', 322, null, to_timestamp('2013-06-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-06-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000039, 20190000000002, 'D003-1', to_timestamp('2013-07-20', 'yyyy-MM-dd'), 'D005-3', 2043, null, to_timestamp('2013-07-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-07-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000040, 20190000000002, 'D003-3', to_timestamp('2013-07-20', 'yyyy-MM-dd'), 'D005-2', 5688, null, to_timestamp('2013-07-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2013-07-20 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

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
values (20190000000112, 20190000000002, 'D003-1', to_timestamp('2018-04-26', 'yyyy-MM-dd'), 'D005-7', 11209, null, to_timestamp('2019-01-11 22:56:44', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 22:57:01', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000113, 20190000000002, 'D003-1', to_timestamp('2018-05-26', 'yyyy-MM-dd'), 'D005-7', 11384, null, to_timestamp('2019-01-11 22:57:51', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 22:57:51', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000114, 20190000000002, 'D003-1', to_timestamp('2018-06-26', 'yyyy-MM-dd'), 'D005-7', 10645, null, to_timestamp('2019-01-11 22:58:30', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 22:58:30', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000115, 20190000000002, 'D003-1', to_timestamp('2018-07-26', 'yyyy-MM-dd'), 'D005-7', 10493, null, to_timestamp('2019-01-11 22:58:55', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 22:58:55', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000116, 20190000000002, 'D003-1', to_timestamp('2018-08-26', 'yyyy-MM-dd'), 'D005-7', 11634, null, to_timestamp('2019-01-11 22:59:23', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 22:59:23', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000117, 20190000000002, 'D003-1', to_timestamp('2018-09-26', 'yyyy-MM-dd'), 'D005-7', 11642, null, to_timestamp('2019-01-11 22:59:48', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 22:59:48', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000118, 20190000000002, 'D003-1', to_timestamp('2018-10-26', 'yyyy-MM-dd'), 'D005-7', 12221, null, to_timestamp('2019-01-11 23:00:10', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 23:00:10', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000119, 20190000000002, 'D003-1', to_timestamp('2018-11-26', 'yyyy-MM-dd'), 'D005-7', 12068, null, to_timestamp('2019-01-11 23:00:34', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 23:00:34', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000120, 20190000000002, 'D003-1', to_timestamp('2018-12-26', 'yyyy-MM-dd'), 'D005-7', 12082, null, to_timestamp('2019-01-11 23:01:02', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-01-11 23:01:02', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000121, 20190000000002, 'D003-1', to_timestamp('2019-01-25', 'yyyy-MM-dd'), 'D005-7', 12913, null, to_timestamp('2019-01-25 19:33:27', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-02-13 00:04:18', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000122, 20190000000002, 'D003-2', to_timestamp('2019-01-31', 'yyyy-MM-dd'), 'D005-7', 19400, null, to_timestamp('2019-02-12 23:57:33', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-02-13 00:04:28', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000123, 20190000000002, 'D003-1', to_timestamp('2019-02-26', 'yyyy-MM-dd'), 'D005-7', 12536.43, null, to_timestamp('2019-02-27 22:34:12', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-02-27 22:34:51', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000124, 20190000000002, 'D003-1', to_timestamp('2019-03-26', 'yyyy-MM-dd'), 'D005-7', 12283.26, null, to_timestamp('2019-03-26 22:03:54', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-03-26 22:03:54', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000125, 20190000000002, 'D003-1', to_timestamp('2019-04-26', 'yyyy-MM-dd'), 'D005-7', 16294.21, '补发1月至3月3000', to_timestamp('2019-04-26 19:32:57', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-05-08 19:29:17', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000126, 20190000000002, 'D003-1', to_timestamp('2019-05-26', 'yyyy-MM-dd'), 'D005-7', 13442.41, '', to_timestamp('2019-05-26 19:32:57', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-05-26 19:29:17', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000127, 20190000000002, 'D003-1', to_timestamp('2019-06-26', 'yyyy-MM-dd'), 'D005-7', 12692.73, '', to_timestamp('2019-06-26 19:32:57', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-06-26 19:29:17', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000128, 20190000000002, 'D003-1', to_timestamp('2019-07-26', 'yyyy-MM-dd'), 'D005-7', 12615.14, '', to_timestamp('2019-07-26 19:32:57', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-07-26 19:29:17', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000129, 20190000000002, 'D003-1', to_timestamp('2019-08-26', 'yyyy-MM-dd'), 'D005-7', 12926.70, '', to_timestamp('2019-08-26 19:32:57', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-08-26 19:29:17', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000130, 20190000000002, 'D003-1', to_timestamp('2019-09-26', 'yyyy-MM-dd'), 'D005-7', 15689.70, '补发7月至8月2100', to_timestamp('2019-09-26 19:32:57', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-09-26 19:29:17', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000131, 20190000000002, 'D003-1', to_timestamp('2019-10-26', 'yyyy-MM-dd'), 'D005-7', 13745.70, '', to_timestamp('2019-10-26 19:32:57', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-10-26 19:29:17', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000132, 20190000000002, 'D003-1', to_timestamp('2019-11-26', 'yyyy-MM-dd'), 'D005-7', 13606.20, '', to_timestamp('2019-11-26 19:32:57', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-11-26 19:29:17', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000133, 20190000000002, 'D003-1', to_timestamp('2019-12-26', 'yyyy-MM-dd'), 'D005-7', 13606.20, '', to_timestamp('2019-12-26 19:32:57', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-12-26 19:29:17', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000134, 20190000000002, 'D003-3', to_timestamp('2018-04-23', 'yyyy-MM-dd'), 'D005-6', 11000, null, to_timestamp('2018-04-23 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2018-04-23 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

insert into sys_income (income_id, user_id, income_type, income_date, income_company, income_amount, income_memo, create_date, modify_date, create_user, modify_user)
values (20190000000135, 20190000000002, 'D003-3', to_timestamp('2019-05-28', 'yyyy-MM-dd'), 'D005-7', 12000, null, to_timestamp('2019-05-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2019-05-28 00:00:00', 'yyyy-MM-dd hh24:mi:ss'), '20190000000002', '20190000000002');

commit;

insert into sys_user (USER_ID, USER_CODE, USER_NAME, USER_PASSWORD, USER_STATUS, CREATE_DATE, MODIFY_DATE, CREATE_USER, MODIFY_USER, USER_MEMO)
values (20190000000002, 'mao', '二毛', '2UDNzITM', 'D001-1', sysdate, sysdate, '20190000000001', '20190000000001', null);
