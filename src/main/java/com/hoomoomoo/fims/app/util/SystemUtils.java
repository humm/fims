package com.hoomoomoo.fims.app.util;

import com.hoomoomoo.fims.app.dto.CommonDto;
import com.hoomoomoo.fims.app.dto.SessionBean;

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
     * @param commonDto
     */
    public static void setCreateUserInfo(CommonDto commonDto){
        SessionBean sessionBean = SystemSessionUtils.getSession();
        if(sessionBean != null){
            commonDto.setCreateUser(sessionBean.getUserCode());
            commonDto.setModifyUser(sessionBean.getUserCode());
        }
        Date date = new Date();
        commonDto.setCreateDate(date);
        commonDto.setModifyDate(date);
    }

    /**
     * 设置修改人信息
     *
     * @param commonDto
     */
    public static void setModifyUserInfo(CommonDto commonDto){
        SessionBean sessionBean = SystemSessionUtils.getSession();
        if(sessionBean != null){
            commonDto.setModifyUser(sessionBean.getUserCode());
        }
        commonDto.setModifyDate(new Date());
    }
}
