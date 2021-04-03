package com.liang.springcloud;

import com.liang.rule.LiangRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName DeptConsumer_80
 * @Description TODO
 * @Author WORK_LJG
 * @Date 2021/3/26 20:51
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
// 再微服务启动的时候去加载自定义类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = LiangRule.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class, args);
    }
}
