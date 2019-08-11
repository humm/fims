package com.hoomoomoo.fims.app.util;

import com.hoomoomoo.fims.app.dto.common.ModelDto;
import com.hoomoomoo.fims.app.dto.common.QueryDto;
import com.hoomoomoo.fims.app.dto.common.SessionBean;

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
     * @param modelDto
     */
    public static void setCreateUserInfo(ModelDto modelDto){
        SessionBean sessionBean = SystemSessionUtils.getSession();
        if(sessionBean != null){
            modelDto.setCreateUser(sessionBean.getUserCode());
            modelDto.setModifyUser(sessionBean.getUserCode());
        }
        Date date = new Date();
        modelDto.setCreateDate(date);
        modelDto.setModifyDate(date);
    }

    /**
     * 设置修改人信息
     *
     * @param modelDto
     */
    public static void setModifyUserInfo(ModelDto modelDto){
        SessionBean sessionBean = SystemSessionUtils.getSession();
        if(sessionBean != null){
            modelDto.setModifyUser(sessionBean.getUserCode());
        }
        modelDto.setModifyDate(new Date());
    }

    /**
     * 设置查询实体session信息
     *
     * @param queryDto
     */
    public static void setSessionInfo(QueryDto queryDto){
        SessionBean sessionBean = SystemSessionUtils.getSession();
        queryDto.setUserKey(sessionBean.getUserId());
        queryDto.setIsAdmin(sessionBean.getIsAdmin());
    }
}
