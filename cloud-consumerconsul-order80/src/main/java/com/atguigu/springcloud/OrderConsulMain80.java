package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by zhangchen on 2021/1/28 17:11
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain80  {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80 .class,args);
    }
}
