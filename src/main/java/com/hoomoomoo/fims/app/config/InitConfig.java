package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.service.common.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.hoomoomoo.fims.app.consts.TipConst.INIT_EXCEPTION;
import static com.hoomoomoo.fims.app.consts.TipConst.INIT_SUCCESS;

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

            logger.info(INIT_SUCCESS);
        }catch (Exception e){
            logger.error(INIT_EXCEPTION, e);
        }
    }

}
