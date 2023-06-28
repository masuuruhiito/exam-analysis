package com.shijw.front.web.controller;

import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@CrossOrigin//跨域访问
@RequestMapping("/front/health")
@Api(tags = "Health-Check-Controller", description = "前台分析系统-健康检查")
public class HealthCheckController {

    @GetMapping(value = "/check")
    public String healthCheck() {
        return "{\"data\":\"健康检查-success\"}";
    }

    @PostMapping(value = "/check/postTest")
    public String postTest(@RequestParam @NotBlank(message = "Name is required") String name) {
        return name;
    }
}