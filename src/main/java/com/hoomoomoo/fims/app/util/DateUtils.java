package com.hoomoomoo.fims.app.util;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author humm23693
 * @description 时间工具类
 * @package com.hoomoomoo.fims.app.util
 * @date 2019/08/08
 */

public class DateUtils {

    /**
     * 时间格式化类型
     */
    public static final String YYYYMMDD                            = "yyyyMMdd";

    /**
     * 时间格式化类型
     */
    public static final String YYYY                                = "yyyy";

    /**
     * 时间格式化类型
     */
    public static final String HHMMSS                              = "HHmmss";

    /**
     * 时间格式化类型
     */
    public static final String YYYYMMDDHHMMSS                      = "yyyyMMddHHmmss";

    /**
     * 年月日
     *
     * @return
     */
    public static String yyyyMMdd(){
        return new SimpleDateFormat(YYYYMMDD).format(new Date());
    }

    /**
     * 年
     *
     * @return
     */
    public static String yyyy(){
        return new SimpleDateFormat(YYYY).format(new Date());
    }

    /**
     * 时分秒
     *
     * @return
     */
    public static String HHmmss(){
        return new SimpleDateFormat(HHMMSS).format(new Date());
    }

    /**
     * 年月日时分秒
     *
     * @return
     */
    public static String yyyyMMddHHmmss(){
        return new SimpleDateFormat(YYYYMMDDHHMMSS).format(new Date());
    }
}
