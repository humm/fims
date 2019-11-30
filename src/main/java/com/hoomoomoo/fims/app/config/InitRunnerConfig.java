package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.service.SysParameterService;
import com.hoomoomoo.fims.app.service.SysSystemService;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
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
    private SysSystemService sysSystemService;

    @Override
    public void run(String... args) {
        // 系统初始化
        sysSystemService.initSystem();

        // 系统启动备份
        sysSystemService.applicationStartBackup();

        // 加载配置sql
        sysSystemService.getConfigSql();

        // 加载系统参数
        sysSystemService.initParameter();

        // 输出系统配置参数至控制台
        sysSystemService.outputConfigParameter();

        // 加载业务ID数据
        sysSystemService.loadBusinessId();

        // 加载查询数据字典
        sysSystemService.loadSysDictionaryCondition();

        SysLogUtils.load(logger, LOG_BUSINESS_TYPE_INIT);
    }
}
