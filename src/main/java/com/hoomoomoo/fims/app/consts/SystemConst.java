package com.hoomoomoo.fims.app.consts;

/**
 * @author humm23693
 * @description 系统级别常量
 * @package com.hoomoomoo.fims.app.consts
 * @date 2019/08/03
 */

public class SystemConst {

    /**
     * 应用配置文件路径
     */
    public static final String APPLICATION_PROPERTIES               = "classpath:application.properties";

    /**
     * 定时任务配置读取前缀
     */
    public static final String FIMS_SCHEDULE                        = "fims.schedule";

    /**
     * 应用级别参数读取前缀
     */
    public static final String FIMS_CONFIG                          = "fims.config";

    /**
     * 邮件配置读取前缀
     */
    public static final String SPRING_MAIL                          = "spring.mail";

    /**
     * 数据库连接配置读取前缀
     */
    public static final String SPRING_DATASOURCE                    = "spring.datasource";

    /**
     * 应用名称
     */
    public static final String APP_NAME                             = "appName";

    /**
     * 应用描述
     */
    public static final String APP_DESCRIBE                         = "appDescribe";

    /**
     * 系统初始化数据
     */
    public static final String INIT_SYSTEM_DATA                     = "database/initData.sql";

    /**
     * 系统初始化表结构
     */
    public static final String INIT_SYSTEM_TABLE                    = "database/initTable.sql";

    /**
     * 系统升级数据
     */
    public static final String UPDATE_SYSTEM_DATA                    = "database/updateData.sql";

    /**
     * 系统初始化存储过程
     */
    public static final String INIT_SYSTEM_PROCEDURE                = "database/initProcedure.sql";

    /**
     * 系统配置sql
     */
    public static final String SYSTEM_CONFIG_SQL                    = "mapper/SqlConfig.xml";

    /**
     * 存储过程分隔符
     */
    public static final String INIT_SYSTEM_PROCEDURE_SPLIT          = "-- ====== --";

    /**
     * 当前系统存在数据表
     */
    public static final String SYSTEM_TABLE                         =  new StringBuffer()
                                                                            .append("'sys_user'").append(",")
                                                                            .append("'sys_role'").append(",")
                                                                            .append("'sys_user_role'").append(",")
                                                                            .append("'sys_menu'").append(",")
                                                                            .append("'sys_role_menu'").append(",")
                                                                            .append("'sys_dictionary'").append(",")
                                                                            .append("'sys_parameter'").append(",")
                                                                            .append("'sys_notice'").append(",")
                                                                            .append("'sys_version'").append(",")
                                                                            .append("'sys_login_log'").append(",")
                                                                            .append("'sys_income'").append(",")
                                                                            .append("'sys_gift'").append(",")
                                                                            .append("'sys_interface'").append(",")
                                                                            .append("'sys_config'").toString();

    /**
     * 系统版本号
     */
    public static final String SYSTEM_VERSION                       = "3.1.20";

}
