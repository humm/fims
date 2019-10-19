package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.config.bean.CommonConfigBean;
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
    private CommonConfigBean commonConfigBean;

    @Bean
    public FreeMarkerConfigurer freemarkerViewConfig() throws IOException, TemplateException {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath(commonConfigBean.getFreemarkerTemplateLoaderPath());
        configurer.setDefaultEncoding(commonConfigBean.getFreemarkerCharset());
        configurer.setPreferFileSystemAccess(false);
        Map<String, Object> freemarkerVariables = new HashMap<>(1);
        freemarkerVariables.put(APP_NAME, commonConfigBean.getAppName());
        configurer.setFreemarkerVariables(freemarkerVariables);
        LogUtils.load(logger, LOG_BUSINESS_TYPE_FREEMARKER);
        return configurer;
    }
}
