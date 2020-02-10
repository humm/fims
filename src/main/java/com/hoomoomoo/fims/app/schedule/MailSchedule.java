package com.hoomoomoo.fims.app.schedule;

import com.hoomoomoo.fims.app.service.SysInterfaceService;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import static com.hoomoomoo.fims.app.consts.CueConst.LOG_BUSINESS_TYPE_INTERFACE;

/**
 * @author humm23693
 * @description 邮件数据处理定时任务
 * @package com.hoomoomoo.fims.app.schedule
 * @date 2020/02/10
 */

@Configuration
@EnableScheduling
@ConditionalOnExpression("'${fims.schedule.mail:false}' == 'true'")
public class MailSchedule implements SchedulingConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(MailSchedule.class);

    @Value("${fims.schedule.mailCron:0 */1 * * * ?}")
    private String cron;

    @Autowired
    private SysInterfaceService sysInterfaceService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addCronTask(new Runnable() {
            @Override
            public void run() {
                try {
                    // 读取邮件
                    sysInterfaceService.handleMailRequest();
                } catch (Exception e) {
                    SysLogUtils.exception(logger, LOG_BUSINESS_TYPE_INTERFACE, e);
                }
            }
        }, cron);
    }
}
