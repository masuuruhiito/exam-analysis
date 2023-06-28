package com.shijw.front.aop.annotation;

import java.lang.annotation.*;

/**
 * @author SHI
 * @date 2023/4/20 21:06
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelHeaderInfo {
    String name() default "";
    int level() default 0;
}
