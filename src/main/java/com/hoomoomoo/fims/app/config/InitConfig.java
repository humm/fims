package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.service.common.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

import static com.hoomoomoo.fims.app.consts.TipConst.INIT_EXCEPTION;

/**
 * @author humm23693
 * @description 初始化配置
 * @package com.hoomoomoo.fims.app.config.bean
 * @date 2019/08/04
 */
@Configuration
public class InitConfig {

    private static final Logger logger = LoggerFactory.getLogger(InitConfig.class);

    @Autowired
    private SystemService systemService;

    @PostConstruct
    public void init(){
        try {
            systemService.outputConfigParameter();
        }catch (Exception e){
            logger.error(INIT_EXCEPTION, e);
        }
    }

}
