package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.config.bean.FimsConfigBean;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static com.hoomoomoo.fims.app.consts.CueConst.*;

/**
 * @author hoomoomoo
 * @description Swagger配置
 * @package com.hoomoomoo.fims.app.config
 * @date 2019/08/08
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);

    @Autowired
    private FimsConfigBean fimsConfigBean;

    @Bean
    public Docket init() {
        SysLogUtils.load(logger, LOG_BUSINESS_TYPE_SWAGGER);
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(fimsConfigBean.getSwagger())
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(fimsConfigBean.getSwaggerLocation()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(SWAGGER_TITLE)
                .description(SWAGGER_DESCRIPTION)
                .version(SWAGGER_VERSION)
                .build();
    }
}
