package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.hoomoomoo.fims.app.consts.BusinessConst.*;
import static com.hoomoomoo.fims.app.consts.CueConst.*;
/**
 * @author humm23693
 * @description 全局异常处理
 * @package com.hoomoomoo.fims.app.config
 * @date 2019/10/19
 */

@Controller
@ApiIgnore
public class ExceptionHandlerConfig implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerConfig.class);

    @PostConstruct
    public void init(){
        SysLogUtils.load(logger, LOG_BUSINESS_TYPE_EXCEPTION);
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(value = ERROR_PATH, produces = {TEXT_HTML})
    public String viewHandler(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        Integer statusCode = (Integer) request.getAttribute(ERROR_STATUS_CODE);
        String errorCode = PAGE_ERROR;
        modelMap.addAttribute(MESSAGE, TIPS_ERROR);
        if (STR_404.equals(statusCode)) {
            errorCode = PAGE_ERROR_404;
        }
        logger.error(request.getRequestURL().toString());
        return errorCode;
    }

    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public ResultData errorHandler(HttpServletRequest request, HttpServletResponse response) {
        logger.error(request.getRequestURL().toString());
        return new ResultData(STATUS_FAIL, ERROR);
    }
}
