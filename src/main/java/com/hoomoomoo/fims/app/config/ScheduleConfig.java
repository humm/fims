package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.config.bean.ScheduleConfigBean;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executor;

import static com.hoomoomoo.fims.app.consts.BusinessConst.SHUTDOWN;
import static com.hoomoomoo.fims.app.consts.CueConst.*;

/**
 * @author hoomoomoo
 * @description 定时任务配置
 * @package com.hoomoomoo.fims.app.config
 * @date 2019/08/29
 */

@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer, AsyncConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleConfig.class);

    @Autowired
    private ScheduleConfigBean scheduleConfigBean;


    @PostConstruct
    public void init(){
        SysLogUtils.load(logger, LOG_BUSINESS_TYPE_SCHEDULE);
    }

    /**
     * 异常处理
     * @param scheduledTaskRegistrar
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        TaskScheduler taskScheduler = taskScheduler();
        scheduledTaskRegistrar.setTaskScheduler(taskScheduler);
    }

    /**
     * 定时任务多线程处理
     *
     * @return
     */
    @Bean(destroyMethod = SHUTDOWN)
    public ThreadPoolTaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(scheduleConfigBean.getPoolSize());
        scheduler.setThreadNamePrefix(scheduleConfigBean.getThreadNamePrefix());
        scheduler.setAwaitTerminationSeconds(scheduleConfigBean.getAwaitTerminationSeconds());
        scheduler.setWaitForTasksToCompleteOnShutdown(scheduleConfigBean.getWaitForTasksToCompleteOnShutdown());
        return scheduler;
    }

    /**
     * 异步处理
     *
     * @return
     */
    @Override
    public Executor getAsyncExecutor(){
        return taskScheduler();
    }

    /**
     * 异步处理 异常
     *
     * @return
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler(){
        return new SimpleAsyncUncaughtExceptionHandler();
    }

}
