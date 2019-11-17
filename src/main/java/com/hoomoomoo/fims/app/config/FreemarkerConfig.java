package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.config.bean.SystemConfigBean;
import com.hoomoomoo.fims.app.util.LogUtils;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.hoomoomoo.fims.app.consts.SystemConst.APP_NAME;
import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description freeMarker配置类
 * @package com.hoomoomoo.fims.app.config
 * @date 2019/08/10
 */

@Configuration
public class FreemarkerConfig {

    private static final Logger logger = LoggerFactory.getLogger(FreemarkerConfig.class);

    @Autowired
    private SystemConfigBean systemConfigBean;

    @Bean
    public FreeMarkerConfigurer freemarkerViewConfig() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath(systemConfigBean.getFreemarkerTemplateLoaderPath());
        configurer.setDefaultEncoding(systemConfigBean.getFreemarkerCharset());
        configurer.setPreferFileSystemAccess(false);
        Map<String, Object> freemarkerVariables = new HashMap<>(1);
        freemarkerVariables.put(APP_NAME, systemConfigBean.getAppName());
        configurer.setFreemarkerVariables(freemarkerVariables);
        LogUtils.load(logger, LOG_BUSINESS_TYPE_FREEMARKER);
        return configurer;
    }
}
