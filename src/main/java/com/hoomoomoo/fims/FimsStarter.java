package com.hoomoomoo.fims;

import com.hoomoomoo.fims.app.util.SysLogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

import static com.hoomoomoo.fims.app.consts.CueConst.*;


/**
 * @author hoomoomoo
 * @description 应用启动类
 * @package com.hoomoomoo.fims
 * @date 2019/08/03
 */

@SpringBootApplication
@ServletComponentScan
public class FimsStarter {

    private static final Logger logger = LoggerFactory.getLogger(FimsStarter.class);

    private static ApplicationContext applicationContext;

    public static void main(String[] args){
        SpringApplication.run(FimsStarter.class, args);

        SysLogUtils.configSuccess(logger, LOG_BUSINESS_TYPE_APP_START);
    }
}
