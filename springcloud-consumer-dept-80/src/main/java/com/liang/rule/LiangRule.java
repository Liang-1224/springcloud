package com.liang.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName LiangRule
 * @Description TODO
 * @Author WORK_LJG
 * @Date 2021/4/1 20:26
 * @Version 1.0
 */
@Configuration
public class LiangRule {
    @Bean
    public IRule myRule() {
        return new LiangRandomRule();
    }
}
