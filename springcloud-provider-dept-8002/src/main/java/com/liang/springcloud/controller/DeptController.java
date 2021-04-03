package com.liang.springcloud.controller;

import com.liang.springcloud.pojo.Dept;
import com.liang.springcloud.service.DeptService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController {
    @Resource
    private DeptService deptService;

    /**
     * 获取一些配置的信息，的到具体的微服务
     */
    @Resource
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }
    @GetMapping("/dept/{id}")
    public Dept queryDept(@PathVariable("id")Long id){
        return deptService.queryById(id);
    }
    @GetMapping("depts")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }
    @GetMapping("/dept/discovery")
    public Object discovery() {
        // 获取微服务列表清单
        List<String> services = client.getServices();
        // 得到一个具体的微服务信息，通过具体的微服务id，application name
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getPort()
            );
        }
        return this.client;
    }
}
