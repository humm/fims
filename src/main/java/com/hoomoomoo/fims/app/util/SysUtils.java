package com.hoomoomoo.fims.app.util;

import com.hoomoomoo.fims.app.model.common.QueryBaseModel;
import com.hoomoomoo.fims.app.model.common.SessionBean;
import com.hoomoomoo.fims.app.model.common.BaseModel;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author humm23693
 * @description 系统级工具类
 * @package com.hoomoomoo.fims.app.util
 * @date 2019/08/08
 */

public class SysUtils {

    /**
     * 设置创建人修改人信息
     *
     * @param baseModel
     */
    public static void setCreateUserInfo(BaseModel baseModel) {
        SessionBean sessionBean = SysSessionUtils.getSession();
        if (sessionBean != null) {
            baseModel.setCreateUser(sessionBean.getUserId());
            baseModel.setModifyUser(sessionBean.getUserId());
        }
        Date date = new Date();
        baseModel.setCreateDate(date);
        baseModel.setModifyDate(date);
    }

    /**
     * 设置修改人信息
     *
     * @param baseModel
     */
    public static void setModifyUserInfo(BaseModel baseModel) {
        SessionBean sessionBean = SysSessionUtils.getSession();
        if (sessionBean != null) {
            baseModel.setModifyUser(sessionBean.getUserId());
        }
        baseModel.setModifyDate(new Date());
    }

    /**
     * 设置查询实体session信息
     *
     * @param queryBaseModel
     */
    public static void setSessionInfo(QueryBaseModel queryBaseModel) {
        SessionBean sessionBean = SysSessionUtils.getSession();
        if (sessionBean != null) {
            queryBaseModel.setUserKey(sessionBean.getUserId());
            queryBaseModel.setIsAdminData(sessionBean.getIsAdminData());
        }
    }

    /**
     * 获取连接url
     *
     * @param httpServletRequest
     * @return
     */
    public static String getConnectUrl(HttpServletRequest httpServletRequest, String appName){
        String url = httpServletRequest.getRequestURL().toString();
        String uri = httpServletRequest.getRequestURI();
        return new StringBuffer(url.substring(0, url.indexOf(uri))).append(appName).toString();
    }
}