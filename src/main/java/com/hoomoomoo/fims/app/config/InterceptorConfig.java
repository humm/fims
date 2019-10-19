package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.hoomoomoo.fims.app.consts.TipConst.LOG_BUSINESS_TYPE_INTERCEPTOR;

/**
 * @author humm23693
 * @description 拦截器配置
 * @package com.hoomoomoo.fims.app.config
 * @date 2019/09/01
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(InterceptorConfig.class);

    @Autowired
    private FimsInterceptorConfig fimsInterceptorConfig;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 自定义拦截器 添加拦截路径和排除拦截路径
        registry.addInterceptor(fimsInterceptorConfig).addPathPatterns("/**");

        // .addPathPatterns("/**"); 所有请求
        // .addPathPatterns("/interface/**"); 指定请求
        // .excludePathPatterns("/static"); 不拦截请求
        LogUtils.load(logger, LOG_BUSINESS_TYPE_INTERCEPTOR);
    }

}
