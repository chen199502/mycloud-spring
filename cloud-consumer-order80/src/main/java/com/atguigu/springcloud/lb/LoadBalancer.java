package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Created by zhangchen on 2021/1/28 20:22
 */
/*
* 自定义负载均衡接口*/
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
