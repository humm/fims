package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.service.SysParameterService;
import com.hoomoomoo.fims.app.service.SysSystemService;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.hoomoomoo.fims.app.consts.CueConst.*;
/**
 * @author humm23693
 * @description 系统拦截器
 * @package com.hoomoomoo.fims.app.config
 * @date 2019/09/01
 */

@Configuration
public class FimsInterceptorConfig implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(FimsInterceptorConfig.class);

    @Autowired
    private SysSystemService sysSystemService;

    @PostConstruct
    public void init(){
        SysLogUtils.load(logger, LOG_BUSINESS_TYPE_FIMS_INTERCEPTOR);
    }

    /**
     * 请求完成后 执行前提preHandle方法返回true
     */
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) {

    }

    /**
     * controller处理后 执行前提preHandle方法返回true
     */
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) {

    }

    /**
     * controller处理前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) {
        // 加载系统参数
        sysSystemService.initParameter();
        return true;
    }
}
