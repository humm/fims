package com.hoomoomoo.fims.app.config;


import com.hoomoomoo.fims.app.dto.SessionBean;
import com.hoomoomoo.fims.app.util.SystemSessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.hoomoomoo.fims.app.consts.TipConst.LOGIN_FILTER_INIT_SUCCESS;

/**
 * @author humm23693
 * @description 登录过滤器
 * @package com.hoomoomoo.fims.app.config
 * @date 2019/08/08
 */

@Order(1)
@WebFilter(urlPatterns = "/*")
public class LoginFilterConfig implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LoginFilterConfig.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info(LOGIN_FILTER_INIT_SUCCESS);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String servletPath = request.getServletPath();

        SessionBean sessionBean = new SessionBean();
        sessionBean.setUserId("20190808000001");
        sessionBean.setUserCode("admin");
        sessionBean.setUserName("系统管理员");

        SystemSessionUtils.setSession(sessionBean);

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
