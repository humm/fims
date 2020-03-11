-- 升级脚本
-- 发布版本修改点: sys_version新增记录  pom.xml修改版本  常量SYSTEM_VERSION修改
-- 修订信息
-- 1：功能 2：优化 3：修复 4：发版

-- 修复 日期控件缺陷
call add_version('20190000000063', '日期控件加载不出来(一闪而过)', '2020-02-23', 310, '3');

-- 删除 系统参数文件上传路径
delete from sys_parameter where parameter_code = 'uploadLocation';

-- 功能 自动化升级 Excel备份 优化随礼信息查询条件 发布新版本
call add_version('20190000000064', '随礼信息：送礼人、收礼人修改为模糊查询', '2020-02-23', 315, '2');
call add_version('20190000000065', '自动化系统升级', '2020-02-24', 320, '1');
call add_version('20190000000066', 'Excel备份', '2020-02-25', 325, '1');
call add_version('20190000000067', '发布版本：3.1.10', '2020-02-25', 326, '4');

call update_system_version('3.1.10');

-- 修复 邮件信息重复提醒
call add_version('20190000000068', '邮件信息：业务日期格式错误重复提醒', '2020-02-26', 330, '3');

-- 修改 系统参数描述
update sys_parameter set parameter_caption = '年度开始日期' where parameter_code = 'yearStartDate';

-- 修改 字典项D010
update sys_dictionary set dictionary_item = '2', item_order = '2' where dictionary_code = 'D010' and dictionary_item = '0';

-- 优化 新增备份模式参数
call add_parameter('backupMode', '系统备份模式', 'sql', 'checkbox', 'sql,dmp,xlsx', '1', '1', 36);
call add_version('20190000000069', '系统备份：新增备份模式参数', '2020-02-26', 335, '2');
call add_version('20190000000070', '发布版本：3.1.21', '2020-02-26', 340, '4');

call update_system_version('3.1.21');

delete from sys_dictionary where dictionary_code = 'D013';
insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D013', '#', '是否标识', null, 13, 20190000000001, '0', '1');

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D013', '1', '是', 1, null, 20190000000001, null, null);

insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D013', '0', '否', 2, null, 20190000000001, null, null);

-- 功能 微信公众号集成
call add_parameter('weChatWelcome', '微信公众号欢迎语', '智慧家庭,畅享生活', 'text', null, '1', '1', 70);
call add_parameter('weChatKey', '微信公众号密钥', 'fimswechat', 'text', null, '1', '1', 75);
call add_parameter('weChatOpen', '微信公众号对外开放状态', '2', 'switch', null, '1', '1', 80);
call add_parameter('weChatOperateTime', '微信操作时间间隔(秒)', '30', 'number', null, '1', '1', 85);
call add_parameter('weChatOperateBack', '微信操作后返回主菜单', '1', 'switch', null, '1', '1', 90);

delete from sys_dictionary where dictionary_code = 'D008' and dictionary_item = '3';
insert into sys_dictionary (dictionary_code, dictionary_item, dictionary_caption, item_order, code_order, user_id, is_open, is_show)
values ('D008', '3', '微信', 3, null, 20190000000001, null, null);

-- 微信用户信息
call create_table('sys_wechat_user', 'create table sys_wechat_user
(
    wechat_user_id       varchar2(100) primary key,
    wechat_public_id     varchar2(100) not null,
    is_auth             varchar2(50) default ''0'',
    user_id              number(30),
    create_date          timestamp(6) default sysdate,
    modify_date          timestamp(6) default sysdate,
    create_user          varchar2(50),
    modify_user          varchar2(50)
)');

comment on column sys_wechat_user.wechat_user_id
    is '微信用户ID';
comment on column sys_wechat_user.wechat_public_id
    is '微信公众号ID';
comment on column sys_wechat_user.is_auth
    is '是否身份验证';
comment on column sys_wechat_user.user_id
    is '用户ID';
comment on column sys_wechat_user.create_date
    is '创建时间';
comment on column sys_wechat_user.modify_date
    is '修改时间';
comment on column sys_wechat_user.create_user
    is '创建人';
comment on column sys_wechat_user.modify_user
    is '修改人';


-- 微信操作流程步骤
call create_table('sys_wechat_flow', 'create table sys_wechat_flow
(
    flow_id              number(30) primary key,
    flow_num             varchar2(50),
    flow_code            varchar2(50),
    flow_describe        varchar2(500),
    flow_tips            varchar2(500),
    flow_type            varchar2(50),
    flow_order           number(10),
    is_show              varchar2(50),
    create_date          timestamp(6) default sysdate,
    modify_date          timestamp(6) default sysdate,
    create_user          varchar2(50),
    modify_user          varchar2(50)
)');
comment on column sys_wechat_flow.flow_id
    is '流程步骤ID';
comment on column sys_wechat_flow.flow_num
    is '流程步骤序号';
comment on column sys_wechat_flow.flow_code
    is '流程步骤代码';
comment on column sys_wechat_flow.flow_describe
    is '流程步骤描述';
comment on column sys_wechat_flow.flow_tips
    is '流程步骤提示信息';
comment on column sys_wechat_flow.flow_order
    is '流程步骤排序';
comment on column sys_wechat_flow.is_show
    is '流程步骤是否显示';
comment on column sys_wechat_flow.flow_type
    is '流程步骤类型';
comment on column sys_wechat_flow.create_date
    is '创建时间';
comment on column sys_wechat_flow.modify_date
    is '修改时间';
comment on column sys_wechat_flow.create_user
    is '创建人';
comment on column sys_wechat_flow.modify_user
    is '修改人';

delete from sys_wechat_flow where flow_id <= 20200000000017;
insert into sys_wechat_flow (flow_id, flow_num, flow_code, flow_describe, flow_tips, flow_type, flow_order, create_date, modify_date, create_user, modify_user, is_show)
values (20200000000001, '1', 'income-month', '收入查询 - 月度', null, '1', 1, to_timestamp('2020-02-29 16:11:46', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-29 16:11:46', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001', 'D013-1');

insert into sys_wechat_flow (flow_id, flow_num, flow_code, flow_describe, flow_tips, flow_type, flow_order, create_date, modify_date, create_user, modify_user, is_show)
values (20200000000002, '2', 'income-year', '收入查询 - 年度', null, '1', 2, to_timestamp('2020-02-29 16:13:19', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-29 16:13:19', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001', 'D013-1');

insert into sys_wechat_flow (flow_id, flow_num, flow_code, flow_describe, flow_tips, flow_type, flow_order, create_date, modify_date, create_user, modify_user, is_show)
values (20200000000003, '3', 'income-year-current', '收入查询 - 本年度', null, '1', 3, to_timestamp('2020-02-29 16:13:20', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-29 16:13:20', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001', 'D013-1');

insert into sys_wechat_flow (flow_id, flow_num, flow_code, flow_describe, flow_tips, flow_type, flow_order, create_date, modify_date, create_user, modify_user, is_show)
values (20200000000004, '4', 'income-all', '收入查询 - 总收入', null, '1', 4, to_timestamp('2020-02-29 16:13:20', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-29 16:13:20', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001', 'D013-1');

insert into sys_wechat_flow (flow_id, flow_num, flow_code, flow_describe, flow_tips, flow_type, flow_order, create_date, modify_date, create_user, modify_user, is_show)
values (20200000000005, '5', 'income-add', '收入新增', '请按如下格式输入收入信息

收入用户: 中文名称
收入来源: 中文名称
收入日期: yyyyMMdd
收入类型: 中文名称
收入金额: 支持两位小数
收入备注: 最大150字符', '1', 5, to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-29 ' || '16:21:18', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001', 'D013-1');

insert into sys_wechat_flow (flow_id, flow_num, flow_code, flow_describe, flow_tips, flow_type, flow_order, create_date, modify_date, create_user, modify_user, is_show)
values (20200000000006, '6', 'income-delete', '收入删除', '请输入业务流水号', '1', 6, to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001', 'D013-1');

insert into sys_wechat_flow (flow_id, flow_num, flow_code, flow_describe, flow_tips, flow_type, flow_order, create_date, modify_date, create_user, modify_user, is_show)
values (20200000000008, '7', 'more', '更多服务', null, '1', 7, to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001', 'D013-1');

insert into sys_wechat_flow (flow_id, flow_num, flow_code, flow_describe, flow_tips, flow_type, flow_order, create_date, modify_date, create_user, modify_user, is_show)
values (20200000000009, '8', 'gift-free', '随礼查询 - 自由查询', '请输入送礼人或收礼人名称', '2', 8, to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001', 'D013-1');

insert into sys_wechat_flow (flow_id, flow_num, flow_code, flow_describe, flow_tips, flow_type, flow_order, create_date, modify_date, create_user, modify_user, is_show)
values (20200000000010, '9', 'gift-last', '随礼查询 - 最近一次', null, '2', 9, to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001', 'D013-1');

insert into sys_wechat_flow (flow_id, flow_num, flow_code, flow_describe, flow_tips, flow_type, flow_order, create_date, modify_date, create_user, modify_user, is_show)
values (20200000000011, '10', 'gift-year', '随礼查询 - 年度', null, '2', 10, to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001', 'D013-1');

insert into sys_wechat_flow (flow_id, flow_num, flow_code, flow_describe, flow_tips, flow_type, flow_order, create_date, modify_date, create_user, modify_user, is_show)
values (20200000000012, '11', 'gift-year-current', '随礼查询 - 本年度', null, '2', 11, to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001', 'D013-1');

insert into sys_wechat_flow (flow_id, flow_num, flow_code, flow_describe, flow_tips, flow_type, flow_order, create_date, modify_date, create_user, modify_user, is_show)
values (20200000000013, '12', 'gift-all', '随礼查询 - 总随礼', null, '2', 12, to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001', 'D013-1');

insert into sys_wechat_flow (flow_id, flow_num, flow_code, flow_describe, flow_tips, flow_type, flow_order, create_date, modify_date, create_user, modify_user, is_show)
values (20200000000014, '13', 'git-add', '随礼新增', '请按如下格式输入随礼信息

送礼用户: 中文名称
收礼用户: 中文名称
随礼日期: yyyyMMdd
随礼类型: 中文名称
随礼金额: 支持两位小数
随礼备注: 最大150字符', '2', 13, to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-29 ' || '16:21:18', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001', 'D013-1');

insert into sys_wechat_flow (flow_id, flow_num, flow_code, flow_describe, flow_tips, flow_type, flow_order, create_date, modify_date, create_user, modify_user, is_show)
values (20200000000016, '14', 'gift-delete', '随礼删除', '请输入业务流水号', '2', 14, to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-29 16:21:18', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001', 'D013-1');

insert into sys_wechat_flow (flow_id, flow_num, flow_code, flow_describe, flow_tips, flow_type, flow_order, create_date, modify_date, create_user, modify_user, is_show)
values (20200000000017, '99', 'main', '返回主菜单', null, '2', 99, to_timestamp('2020-02-29 10:27:32', 'yyyy-MM-dd hh24:mi:ss'), to_timestamp('2020-02-29 10:27:32', 'yyyy-MM-dd hh24:mi:ss'), '20190000000001', '20190000000001', 'D013-1');

call add_version('20190000000071', '微信公众号业务查询', '2020-03-05', 345, '1');
call add_version('20190000000072', '发布版本：3.2.00', '2020-03-06', 350, '4');
call update_system_version('3.2.00');

-- 系统参数表新增分组字段
call add_column('sys_parameter', 'parameter_group', 'varchar2(50)', ''' ''');
update sys_parameter set parameter_group = '微信参数', parameter_order = '80' where parameter_code = 'weChatWelcome';
update sys_parameter set parameter_group = '微信参数', parameter_order = '85' where parameter_code = 'weChatKey';
update sys_parameter set parameter_group = '微信参数', parameter_order = '90' where parameter_code = 'weChatOpen';
update sys_parameter set parameter_group = '微信参数', parameter_order = '95' where parameter_code = 'weChatOperateTime';
update sys_parameter set parameter_group = '微信参数', parameter_order = '100' where parameter_code = 'weChatOperateBack';

update sys_parameter set parameter_group = '提示参数', parameter_order = '50' where parameter_code = 'startConsoleOutput';
update sys_parameter set parameter_group = '提示参数', parameter_order = '55' where parameter_code = 'consoleOutputLogRequestTag';
update sys_parameter set parameter_group = '提示参数', parameter_order = '60' where parameter_code = 'consoleOutputLogRequestParameter';
update sys_parameter set parameter_group = '提示参数', parameter_order = '65' where parameter_code = 'mindFill';
update sys_parameter set parameter_group = '提示参数', parameter_order = '70' where parameter_code = 'messageTip';

update sys_parameter set parameter_group = '系统参数', parameter_order = '10' where parameter_code = 'startBackup';
update sys_parameter set parameter_group = '系统参数', parameter_order = '15' where parameter_code = 'backupMode';
update sys_parameter set parameter_group = '系统参数', parameter_order = '20' where parameter_code = 'backupLocation';
update sys_parameter set parameter_group = '系统参数', parameter_order = '25' where parameter_code = 'startMail';
update sys_parameter set parameter_group = '系统参数', parameter_order = '30' where parameter_code = 'yearStartDate';
update sys_parameter set parameter_group = '系统参数', parameter_order = '35' where parameter_code = 'sessionTimeout';
update sys_parameter set parameter_group = '系统参数', parameter_order = '40' where parameter_code = 'cookieTimeout';
update sys_parameter set parameter_group = '系统参数', parameter_order = '45' where parameter_code = 'userDefaultPassword';
update sys_parameter set parameter_group = '系统参数', parameter_order = '999' where parameter_code = 'version';

call add_version('20190000000073', '系统参数分组显示', '2020-03-10', 355, '2');

delete from sys_config where module_group_code = 'console' and module_code = 'register';
insert into sys_config (MODULE_GROUP_CODE, MODULE_GROUP_NAME, MODULE_CODE, MODULE_NAME, MODULE_STATUS, MODULE_EXT)
values ('console', '首页信息', 'register', '注册信息', '1', null);
call add_version('20190000000074', '首页注册信息模块', '2020-03-11', 360, '1');
call add_version('20190000000075', '微信交互提示', '2020-03-11', 365, '2');

