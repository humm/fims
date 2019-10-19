package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.config.bean.FimsConfigBean;
import com.hoomoomoo.fims.app.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.xml.ws.soap.Addressing;

import static com.hoomoomoo.fims.app.consts.TipConst.LOG_BUSINESS_TYPE_SESSION;

/**
 * @author humm23693
 * @description session配置
 * @package com.hoomoomoo.fims.app.config
 * @date 2019/09/01
 */

@WebListener
public class SessionConfig implements HttpSessionListener {

    private static final Logger logger = LoggerFactory.getLogger(SessionConfig.class);

    @Autowired
    private FimsConfigBean fimsConfigBean;

    @PostConstruct
    public void init() {
        LogUtils.load(logger, LOG_BUSINESS_TYPE_SESSION);
    }

    /**
     * 触发时机: request.getSession()
     *
     * @param httpSessionEvent
     */
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.setMaxInactiveInterval(fimsConfigBean.getSessionTimeout());
    }

    /**
     * 触发时机: request.getSession().invalidate() 自动过期也会触发 还有其他方式等
     *
     * @param httpSessionEvent
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        // todo 回填登录日志退出信息
    }
}
