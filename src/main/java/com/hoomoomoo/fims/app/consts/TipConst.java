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
     * 日志业务类型：应用启动
     */
    public static final String LOG_BUSINESS_TYPE_APP_START                     = "应用启动";

    /**
     * 日志业务类型：参数配置
     */
    public static final String LOG_BUSINESS_TYPE_PARAMETER                      = "参数配置";

    /**
     * 日志业务类型：数据初始化
     */
    public static final String LOG_BUSINESS_TYPE_INIT                           = "数据初始化";

    /**
     * 日志业务类型：登录过滤器
     */
    public static final String LOG_BUSINESS_TYPE_LOGIN_FILTER                   = "登录过滤器初始化";

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
    public static final String LOG_BUSINESS_TYPE_SALARY                         = "收入信息";

    /**
     * 日志业务类型：字典
     */
    public static final String LOG_BUSINESS_TYPE_DICTIONARY                     = "字典信息";

    /**
     * 日志业务类型：用户
     */
    public static final String LOG_BUSINESS_TYPE_USER                           = "用户信息";

    /**
     * 日志业务类型：字典转义
     */
    public static final String LOG_BUSINESS_TYPE_DICTIONARY_TRANSFER            = "字典转义";

    /**
     * 日志业务类型：业务序列号
     */
    public static final String LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO             = "业务序列号";

    /**
     * 日志业务类型：业务序列号
     */
    public static final String LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_GET         = "获取业务序列号";

    /**
     * 日志业务类型：业务序列号
     */
    public static final String LOG_BUSINESS_TYPE_BUSINESS_SERIAL_NO_LOAD        = "加载业务序列号";

    /**
     * 日志业务类型：freemarker模板配置
     */
    public static final String LOG_BUSINESS_TYPE_FREEMARKER                     = "freemarker模板配置";






    /**
     * 请求入参
     */
    public static final String LOG_REQUEST_PARAMETER                            = "服务请求入参：{}";

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
    public static final String SWAGGER_TITLE                                    = "FIMS测试";

    /**
     * Swagger描述
     */
    public static final String SWAGGER_DESCRIPTION                              = "这里没有bug...";

    /**
     * Swagger版本
     */
    public static final String SWAGGER_VERSION                                  = "1.0";

}
