package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.util.LogUtils;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.hoomoomoo.fims.app.consts.SystemConst.APP_NAME;
import static com.hoomoomoo.fims.app.consts.TipConst.*;
import static com.hoomoomoo.fims.app.consts.TipConst.LOG_OPERATE_TAG_SUCCESS;

/**
 * @author humm23693
 * @description freeMarker配置类
 * @package com.hoomoomoo.fims.app.config
 * @date 2019/08/10
 */

@Configuration
public class ViewResolverConfig {

    private static final Logger logger = LoggerFactory.getLogger(ViewResolverConfig.class);


    @Value("${spring.freemarker.charset}")
    private String charset;

    @Value("${spring.freemarker.template-loader-path}")
    private String templateLoaderPath;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath(templateLoaderPath);
        configurer.setDefaultEncoding(charset);
        configurer.setPreferFileSystemAccess(false);
        Map<String, Object> freemarkerVariables = new HashMap<>(1);
        freemarkerVariables.put(APP_NAME, contextPath);
        configurer.setFreemarkerVariables(freemarkerVariables);
        LogUtils.success(logger, LOG_BUSINESS_TYPE_FREEMARKER);
        return configurer;
    }
}
