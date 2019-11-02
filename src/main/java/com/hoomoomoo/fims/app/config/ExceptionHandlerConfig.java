package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import static com.hoomoomoo.fims.app.consts.BusinessConst.STATUS_FAIL;
import static com.hoomoomoo.fims.app.consts.CueConst.ERROR;
import static com.hoomoomoo.fims.app.consts.TipConst.LOG_BUSINESS_TYPE_EXCEPTION;

/**
 * @author humm23693
 * @description 全局异常处理
 * @package com.hoomoomoo.fims.app.config
 * @date 2019/09/01
 */

@ControllerAdvice
public class ExceptionHandlerConfig {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerConfig.class);

    @PostConstruct
    public void init(){
        LogUtils.load(logger, LOG_BUSINESS_TYPE_EXCEPTION);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultData exceptionHandler(HttpServletRequest request, Exception e){
        logger.error(request.getRequestURL().toString());
        e.printStackTrace();
        return new ResultData(STATUS_FAIL, ERROR);
    }
}
