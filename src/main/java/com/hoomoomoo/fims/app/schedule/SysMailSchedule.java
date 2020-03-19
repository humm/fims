package com.hoomoomoo.fims.app.schedule;

import com.hoomoomoo.fims.app.service.SysInterfaceService;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.hoomoomoo.fims.app.consts.BusinessConst.COLON;
import static com.hoomoomoo.fims.app.consts.CueConst.*;

/**
 * @author humm23693
 * @description 邮件数据处理定时任务
 * @package com.hoomoomoo.fims.app.schedule
 * @date 2020/02/10
 */

@Configuration
@EnableScheduling
@ConditionalOnExpression("${fims.schedule.mail:true}")
public class SysMailSchedule implements SchedulingConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(SysMailSchedule.class);

    @Value("${fims.schedule.mailCron:*/30 * * * * ?}")
    private String cron;

    @Autowired
    private SysInterfaceService sysInterfaceService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(() ->{
            try {
                // 读取邮件
                SysLogUtils.info(logger, String.format(BUSINESS_SCHEDULE_MAIL, LOG_OPERATE_TAG_START));
                sysInterfaceService.handleMailRequest();
                SysLogUtils.info(logger, String.format(BUSINESS_SCHEDULE_MAIL, LOG_OPERATE_TAG_END));
            } catch (Exception e) {
                SysLogUtils.exception(logger, BUSINESS_SCHEDULE_MAIL.split(COLON)[0], e);
            }
        }, (triggerContext) ->{
            CronTrigger trigger = new CronTrigger(cron);
            Date nextExecDate = trigger.nextExecutionTime(triggerContext);
            return nextExecDate;
        });
    }
}
