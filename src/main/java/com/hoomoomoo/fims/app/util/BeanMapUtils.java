package com.hoomoomoo.fims.app.util;

import net.sf.cglib.beans.BeanMap;

import java.util.*;

/**
 * @author humm23693
 * @description bean map 转换工具类
 * @package com.hoomoomoo.fims.app.util
 * @date 2019/08/08
 */

public class BeanMapUtils {

    /**
     * bean 转换成 map
     *
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap(16);
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(String.valueOf(key), beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * bean 转换成 map
     *
     * @param beanList
     * @param <T>
     * @return
     */
    public static <T> List<Map<String, Object>> beanToMap(List<T> beanList) {
        List<Map<String, Object>> list = new ArrayList(16);
        if (beanList != null && beanList.size() > 0) {
            Map<String, Object> map = null;
            for (int i = 0, size = beanList.size(); i < size; i++) {
                T bean = beanList.get(i);
                map = beanToMap(bean);
                list.add(map);
            }
        }
        return list;
    }

    /**
     * map 转换成 bean
     *
     * @param map
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> T mapToBean(Map<String, Object> map, T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    /**
     * map 转换成 bean
     *
     * @param map
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T mapToBean(Map<String, Object> map, Class<T> clazz) throws Exception{
        return mapToBean(map, clazz.newInstance());
    }

    /**
     * map 转换成 bean
     *
     * @param maps
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List mapToBean(List<Map<String, Object>> maps, Class<T> clazz) throws Exception{
        List list = new ArrayList<>();
        if (maps != null && maps.size() > 0) {
            Map<String, Object> map = null;
            for (int i = 0, size = maps.size(); i < size; i++) {
                map = maps.get(i);
                T bean = clazz.newInstance();
                mapToBean(map, bean);
                list.add(bean);
            }
        }
        return list;
    }

    /**
     * map 转换成 HashMap
     *
     * @param map
     * @return
     */
    public static HashMap mapToHashMap(Map map){
        if(map == null || map.isEmpty()){
            return null;
        }
        HashMap hashMap = new HashMap(16);
        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        while(iterator.hasNext()){
            Object key = iterator.next();
            Object value = map.get(key);
            hashMap.put(key, value);
        }
        return hashMap;
    }
}
