package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.config.bean.FimsConfigBean;
import com.hoomoomoo.fims.app.model.SysLoginLogModel;
import com.hoomoomoo.fims.app.model.SysUserModel;
import com.hoomoomoo.fims.app.model.common.SessionBean;
import com.hoomoomoo.fims.app.service.SysLoginLogService;
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

import java.util.Date;

import static com.hoomoomoo.fims.app.consts.BusinessConst.SESSION_BEAN;
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
    private SysLoginLogService sysLoginLogService;

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
        // todo 超时时间
        session.setMaxInactiveInterval(500);
    }

    /**
     * 触发时机: request.getSession().invalidate() 自动过期也会触发 还有其他方式等
     *
     * @param httpSessionEvent
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        // 更新登录日志
        HttpSession session = httpSessionEvent.getSession();
        SessionBean sessionBean = (SessionBean)session.getAttribute(SESSION_BEAN);
        if(sessionBean != null){
            SysLoginLogModel sysLoginLogModel= new SysLoginLogModel();
            sysLoginLogModel.setUserId(sessionBean.getUserId());
            sysLoginLogModel.setLogoutDate(new Date());
            sysLoginLogService.update(sysLoginLogModel);
        }
    }
}
