package com.shijw.front.utils;

/**
 * @author SHI
 * @date 2023/5/21 13:55
 */
public class CalculateUtils {

    public static double getDoubleFromObjectWithDefault(Object number) {
        return number == null || number == "" ? 0.0 : Double.parseDouble(String.valueOf(number));
    }
}
