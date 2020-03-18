package com.hoomoomoo.fims.app.schedule;

import com.hoomoomoo.fims.app.service.SysWeChatFlowService;
import com.hoomoomoo.fims.app.service.SysWeChatService;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import org.apache.commons.lang.StringUtils;
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

import java.sql.SQLSyntaxErrorException;
import java.util.Date;

import static com.hoomoomoo.fims.app.consts.BusinessConst.COLON;
import static com.hoomoomoo.fims.app.consts.BusinessConst.EXCEPTION_TYPE_TABLE_NOT_EXISTS;
import static com.hoomoomoo.fims.app.consts.CueConst.*;

/**
 * @author humm23693
 * @description 微信数据处理定时任务
 * @package com.hoomoomoo.fims.app.schedule
 * @date 2020/02/28
 */

@Configuration
@EnableScheduling
@ConditionalOnExpression("${fims.schedule.weChat:true}")
public class SysWeChatSchedule implements SchedulingConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(SysWeChatSchedule.class);

    @Value("${fims.schedule.weChatCron:*/5 * * * * ?}")
    private String cron;

    @Autowired
    private SysWeChatService sysWeChatService;

    @Autowired
    private SysWeChatFlowService sysWeChatFlowService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(() ->{
            try {
                // 更新微信流程操作步骤
                SysLogUtils.info(logger, String.format(BUSINESS_SCHEDULE_WECHAT, LOG_OPERATE_TAG_START));
                sysWeChatService.updateOperateFlow();
                sysWeChatFlowService.getWeChatFlow(false);
                SysLogUtils.info(logger, String.format(BUSINESS_SCHEDULE_WECHAT, LOG_OPERATE_TAG_END));
            } catch (Exception e) {
                SysLogUtils.exception(logger, BUSINESS_SCHEDULE_WECHAT.split(COLON)[0], e);
            }
        }, (triggerContext) -> {
            CronTrigger trigger = new CronTrigger(cron);
            Date nextExecDate = trigger.nextExecutionTime(triggerContext);
            return nextExecDate;
        });
    }
}
