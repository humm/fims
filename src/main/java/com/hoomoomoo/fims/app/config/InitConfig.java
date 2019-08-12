package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.config.bean.FimsConfigBean;
import com.hoomoomoo.fims.app.service.SystemService;
import com.hoomoomoo.fims.app.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.hoomoomoo.fims.app.config.RunData.LOG_START_END;
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
    private FimsConfigBean fimsConfigBean;

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

            // 开始结束日志打印参数配置
            LOG_START_END = fimsConfigBean.getLogStartEnd();

            LogUtils.success(logger, LOG_BUSINESS_TYPE_INIT);
        }catch (Exception e){
            LogUtils.exception(logger, LOG_BUSINESS_TYPE_INIT, e);
        }
    }

}
