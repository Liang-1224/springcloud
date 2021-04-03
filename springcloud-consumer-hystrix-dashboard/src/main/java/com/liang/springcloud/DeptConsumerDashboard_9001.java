package com.liang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ClassName DeptConsumerDashboard_9001
 * @Description TODO
 * @Author WORK_LJG
 * @Date 2021/4/3 13:12
 * @Version 1.0
 */
@SpringBootApplication
@EnableHystrixDashboard // 开启依赖
public class DeptConsumerDashboard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashboard_9001.class, args);
    }
}
