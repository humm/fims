package com.hoomoomoo.fims.app.schedule;

import com.hoomoomoo.fims.app.service.SysInterfaceService;
import com.hoomoomoo.fims.app.service.SysWeChatService;
import com.hoomoomoo.fims.app.service.impl.SysWeChatServiceImpl;
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

import static com.hoomoomoo.fims.app.consts.CueConst.*;
import static com.hoomoomoo.fims.app.consts.CueConst.LOG_BUSINESS_TYPE_MAIL;

/**
 * @author humm23693
 * @description 微信数据处理定时任务
 * @package com.hoomoomoo.fims.app.schedule
 * @date 2020/02/28
 */

@Configuration
@EnableScheduling
@ConditionalOnExpression("'${fims.schedule.weChat:false}' == 'true'")
public class SysWeChatSchedule implements SchedulingConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(SysWeChatSchedule.class);

    @Value("${fims.schedule.weChatCron:*/1 * * * * ?}")
    private String cron;

    @Autowired
    private SysWeChatService sysWeChatService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addCronTask(new Runnable() {
            @Override
            public void run() {
                try {
                    // 更新微信流程操作步骤
                    SysLogUtils.info(logger, String.format(BUSINESS_SCHEDULE_WECHAT, LOG_OPERATE_TAG_START));
                    sysWeChatService.updateOperateFlow();
                    SysLogUtils.info(logger, String.format(BUSINESS_SCHEDULE_WECHAT, LOG_OPERATE_TAG_END));
                } catch (Exception e) {
                    SysLogUtils.exception(logger, BUSINESS_SCHEDULE_WECHAT, e);
                }
            }
        }, cron);
    }
}
