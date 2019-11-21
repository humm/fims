package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.util.SysLogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import static com.hoomoomoo.fims.app.consts.BusinessConst.*;
import static com.hoomoomoo.fims.app.consts.TipConst.LOG_BUSINESS_TYPE_EXCEPTION;

/**
 * @author humm23693
 * @description 全局异常处理
 * @package com.hoomoomoo.fims.app.config
 * @date 2019/10/19
 */

@Controller
@RequestMapping("/error")
@ApiIgnore
public class ExceptionHandlerGlobalConfig implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerGlobalConfig.class);

    @PostConstruct
    public void init(){
        SysLogUtils.load(logger, LOG_BUSINESS_TYPE_EXCEPTION);
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(produces = {TEXT_HTML})
    public ModelAndView viewHandler(HttpServletRequest request){
        logger.error(request.getRequestURL().toString());
        return new ModelAndView(PAGE_ERROR_404);
    }
}
