package com.hoomoomoo.fims.app.util;

import com.hoomoomoo.fims.app.model.common.QueryBaseModel;
import com.hoomoomoo.fims.app.model.common.SessionBean;
import com.hoomoomoo.fims.app.model.common.BaseModel;

import java.util.Date;

/**
 * @author humm23693
 * @description 系统级工具类
 * @package com.hoomoomoo.fims.app.util
 * @date 2019/08/08
 */

public class SystemUtils {

    /**
     * 设置创建人修改人信息
     *
     * @param baseModel
     */
    public static void setCreateUserInfo(BaseModel baseModel){
        SessionBean sessionBean = SystemSessionUtils.getSession();
        if(sessionBean != null){
            baseModel.setCreateUser(sessionBean.getUserCode());
            baseModel.setModifyUser(sessionBean.getUserCode());
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
    public static void setModifyUserInfo(BaseModel baseModel){
        SessionBean sessionBean = SystemSessionUtils.getSession();
        if(sessionBean != null){
            baseModel.setModifyUser(sessionBean.getUserCode());
        }
        baseModel.setModifyDate(new Date());
    }

    /**
     * 设置查询实体session信息
     *
     * @param queryBaseModel
     */
    public static void setSessionInfo(QueryBaseModel queryBaseModel){
        SessionBean sessionBean = SystemSessionUtils.getSession();
        queryBaseModel.setUserKey(sessionBean.getUserId());
        queryBaseModel.setIsAdmin(sessionBean.getIsAdmin());
    }
}
