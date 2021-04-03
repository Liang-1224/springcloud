package com.liang.springcloud.controller;

import com.liang.springcloud.pojo.Dept;
import com.liang.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DeptController {
    @Resource
    private DeptService deptService;

    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/{id}")
    public Dept queryDept(@PathVariable("id")Long id){
        Dept dept = deptService.queryById(id);
        if (dept == null) {
            throw new RuntimeException("id=>" + id + ", 不存在该用户，或者信息无法找到");
        }
        return dept;
    }

    public Dept hystrixGet(@PathVariable("id")Long id){
        return new Dept().setDeptno(id).setDname("id=>" + id + "没有对应信息，我是hystrix~").setDb_source("no database");
    }

}
