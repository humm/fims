package com.hoomoomoo.fims.app.config;

import com.hoomoomoo.fims.app.model.SysDictionaryModel;
import com.hoomoomoo.fims.app.model.SysSqlMode;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author humm23693
 * @description 运行内存数据
 * @package com.hoomoomoo.fims.app.config
 * @date 2019/08/08
 */

public class RunDataConfig {

    /**
     * 业务序列号
     */
    public static ConcurrentHashMap<String, String> BUSINESS_SERIAL_NO      = new ConcurrentHashMap<>();

    /**
     * 配置sql
     */
    public static ConcurrentHashMap<String, SysSqlMode> CONFIG_SQL          = new ConcurrentHashMap<>();

    /**
     * 字典项查询条件
     */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, List<SysDictionaryModel>>> DICTIONARY_CONDITION = new ConcurrentHashMap<>();

    /**
     * 开始结束日志打印
     */
    public static Boolean LOG_REQUEST_TAG                                   = false;

    /**
     * 服务请求入参打印
     */
    public static Boolean LOG_REQUEST_PARAMETER                             = false;

    /**
     * 智能填充
     */
    public static Boolean MIND_FILL                                         = false;
}
