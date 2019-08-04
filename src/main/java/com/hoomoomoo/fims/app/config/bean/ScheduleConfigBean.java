package com.hoomoomoo.fims.app.config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static com.hoomoomoo.fims.app.consts.SystemConst.APPLICATION_PROPERTIES;
import static com.hoomoomoo.fims.app.consts.SystemConst.FIMS_SCHEDULE;

/**
 * @author humm23693
 * @description 定时任务配置
 * @package com.hoomoomoo.fims.app.config.dto
 * @date 2019/08/03
 */

@Configuration
@PropertySource({APPLICATION_PROPERTIES})
@ConfigurationProperties(prefix = FIMS_SCHEDULE)
@Data
public class ScheduleConfigBean {

    /**
     * 定时任务线程大小
     */
    private Integer poolSize;

    /**
     * 定时任务线程名称前缀
     */
    private String threadNamePrefix;

    /**
     * 优雅停机：线程池中任务等待时间
     */
    private Integer awaitTerminationSeconds;

    /**
     * 优雅停机：是否等待所有线程执行完
     */
    private Boolean waitForTasksToCompleteOnShutdown;

    /**
     * 是否开启初始化数据定时任务
     */
    private Boolean init;

    /**
     * 是否开启邮件读取定时任务
     */
    private Boolean mail;

    /**
     * 邮件读取定时任务执行规则
     */
    private String mailCron;

}
