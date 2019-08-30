package com.hoomoomoo.fims.app.config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import static com.hoomoomoo.fims.app.consts.SystemConst.APPLICATION_PROPERTIES;
import static com.hoomoomoo.fims.app.consts.SystemConst.FIMS_CONFIG;

/**
 * @author humm23693
 * @description 系统参数配置
 * @package com.hoomoomoo.fims.app.config.bean
 * @date 2019/08/03
 */

@Component
@PropertySource({APPLICATION_PROPERTIES})
@ConfigurationProperties(prefix = FIMS_CONFIG)
@Data
public class FimsConfigBean {

    /**
     * 文件上传路径
     */
    private String uploadLocation;

    /**
     * 文件备份路径
     */
    private String backupLocation;

    /**
     * 应用启动打印配置参数转换为*输出key
     */
    private String convertOutputKeyword;

    /**
     * 应用启动打印配置参数忽略key
     */
    private String ignoreOutputKeyword;

    /**
     * 应用启动是否打印配置参数
     */
    private Boolean consoleOutput;

    /**
     * 应用启动是否备份数据
     */
    private Boolean StartBackup;

    /**
     * 应用启动是否读取邮件数据
     */
    private Boolean StartMail;

    /**
     * 是否开启Swagger
     */
    private Boolean swagger;

    /**
     * Swagger配置扫描路径
     */
    private String swaggerLocation;

    /**
     * 是否打印开始结束日志
     */
    private Boolean logStartEnd;

    /**
     * 是否打印请求入参日志
     */
    private Boolean logParameter;

}
