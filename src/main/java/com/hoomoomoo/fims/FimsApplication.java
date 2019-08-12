package com.hoomoomoo.fims;

import com.hoomoomoo.fims.app.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import static com.hoomoomoo.fims.app.consts.TipConst.*;


/**
 * @author humm23693
 * @description 应用启动类
 * @package com.hoomoomoo.fims
 * @date 2019/08/03
 */

@SpringBootApplication
@ServletComponentScan
public class FimsApplication {

    private static final Logger logger = LoggerFactory.getLogger(FimsApplication.class);

    public static void main(String[] args){
        SpringApplication.run(FimsApplication.class, args);
        LogUtils.configSuccess(logger, LOG_BUSINESS_TYPE_APP_START);
    }
}
