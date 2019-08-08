package com.hoomoomoo.fims.app.config.bean;

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

import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description Swagger配置
 * @package com.hoomoomoo.fims.app.config.bean
 * @date 2019/08/08
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private FimsConfigBean fimsConfigBean;

    @Bean
    public Docket init() {
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
