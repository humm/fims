package com.hoomoomoo.fims.app.dto;

import lombok.Data;

/**
 * @author humm23693
 * @description Session信息
 * @package com.hoomoomoo.fims.app.config.bean
 * @date 2019/08/08
 */

@Data
public class SessionBean {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户代码
     */
    private String userCode;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户状态
     */
    private String userStatus;

    /**
     * 登录IP
     */
    private String loginIP;

    /**
     * 是否管理员
     */
    private Boolean isAdmin;

}
