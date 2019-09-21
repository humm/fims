package com.hoomoomoo.fims.app.model.common;

import lombok.Data;

/**
 * @author humm23693
 * @description 最近一次操作类型
 * @package com.hoomoomoo.fims.app.model.common
 * @date 2019/09/01
 */

@Data
public class LastType {

    /**
     * 收入类型
     */
    private String incomeType;

    /**
     * 随礼类型
     */
    private String giftType;

    /**
     * 收入来源
     */
    private String incomeCompany;
}
