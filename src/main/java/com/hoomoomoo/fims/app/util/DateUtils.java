package com.hoomoomoo.fims.app.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.hoomoomoo.fims.app.consts.BusinessConst.*;

/**
 * @author humm23693
 * @description 时间工具类
 * @package com.hoomoomoo.fims.app.util
 * @date 2019/08/08
 */

public class DateUtils {

    /**
     * 年月日
     *
     * @return
     */
    public static String yyyyMMdd(){
        return new SimpleDateFormat(YYYYMMDD).format(new Date());
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
