package com.hoomoomoo.fims.app.util;


import org.slf4j.Logger;

import java.util.List;

import static com.hoomoomoo.fims.app.config.RunData.LOG_START_END;
import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 日志工具类
 * @package com.hoomoomoo.fims.app.util
 * @date 2019/08/12
 */

public class LogUtils {

    /**
     * 控制层日志开始
     *
     * @param logger
     * @param businessType
     * @param messages
     */
    public static void controllerStart(Logger logger, String businessType, String messages) {
        if (LOG_START_END) {
            logger.info(String.format(LOG_FORMAT_TIP, businessType, LOG_TYPE_CONTROLLER, messages, LOG_OPERATE_TAG_START));
        }
    }

    /**
     * 控制层日志结束
     *
     * @param logger
     * @param businessType
     * @param messages
     */
    public static void controllerEnd(Logger logger, String businessType, String messages) {
        if (LOG_START_END) {
            logger.info(String.format(LOG_FORMAT_TIP, businessType, LOG_TYPE_CONTROLLER, messages, LOG_OPERATE_TAG_END));
        }
    }

    /**
     * 服务层日志开始
     *
     * @param logger
     * @param businessType
     * @param messages
     */
    public static void serviceStart(Logger logger, String businessType, String messages) {
        if (LOG_START_END) {
            logger.info(String.format(LOG_FORMAT_TIP, businessType, LOG_TYPE_SERVICE, messages, LOG_OPERATE_TAG_START));
        }
    }

    /**
     * 服务层日志结束
     *
     * @param logger
     * @param businessType
     * @param messages
     */
    public static void serviceEnd(Logger logger, String businessType, String messages) {
        if (LOG_START_END) {
            logger.info(String.format(LOG_FORMAT_TIP, businessType, LOG_TYPE_SERVICE, messages, LOG_OPERATE_TAG_END));
        }
    }

    /**
     * 业务成功日志
     *
     * @param logger
     * @param businessType
     * @param obj
     */
    public static void success(Logger logger, String businessType, Object obj) {
        logger.info(String.format(LOG_FORMAT_STATUS_MSG, businessType, LOG_OPERATE_TAG_SUCCESS), obj);
    }

    /**
     * 业务成功日志
     *
     * @param logger
     * @param businessType
     */
    public static void success(Logger logger, String businessType) {
        logger.info(String.format(LOG_FORMAT_STATUS, businessType, LOG_OPERATE_TAG_SUCCESS));
    }

    /**
     * 业务失败日志
     *
     * @param logger
     * @param businessType
     * @param obj
     */
    public static void fail(Logger logger, String businessType, Object obj) {
        logger.error(String.format(LOG_FORMAT_STATUS_MSG, businessType, LOG_OPERATE_TAG_FAIL), obj);
    }

    /**
     * 业务异常日志
     *
     * @param logger
     * @param businessType
     * @param e
     */
    public static void exception(Logger logger, String businessType, Exception e) {
        logger.error(String.format(LOG_FORMAT_STATUS, businessType, LOG_OPERATE_TAG_EXCEPTION), e);
    }

    /**
     * 应用启动、参数类成功日志
     *
     * @param logger
     * @param businessType
     */
    public static void configSuccess(Logger logger, String businessType) {
        logger.info(String.format(LOG_TIP, businessType, LOG_OPERATE_TAG_SUCCESS));
    }

    /**
     * 应用启动、参数类开始日志
     *
     * @param logger
     * @param businessType
     */
    public static void configStart(Logger logger, String businessType) {
        logger.info(String.format(LOG_TIP, businessType, LOG_OPERATE_TAG_START));
    }

    /**
     * 应用启动、参数类结束日志
     *
     * @param logger
     * @param businessType
     */
    public static void configEnd(Logger logger, String businessType) {
        logger.info(String.format(LOG_TIP, businessType, LOG_OPERATE_TAG_END));
    }

    /**
     * 功能开始日志
     *
     * @param logger
     * @param businessType
     */
    public static void functionStart(Logger logger, String businessType) {
        if (LOG_START_END) {
            logger.info(String.format(LOG_FORMAT_STATUS, businessType, LOG_OPERATE_TAG_START));
        }
    }

    /**
     * 功能结束日志
     *
     * @param logger
     * @param businessType
     */
    public static void functionEnd(Logger logger, String businessType) {
        if (LOG_START_END) {
            logger.info(String.format(LOG_FORMAT_STATUS, businessType, LOG_OPERATE_TAG_END));
        }
    }

    /**
     * 请求入参日志
     *
     * @param logger
     * @param obj
     */
    public static void parameter(Logger logger, Object obj) {
        if (LOG_START_END) {
            if (obj instanceof List) {
                logger.info(LOG_REQUEST_PARAMETER, BeanMapUtils.beanToMap((List)obj));
            } else {
                logger.info(LOG_REQUEST_PARAMETER, BeanMapUtils.beanToMap(obj));
            }
        }
    }

    /**
     * info日志
     *
     * @param logger
     * @param obj
     */
    public static void info(Logger logger, Object obj) {
        logger.info(obj.toString());
    }
}
