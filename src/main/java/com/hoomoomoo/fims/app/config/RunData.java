package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.model.SysDictionaryModel;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author humm23693
 * @description 运行内存数据
 * @package com.hoomoomoo.fims.app.config
 * @date 2019/08/08
 */

public class RunData {

    /**
     * 业务序列号
     */
    public static ConcurrentHashMap<String, String> BUSINESS_SERIAL_NO      = new ConcurrentHashMap<>();

    /**
     * 字典项查询条件
     */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, List<SysDictionaryModel>>> SYSDICTIONARY_CONDITION    = new ConcurrentHashMap<>();

    /**
     * 开始结束日志打印
     */
    public static Boolean LOG_START_END                                     = true;
}
