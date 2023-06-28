package com.shijw.front.aop.annotation;


import java.lang.annotation.*;

/**
 * @author SHI
 * @date 2023/4/6 23:30
 * 部分操作前，需进行身份验证
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginValid {

    /**
     * 是否开启登录验证（默认开启）
     */
    boolean loginValid() default true;

    /**
     * 是否开启身份验证（默认关闭）
     * <p>
     * 注：开启身份验证的方法需包含 universityId 参数
     */
    boolean identityValid() default false;

    /**
     * 开启身份验证后的最低身份要求
     * <p>
     * (系统管理员 : 0 , 学校管理员 : 1 ,暂未绑定管理员身份 : 2)
     */
    int lowestIdentity() default 2;
}
