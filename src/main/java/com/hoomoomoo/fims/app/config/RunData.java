package com.hoomoomoo.fims.app.config;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author humm23693
 * @description 内存数据
 * @package com.hoomoomoo.fims.app.consts
 * @date 2019/08/08
 */

public class RunData {

    /**
     * 业务序列号
     */
    public static ConcurrentHashMap<String, String> BUSINESS_SERIAL_NO      = new ConcurrentHashMap<>();

    /**
     * 开始结束日志打印
     */
    public static Boolean LOG_START_END                                     = true;
}
