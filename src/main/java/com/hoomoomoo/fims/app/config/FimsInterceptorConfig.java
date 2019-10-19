package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 系统拦截器
 * @package com.hoomoomoo.fims.app.config
 * @date 2019/09/01
 */

@Configuration
public class FimsInterceptorConfig implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(FimsInterceptorConfig.class);

    @PostConstruct
    public void init(){
        LogUtils.load(logger, LOG_BUSINESS_TYPE_FIMS_INTERCEPTOR);
    }

    /**
     * 请求完成后 执行前提preHandle方法返回true
     */
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {

    }

    /**
     * controller处理后 执行前提preHandle方法返回true
     */
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {

    }

    /**
     * controller处理前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        // todo 获取参数 是否打印开始结束日志 是否智能填充
        return true;
    }
}
