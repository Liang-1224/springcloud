package com.liang.springcloud.service;

import com.liang.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @ClassName DeptClientServer
 * @Description TODO
 * @Author WORK_LJG
 * @Date 2021/4/1 20:58
 * @Version 1.0
 */
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT", fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientServer {
    @GetMapping("/dept/{id}")
    Dept get(@PathVariable("id")Long id);
    @PostMapping("/dept/add")
    boolean addDept(Dept dept);
    @GetMapping("/depts")
    List<Dept> getDepts();

}
