package com.shijw.back.utils;

/**
 * @author SHI
 * @date 2023/4/10 16:12
 */
public class ObjectUtils {
    /**
     * 判断一个对象是否是基本类型或基本类型的封装类型
     */
    public static boolean isPrimitive(Object obj) {
        try {
            return ((Class<?>) obj.getClass().getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
            return false;
        }
    }
}
