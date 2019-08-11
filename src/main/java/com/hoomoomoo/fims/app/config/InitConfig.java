package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 初始化配置
 * @package com.hoomoomoo.fims.app.config.bean
 * @date 2019/08/04
 */

@Component
public class InitConfig {

    private static final Logger logger = LoggerFactory.getLogger(InitConfig.class);

    @Autowired
    private SystemService systemService;

    /**
     * 数据初始化
     */
    @PostConstruct
    public void init(){
        try {
            // 输出系统配置参数至控制台
            systemService.outputConfigParameter();

            // 加载业务ID数据
            systemService.loadBusinessId();

            logger.info(String.format(LOG_FORMAT_STATUS, LOG_BUSINESS_TYPE_INIT, LOG_OPERATE_TAG_SUCCESS));
        }catch (Exception e){
            logger.error(String.format(LOG_FORMAT_STATUS, LOG_BUSINESS_TYPE_INIT, LOG_OPERATE_TAG_EXCEPTION), e);
        }
    }

}
