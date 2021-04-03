package com.liang.springcloud.service;

import com.liang.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName DeptClientServiceFallBackFactory
 * @Description TODO
 * @Author WORK_LJG
 * @Date 2021/4/1 22:33
 * @Version 1.0
 */

@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {
    @Override
    public DeptClientServer create(Throwable throwable) {
        return new DeptClientServer() {
            @Override
            public Dept get(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("id=>" + id + "没有对应的信息")
                        .setDb_source("没有数据");
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public List<Dept> getDepts() {
                return null;
            }
        };
    }
}
