package com.liang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// 启动类
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient // 可被发现
public class ConfigDept_8001 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigDept_8001.class, args);
    }
}
