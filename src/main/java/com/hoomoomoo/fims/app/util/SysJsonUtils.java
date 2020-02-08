package com.hoomoomoo.fims.app.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author humm23693
 * @description json工具类
 * @package com.hoomoomoo.fims.app.util
 * @date 2020/02/08
 */

public class SysJsonUtils {

    private static final ObjectMapper objectMapper              = new ObjectMapper();
    private static boolean isPretty                             = false;
    private static final String STR_EMPTY                       = "";


    public static String toJson(Object object) {
        String jsonString = STR_EMPTY;
        try {
            if (isPretty) {
                jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            } else {
                jsonString = objectMapper.writeValueAsString(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
