package com.hoomoomoo.fims.app.config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import static com.hoomoomoo.fims.app.consts.BusinessConst.APPLICATION_PROPERTIES;
import static com.hoomoomoo.fims.app.consts.BusinessConst.SPRING_DATASOURCE;


/**
 * @author hoomoomoo
 * @description 数据库连接配置类
 * @package com.hoomoomoo.fims.app.config.bean
 * @date 2019/11/23
 */

@Component
@PropertySource({APPLICATION_PROPERTIES})
@ConfigurationProperties(prefix = SPRING_DATASOURCE)
@Data
public class DatasourceConfigBean {

    /**
     * 连接驱动
     */
    private String driver;

    /**
     * 连接url
     */
    private String url;

    /**
     * 连接用户名
     */
    private String username;

    /**
     * 连接密码
     */
    private String password;

}
