package com.hoomoomoo.fims.app.config;


import com.hoomoomoo.fims.app.config.bean.FimsConfigBean;
import com.hoomoomoo.fims.app.model.common.SessionBean;
import com.hoomoomoo.fims.app.util.LogUtils;
import com.hoomoomoo.fims.app.util.SystemSessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static com.hoomoomoo.fims.app.consts.BusinessConst.*;
import static com.hoomoomoo.fims.app.consts.SystemConst.*;
import static com.hoomoomoo.fims.app.consts.TipConst.*;

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
    public void init(FilterConfig filterConfig) {
        LogUtils.load(logger, LOG_BUSINESS_TYPE_LOGIN_FILTER);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String servletPath = request.getServletPath();
        int index = servletPath.lastIndexOf(SLASH);
        String requestSuffix = servletPath.substring(index + 1);
        SessionBean sessionBean = (SessionBean) request.getSession().getAttribute(SESSION_BEAN);
        logger.error(servletPath);
        if (sessionBean != null) {
            SystemSessionUtils.setSession(sessionBean);
            if (PAGE_LOGIN.equals(servletPath)) {
                response.sendRedirect(request.getContextPath() + PAGE_INDEX);
            }
        } else {
            if (!isIgoreSuffix(requestSuffix) && IGORE_REQUEST.indexOf(servletPath) == -1) {
                if (isAjaxRequest(request)) {
                    response.setHeader(STATUS, STATUS_TIMEOUT);
                } else {
                    toLogin(request, response);
                }
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    /**
     * 跳转登入页面
     *
     * @param request
     * @param response
     */
    private void toLogin(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            printWriter.println("<html><script>");
            printWriter.println("window.open ('" + request.getContextPath() + PAGE_LOGIN + "','_top')");
            printWriter.println("</script></html>");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }

    /**
     * 是否忽略后缀
     *
     * @param requestSuffix
     * @return
     */
    private boolean isIgoreSuffix(String requestSuffix) {
        if (!requestSuffix.contains(POINT)) {
            return false;
        }
        String[] suffixs = IGORE_SUFFIX.split(COMMA);
        for (String suffix : suffixs) {
            if (requestSuffix.endsWith(suffix)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否ajax请求
     *
     * @param request
     * @return
     */
    private boolean isAjaxRequest(HttpServletRequest request) {
        if (request.getHeader(X_REQUESTED_WITH) != null && request.getHeader(X_REQUESTED_WITH).equalsIgnoreCase(XML_HTTPREQUEST)) {
            return true;
        } else {
            return false;
        }
    }
}
