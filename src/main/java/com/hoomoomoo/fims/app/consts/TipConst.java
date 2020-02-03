package com.hoomoomoo.fims.app.consts;

/**
 * @author humm23693
 * @description 内部提示信息常量
 * @package com.hoomoomoo.fims.app.consts
 * @date 2019/08/04
 */

public class TipConst {

    /**
     * 日志输出格式
     */
    public static final String LOG_TIP                                          = "====================== %s %s ======================";
    /**
     * 日志输出格式
     */
    public static final String LOG_FORMAT_TIP                                   = "%s %s %s %s";

    /**
     * 日志输出格式
     */
    public static final String LOG_FORMAT_STATUS                                = "%s %s";

    /**
     * 异常日志输出格式
     */
    public static final String LOG_FORMAT_ERROR_STATUS                          = "%s %s [%s]";

    /**
     * 日志输出格式
     */
    public static final String LOG_FORMAT_STATUS_MSG                            = "%s %s：{}";

    /**
     * 日志层级：控制层
     */
    public static final String LOG_TYPE_CONTROLLER                              = "控制层";

    /**
     * 日志层级：服务层
     */
    public static final String LOG_TYPE_SERVICE                                 = "服务层";

    /**
     * 日志状态：开始
     */
    public static final String LOG_OPERATE_TAG_START                            = "开始";

    /**
     * 日志状态：结束
     */
    public static final String LOG_OPERATE_TAG_END                              = "结束";

    /**
     * 日志状态：异常
     */
    public static final String LOG_OPERATE_TAG_EXCEPTION                        = "异常";

    /**
     * 日志状态：加载
     */
    public static final String LOG_OPERATE_TAG_LOAD                             = "加载";

    /**
     * 日志状态：成功
     */
    public static final String LOG_OPERATE_TAG_SUCCESS                          = "成功";

    /**
     * 日志状态：成功
     */
    public static final String LOG_OPERATE_TAG_FAIL                             = "失败";


    /**
     * 日志操作类型：查询
     */
    public static final String LOG_OPERATE_TYPE_SELECT                          = "查询";

    /**
     * 日志操作类型：分页查询
     */
    public static final String LOG_OPERATE_TYPE_SELECT_PAGE                     = "分页查询";

    /**
     * 日志操作类型：页面渲染参数查询
     */
    public static final String LOG_OPERATE_TYPE_SELECT_INIT                     = "页面渲染参数查询";

    /**
     * 日志操作类型：重置用户密码
     */
    public static final String LOG_OPERATE_TYPE_RESET_PASSWORD                  = "重置用户密码";

    /**
     * 日志操作类型：修改用户密码
     */
    public static final String LOG_OPERATE_TYPE_UPDATE_PASSWORD                 = "修改用户密码";

    /**
     * 日志操作类型：新增
     */
    public static final String LOG_OPERATE_TYPE_ADD                             = "新增";

    /**
     * 日志操作类型：修改
     */
    public static final String LOG_OPERATE_TYPE_UPDATE                          = "修改";

    /**
     * 日志操作类型：校验
     */
    public static final String LOG_OPERATE_TYPE_CHECK                           = "校验";

    /**
     * 日志操作类型：删除
     */
    public static final String LOG_OPERATE_TYPE_DELETE                          = "删除";

    /**
     * 日志操作类型：刷新
     */
    public static final String LOG_OPERATE_TYPE_REFRESH                         = "刷新";


    /**
     * 日志业务类型：应用启动
     */
    public static final String LOG_BUSINESS_TYPE_APP_START                      = "应用启动";

    /**
     * 日志业务类型：参数配置
     */
    public static final String LOG_BUSINESS_TYPE_PARAMETER_CONFIG               = "参数配置";

    /**
     * 日志业务类型：数据初始化
     */
    public static final String LOG_BUSINESS_TYPE_INIT                           = "应用数据";

    /**
     * 日志业务类型：登录过滤器
     */
    public static final String LOG_BUSINESS_TYPE_LOGIN_FILTER                   = "登录过滤器配置";

    /**
     * 日志业务类型：freemarker模板配置
     */
    public static final String LOG_BUSINESS_TYPE_FREEMARKER                     = "freemarker模板配置";

    /**
     * 日志业务类型：freemarker模板配置
     */
    public static final String LOG_BUSINESS_TYPE_SCHEDULE                       = "定时任务配置";

    /**
     * 日志业务类型：session配置
     */
    public static final String LOG_BUSINESS_TYPE_SESSION                        = "session配置";

    /**
     * 日志业务类型：swagger配置
     */
    public static final String LOG_BUSINESS_TYPE_SWAGGER                        = "swagger配置";

    /**
     * 日志业务类型：Interceptor配置
     */
    public static final String LOG_BUSINESS_TYPE_INTERCEPTOR                    = "拦截器配置器配置";

    /**
     * 日志业务类型：FimsInterceptor配置
     */
    public static final String LOG_BUSINESS_TYPE_FIMS_INTERCEPTOR               = "系统拦截器配置";

    /**
     * 日志业务类型：websocket配置
     */
    public static final String LOG_BUSINESS_TYPE_WEBSOCKET                      = "websocket配置";

    /**
     * 日志业务类型：全局异常配置
     */
    public static final String LOG_BUSINESS_TYPE_EXCEPTION                      = "全局异常配置";

    /**
     * 日志业务类型：邮件发送
     */
    public static final String LOG_BUSINESS_TYPE_MAIL_SEND                      = "邮件发送";

    /**
     * 日志业务类型：邮件读取
     */
    public static final String LOG_BUSINESS_TYPE_MAIL_RECEIVE                   = "邮件读取";

    /**
     * 日志业务类型：邮件数据处理
     */
    public static final String LOG_BUSINESS_TYPE_MAIL_HANDLE                    = "邮件数据处理";

    /**
     * 日志业务类型：收入
     */
    public static final String LOG_BUSINESS_TYPE_INCOME                         = "收入信息";

    /**
     * 日志业务类型：字典
     */
    public static final String LOG_BUSINESS_TYPE_DICTIONARY                     = "字典信息";

    /**
     * 日志业务类型：用户
     */
    public static final String LOG_BUSINESS_TYPE_USER                           = "用户信息";

    /**
     * 日志业务类型：角色
     */
    public static final String LOG_BUSINESS_TYPE_ROLE                           = "角色信息";

    /**
     * 日志业务类型：通知
     */
    public static final String LOG_BUSINESS_TYPE_NOTICE                         = "通知信息";

    /**
     * 日志业务类型：菜单
     */
    public static final String LOG_BUSINESS_TYPE_MENU                           = "菜单信息";

    /**
     * 日志业务类型：数据权限
     */
    public static final String LOG_BUSINESS_TYPE_DATA_AUTHORITY                 = "数据权限信息";

    /**
     * 日志业务类型：报表
     */
    public static final String LOG_BUSINESS_TYPE_REPORT                         = "报表信息";

    /**
     * 日志业务类型：登入日志信息
     */
    public static final String LOG_BUSINESS_TYPE_LOGIN_LOG                      = "登入日志信息";

    /**
     * 日志业务类型：数据库备份
     */
    public static final String LOG_BUSINESS_TYPE_BACKUP                         = "数据备份";

    /**
     * 日志业务类型：数据库备份
     */
    public static final String LOG_BUSINESS_TYPE_BACKUP_SQL                     = "SQL数据备份";

    /**
     * 日志业务类型：数据库备份
     */
    public static final String LOG_BUSINESS_TYPE_BACKUP_DMP                     = "DMP数据备份";

    /**
     * 日志业务类型：修订
     */
    public static final String LOG_BUSINESS_TYPE_VERSION                        = "修订信息";

    /**
     * 日志业务类型：参数
     */
    public static final String LOG_BUSINESS_TYPE_PARAMETER                      = "参数信息";

    /**
     * 日志业务类型：邮件
     */
    public static final String LOG_BUSINESS_TYPE_MAIL                           = "邮件信息";

    /**
     * 日志业务类型：随礼
     */
    public static final String LOG_BUSINESS_TYPE_GIFT                           = "随礼信息";

    /**
     * 日志业务类型：首页
     */
    public static final String LOG_BUSINESS_TYPE_CONSOLE                        = "首页信息";

    /**
     * 日志业务类型：大额支出
     */
    public static final String LOG_BUSINESS_TYPE_PAY                            = "大额支出信息";

    /**
     * 日志业务类型：字典转义
     */
    public static final String LOG_BUSINESS_TYPE_DICTIONARY_TRANSFER            = "字典转义";

    /**
     * 日志业务类型：业务序列号
     */
    public static final String LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_GET         = "获取业务序列号";

    /**
     * 日志业务类型：业务序列号
     */
    public static final String LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_LOAD        = "加载业务序列号";

    /**
     * 日志业务类型：字典信息
     */
    public static final String LOG_BUSINESS_TYPE_DICTIONARY_LOAD                = "加载字典信息";

    /**
     * 日志业务类型：用户ID
     */
    public static final String LOG_BUSINESS_TYPE_USER_ID_SELECT                 = "获取用户ID";

    /**
     * 日志业务类型：查询条件
     */
    public static final String LOG_BUSINESS_TYPE_CONDITION_SET                  = "设置查询条件";

    /**
     * 日志业务类型：按钮权限
     */
    public static final String LOG_BUSINESS_TYPE_BUTTON_AUTHORITY_SELECT        = "查询按钮权限";

    /**
     * 日志业务类型：系统初始化
     */
    public static final String LOG_BUSINESS_TYPE_INIT_SYSTEM                    = "系统初始化";

    /**
     * 请求入参
     */
    public static final String LOG_BUSINESS_PARAMETER                           = "服务请求入参：{}";

    /**
     * 邮件超文本内容暂不读取
     */
    public static final String MAIL_CONTENT_HTML                                = "邮件超文本数据暂不读取";

    /**
     * 邮件超文本内容暂不读取
     */
    public static final String MAIL_CONTENT_MULTIPART                           = "邮件附件数据暂不处理";

    /**
     * 不支持的内容格式
     */
    public static final String MAIL_CONTENT_NOT_SUPPORT                         = "不支持的内容格式";

    /**
     * 业务类型不能为空
     */
    public static final String BUSINESS_TYPE_NOT_EMPTY                          = "业务类型不能为空";

    /**
     * Swagger标题
     */
    public static final String SWAGGER_TITLE                                    = "fims";

    /**
     * Swagger描述
     */
    public static final String SWAGGER_DESCRIPTION                              = "...";

    /**
     * Swagger版本
     */
    public static final String SWAGGER_VERSION                                  = "3.0";

    /**
     * sql id已存在
     */
    public static final String TIP_SQL_ID_EXIST                                 = "sql [%s] 已存在";

    /**
     * sql id不存在
     */
    public static final String TIP_SQL_ID                                       = "sql id 不能为空";

    /**
     * sql mode不存在
     */
    public static final String TIP_SQL_MODE                                     = "sql [%s] mode 不能为空";

    /**
     * sql value不存在
     */
    public static final String TIP_SQL_VALUE                                    = "sql [%s] value 不能为空";

    /**
     * 备份命令
     */
    public static final String TIP_BACKUP_COMMAND                               = "执行备份命令: ";

}
