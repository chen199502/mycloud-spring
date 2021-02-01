package com.atguigu.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangchen on 2021/1/29 9:23
 */
@Component
@Slf4j
public class MyLB implements LoadBalancer {

    //定义一个原子整数，用来存储当前访问次数  里面有volatile int value; 将值暴露
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //坐标  更改访问次数，原子操作
    private final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));  //第一个参数是期望值，第二个参数是修改值是
        log.info("*******第几次访问，次数next: "+next);
        return next;
    }

    /*
    * 每次访问时调用更改访问次数的方法。返回一个服务器。*/
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {  //得到机器的列表
        int index = getAndIncrement() % serviceInstances.size(); //得到服务器的下标位置
        return serviceInstances.get(index);
    }

}
