package com.shijw.back.web.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin//跨域访问
@RequestMapping("/back/health")
@Api(tags = "Health-Check-Controller", description = "后台管理系统-健康检查")
public class HealthCheckController {

    @GetMapping(value = "/check")
    public String healthCheck() {
        return "{\"data\":\"健康检查-success\"}";
    }
}