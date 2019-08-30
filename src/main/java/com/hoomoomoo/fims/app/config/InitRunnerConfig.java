package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.config.bean.FimsConfigBean;
import com.hoomoomoo.fims.app.service.SystemService;
import com.hoomoomoo.fims.app.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static com.hoomoomoo.fims.app.config.RunDataConfig.LOG_PARAMETER;
import static com.hoomoomoo.fims.app.config.RunDataConfig.LOG_START_END;
import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 初始化配置
 * @package com.hoomoomoo.fims.app.config.bean
 * @date 2019/08/04
 */

@Component
@Order(1)
public class InitRunnerConfig implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitRunnerConfig.class);

    @Autowired
    private FimsConfigBean fimsConfigBean;

    @Autowired
    private SystemService systemService;

    @Override
    public void run(String... args) throws Exception {
        // 输出系统配置参数至控制台
        systemService.outputConfigParameter();

        // 开始结束日志打印参数配置
        LOG_START_END = fimsConfigBean.getLogStartEnd();

        // 请求入参日志打印参数配置
        LOG_PARAMETER = fimsConfigBean.getLogParameter();

        // 加载业务ID数据
        systemService.loadBusinessId();

        // 加载查询数据字典
        systemService.loadSysDictionaryCondition();

        LogUtils.success(logger, LOG_BUSINESS_TYPE_INIT);
    }
}
