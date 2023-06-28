package com.shijw.front.single;


import com.shijw.front.utils.SnowflakeIdUtils;

/**
 * @author SHI
 * @date 2023/4/10 11:24
 */
public class SnowflakeIdSingleton {

    private static volatile SnowflakeIdUtils snowflakeIdUtils;

    public static SnowflakeIdUtils getInstance(){
        if(snowflakeIdUtils==null){
            synchronized (SnowflakeIdSingleton.class) {
                if (snowflakeIdUtils == null) {
                    snowflakeIdUtils = new SnowflakeIdUtils(0, 0);
                }
            }
        }
        return snowflakeIdUtils;
    }

    private SnowflakeIdSingleton() {}
}
