package com.liang.springcloud.controller;

import com.liang.springcloud.pojo.Dept;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName DeptConsumerController
 * @Description TODO
 * @Author WORK_LJG
 * @Date 2021/3/26 20:34
 * @Version 1.0
 */
@RestController
public class DeptConsumerController {
    /**
     * 消费者不应该存在service层
     * RestTemplate直接调用远程接口
     */
    @Resource
    private RestTemplate restTemplate;
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @GetMapping("/consumer/dept/{id}")
    public Dept get(@PathVariable("id")Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/" + id, Dept.class);
    }
    @PostMapping("/consumer/dept/add")
    public boolean addDept(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }
    @GetMapping("/consumer/depts")
    public List<Dept> getDepts() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/depts", List.class);
    }
}
