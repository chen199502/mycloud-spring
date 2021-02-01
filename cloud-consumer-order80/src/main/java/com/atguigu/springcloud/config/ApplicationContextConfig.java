package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhangchen on 2021/1/27 16:33
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
//    @LoadBalanced    //取消注解，改为手写
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
