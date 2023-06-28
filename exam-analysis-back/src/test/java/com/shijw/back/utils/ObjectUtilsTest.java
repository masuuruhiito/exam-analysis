package com.shijw.back.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author SHI
 * @date 2023/4/10 16:13
 */
class ObjectUtilsTest {

    @Test
    void isPrimitive() {
        Integer i = new Integer("1");
        String str = new String("111");
        double d = 11.0;
        char c = 'c';

        System.out.println(ObjectUtils.isPrimitive(i));
        System.out.println(ObjectUtils.isPrimitive(str));
        System.out.println(ObjectUtils.isPrimitive(d));
        System.out.println(ObjectUtils.isPrimitive(c));
    }
}