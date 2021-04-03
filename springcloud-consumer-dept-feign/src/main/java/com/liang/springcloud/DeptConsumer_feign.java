package com.liang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName DeptConsumer_80
 * @Description TODO
 * @Author WORK_LJG
 * @Date 2021/3/26 20:51
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.liang.springcloud"})
public class DeptConsumer_feign {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_feign.class, args);
    }
}
