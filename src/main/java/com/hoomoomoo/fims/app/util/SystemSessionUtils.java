package com.hoomoomoo.fims.app.util;

import com.hoomoomoo.fims.app.model.common.SessionBean;

/**
 * @author humm23693
 * @description Session 工具类
 * @package com.hoomoomoo.fims.app.util
 * @date 2019/08/08
 */

public class SystemSessionUtils {

    private static ThreadLocal<SessionBean> threadLocal = new ThreadLocal<SessionBean>();

    /**
     * 设置Session
     *
     * @param sessionBean
     */
    public static void setSession(SessionBean sessionBean){
        threadLocal.set(sessionBean);
    }

    /**
     * 获取Session
     *
     * @return
     */
    public static SessionBean getSession(){
        return threadLocal.get();
    }

    /**
     * 清除Session
     *
     */
    public static void clearSession(){
        threadLocal.remove();
    }
}
