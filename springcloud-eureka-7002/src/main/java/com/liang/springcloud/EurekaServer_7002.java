package com.liang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaServer_7001
 * @Description TODO
 * @Author WORK_LJG
 * @Date 2021/3/26 21:21
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer // 表示为服务端启动类，可以接收注册
public class EurekaServer_7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7002.class, args);
    }
}