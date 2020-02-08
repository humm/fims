package com.hoomoomoo.fims.app.util;

import com.hoomoomoo.fims.app.model.common.BaseModel;
import net.sf.cglib.beans.BeanMap;
import org.apache.commons.collections.CollectionUtils;
import java.util.*;


/**
 * @author humm23693
 * @description bean map 转换工具类
 * @package com.hoomoomoo.fims.app.util
 * @date 2019/08/08
 */

public class SysBeanUtils {

    /**
     * map转换成bean
     *
     * @param clazz
     * @param map
     */
    public static BaseModel mapToBean(Class clazz, Map map) {
        BaseModel baseModel = null;
        try {
            baseModel = (BaseModel) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        BeanMap beanMap = BeanMap.create(baseModel);
        beanMap.putAll(map);
        return baseModel;
    }

    /**
     * bean转换成map
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> beanToMap(Object obj) {
        Map<String, Object> target = new HashMap(16);
            BeanMap beanMap = BeanMap.create(obj);
            for (Object key : beanMap.keySet()) {
                Object value = beanMap.get(key);
                if (value != null) {
                    target.put(String.valueOf(key), value);
                }
            }
        return target;
    }

    /**
     * bean转换成map
     *
     * @param list
     * @return
     */
    public static List<Map<String, Object>> beanToMap(List<Object> list){
        List<Map<String, Object>> map = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for (Object obj: list) {
                map.add(beanToMap(obj));
            }
        }
        return map;
    }
}
