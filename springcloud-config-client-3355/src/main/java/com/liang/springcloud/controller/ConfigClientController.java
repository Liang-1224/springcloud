package com.liang.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaService;
    @Value("${server.port}")
    private String port;

    @GetMapping("/config")
    public String getConfig() {
        return "application:" + applicationName +
                "eurekaService:" + eurekaService +
                "port: " + port;
    }
}
