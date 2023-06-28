package com.shijw.front.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author SHI
 * @date 2023/4/9 0:29
 */
@Getter
@Configuration
public class CommonConfig {
    @Value("${jwt.tokenHeader}")
    private String jwtTokenHeader;

    @Value("${jwt.tokenHead}")
    private String jwtTokenHead;

    @Value("${jwt.expiration}")
    private Long expiration;
}
