package com.hoomoomoo.fims.app.consts;

/**
 * @author humm23693
 * @description 业务级别常量
 * @package com.hoomoomoo.fims.app.consts
 * @date 2019/08/03
 */

public class BusinessConst {

    /**
     * 状态码：成功
     */
    public static final String STATUS_SUCCESS                               = "0";

    /**
     * 状态码：失败
     */
    public static final String STATUS_FAIL                                  = "-1";


    /**
     * 字符串：0
     */
    public static final String STR_0                                        = "0";

    /**
     * 字符串：1
     */
    public static final String STR_1                                        = "1";

    /**
     * 字符串：2
     */
    public static final String STR_2                                        = "2";

    /**
     * 空串
     */
    public static final String STR_EMPTY                                    = "";

    /**
     * 空串
     */
    public static final String STR_SPACE                                    = " ";

    /**
     * 点号
     */
    public static final String POINT                                        = ".";

    /**
     * 分号
     */
    public static final String SEMICOLON                                    = ";";

    /**
     * 逗号
     */
    public static final String COMMA                                        = ",";

    /**
     * 冒号
     */
    public static final String COLON                                        = ":";

    /**
     * 减号分隔符
     */
    public static final String MINUS                                        = "-";

    /**
     * 分隔符
     */
    public static final String SLASH                                        = "/";

    /**
     * =
     */
    public static final String EQUAL_SIGN                                   = "=";

    /**
     * underline
     */
    public static final String UNDERLINE                                    = "_";

    /**
     * underline
     */
    public static final String WELL                                         = "#";

    /**
     * 六个*
     */
    public static final String ASTERISK_SIX                                 = "******";

    /**
     * text/plain
     */
    public static final String TEXT_PLAIN                                   = "text/plain";

    /**
     * text/html
     */
    public static final String TEXT_HTML                                    = "text/html";

    /**
     * multipart/*
     */
    public static final String MULTIPART                                    = "multipart/*";

    /**
     * 业务ID初始值
     */
    public static final String BUSINESS_ID_DEFAULT                          = "0000000001";

    /**
     * 数据权限ID
     */
    public static final String DATA_AUTHORITY_ID                            = "20190000000000";

    /**
     * 转义key
     */
    public static final String TRANSFER_KEY                                 = "userId";

    /**
     * 是否有按钮权限
     */
    public static final String HAS_BUTTON                                   = "hasButton";

    /**
     * 业务类型：sessionBean
     */
    public static final String SESSION_BEAN                                 = "sessionBean";

    /**
     * 业务类型：用户
     */
    public static final String BUSINESS_TYPE_USER                           = "user";

    /**
     * 业务类型：角色
     */
    public static final String BUSINESS_TYPE_ROLE                           = "role";

    /**
     * 业务类型：用户角色
     */
    public static final String BUSINESS_TYPE_USER_ROLE                      = "userRole";

    /**
     * 业务类型：角色菜单
     */
    public static final String BUSINESS_TYPE_ROLE_MENU                      = "roleMenu";

    /**
     * 业务类型：收入
     */
    public static final String BUSINESS_TYPE_INCOME                         = "income";

    /**
     * 业务类型：通知
     */
    public static final String BUSINESS_TYPE_NOTICE                         = "notice";

    /**
     * 业务类型：菜单
     */
    public static final String BUSINESS_TYPE_MENU                           = "menu";

    /**
     * 业务类型：字典
     */
    public static final String BUSINESS_TYPE_DICTIONARY                     = "dictionary";

    /**
     * 业务类型：登录日志
     */
    public static final String BUSINESS_TYPE_LOGIN_LOG                     = "loginLog";

    /**
     * 业务类型：系统参数
     */
    public static final String BUSINESS_TYPE_PARAMETER                     = "parameter";

    /**
     * 业务类型：数据库备份恢复
     */
    public static final String BUSINESS_TYPE_DATABASE                      = "database";

    /**
     * 业务类型：修订
     */
    public static final String BUSINESS_TYPE_VERSION                       = "version";

    /**
     * 业务类型：邮件
     */
    public static final String BUSINESS_TYPE_MAIL                          = "mail";

    /**
     * 业务类型：随礼
     */
    public static final String BUSINESS_TYPE_GIFT                          = "gift";

    /**
     * 业务类型：大额支出
     */
    public static final String BUSINESS_TYPE_PAY                           = "pay";

    /**
     * 字典项空白
     */
    public static final String BLANK                                       = "blank";

    /**
     * 请选择
     */
    public static final String SELECT                                      = "请选择";

    /**
     * shutdown
     */
    public static final String SHUTDOWN                                    = "shutdown";

    /**
     * 查询条件：用户ID
     */
    public static final String SELECT_USER_ID                              = "userId";

    /**
     * 查询条件：收入来源
     */
    public static final String SELECT_INCOME_COMPANY                       = "incomeCompany";

    /**
     * 查询条件：收入类型
     */
    public static final String SELECT_INCOME_TYPE                          = "incomeType";

    /**
     * 查询条件：随礼类型
     */
    public static final String SELECT_GIFT_TYPE                            = "giftType";

    /**
     * 查询条件：送礼人
     */
    public static final String SELECT_GIFT_SENDER                          = "giftSender";

    /**
     * 查询条件：收礼人
     */
    public static final String SELECT_GIFT_RECEIVER                        = "giftReceiver";

    /**
     * 查询条件：用户状态
     */
    public static final String SELECT_USER_STATUS                          = "userStatus";

    /**
     * 查询条件：登入状态
     */
    public static final String SELECT_LOGIN_STATUS                         = "loginStatus";

    /**
     * 查询条件：通知类型
     */
    public static final String SELECT_NOTICE_TYPE                          = "noticeType";

    /**
     * 查询条件：通知状态
     */
    public static final String SELECT_NOTICE_STATUS                        = "noticeStatus";

    /**
     * 查询条件：业务类型
     */
    public static final String SELECT_BUSINESS_TYPE                        = "businessType";

    /**
     * 查询条件：业务子类型
     */
    public static final String SELECT_BUSINESS_SUB_TYPE                    = "businessSubType";

    /**
     * 查询条件：阅读状态
     */
    public static final String SELECT_READ_STATUS                          = "readStatus";

    /**
     * 报表：汇总title
     */
    public static final String REPORT_COLLECT_TITLE                        = "合计";

    /**
     * 报表类型：收入报表
     */
    public static final String REPORT_TYPE_INCOME                          = "income";

    /**
     * 报表类型：送礼报表
     */
    public static final String REPORT_TYPE_GIFT_SEND                       = "giftSend";

    /**
     * 报表类型：收礼礼报表
     */
    public static final String REPORT_TYPE_GIFT_RECEIVE                    = "giftReceive";

    /**
     * 报表模式：柱状图
     */
    public static final String REPORT_MODE_BAR                             = "bar";

    /**
     * 报表模式：饼图
     */
    public static final String REPORT_MODE_PIE                             = "pie";

    /**
     * 报表子类型：年度报表
     */
    public static final String REPORT_SUB_TYPE_YEAR                        = "year";

    /**
     * 报表子类型：月度报表
     */
    public static final String REPORT_SUB_TYPE_MONTH                       = "month";

    /**
     * 报表子类型：收入来源
     */
    public static final String REPORT_SUB_TYPE_SOURCE                      = "source";

    /**
     * 报表子类型：随礼类型、收入类型
     */
    public static final String REPORT_SUB_TYPE_TYPE                        = "type";

    /**
     * 报表子类型：极值
     */
    public static final String REPORT_SUB_TYPE_PEAK                        = "peak";

    /**
     * 报表子类型：随礼
     */
    public static final String REPORT_SUB_TYPE_GIFT                        = "gift";

    /**
     * 报表月份数：12
     */
    public static final Integer REPORT_NUM_12                              = 12;

    /**
     * 报表单位：年
     */
    public static final String REPORT_UNIT_YEAR                            = "年";

    /**
     * 报表单位：月
     */
    public static final String REPORT_UNIT_MONTH                           = "月";

    /**
     * 用户状态：正常
     */
    public static final String USER_STATUS_NORMAL                           = "1";

    /**
     * 用户状态：冻结
     */
    public static final String USER_STATUS_FREEZE                           = "2";

    /**
     * x_requested_with
     */
    public static final String X_REQUESTED_WITH                             = "x-requested-with";

    /**
     * XMLHttpRequest
     */
    public static final String XML_HTTPREQUEST                              = "XMLHttpRequest";

    /**
     * 开关：on
     */
    public static final String SWITCH_ON                                    = "on";

    /**
     * 开关：off
     */
    public static final String SWITCH_OFF                                   = "off";

    /**
     * 管理员
     */
    public static final String ADMIN_CODE                                   = "admin";

    /**
     * 系统错误
     * */
    public static final String ERROR_PATH                                   = "/error";

    /**
     * 404页面
     * */
    public static final String PAGE_ERROR_404                               = "/error/404";

    /**
     * 登录请求
     * */
    public static final String PAGE_LOGIN                                  = "/login";

    /**
     * 首页请求
     * */
    public static final String PAGE_INDEX                                  = "/index";

    /**
     * 忽略后缀
     */
    public static final String IGORE_SUFFIX                                 = "js,css,jpg,jpeg,png,gif,woff2,woff,ttf";

    /**
     * 忽略请求
     */
    public static final String IGORE_REQUEST                                = "/login,/user/login";

    /**
     * 状态：status
     * */
    public static final String STATUS                                       = "status";

    /**
     * 状态：timeout
     * */
    public static final String STATUS_TIMEOUT                               = "timeout";

    /**
     * 参数类型
     */
    public static final String PARAMETER_TYPE_SWITCH                        = "switch";

    /**
     * 用户密码
     */
    public static final String PASSWORD                                     = "password";

}
