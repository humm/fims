package com.hoomoomoo.fims.app.config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static com.hoomoomoo.fims.app.consts.SystemConst.APPLICATION_PROPERTIES;
import static com.hoomoomoo.fims.app.consts.SystemConst.FIMS_CONFIG;

/**
 * @author humm23693
 * @description 系统参数配置
 * @package com.hoomoomoo.fims.app.config.bean
 * @date 2019/08/03
 */

@Configuration
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
     * 控制台输出配置参数过滤关键词
     */
    private String consoleOutputKeyword;

    /**
     * 是否控制台输出配置参数
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

}
