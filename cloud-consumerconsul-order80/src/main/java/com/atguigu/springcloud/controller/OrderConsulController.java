package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by zhangchen on 2021/1/28 17:13
 */
@RestController
@Slf4j
public class OrderConsulController {

    public static final String INVOME_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String payment (){
        String result = restTemplate.getForObject(INVOME_URL+"/payment/consul",String.class);
        return result;
    }
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("=======");
        return restTemplate.postForObject(INVOME_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(INVOME_URL+"/payment/get/"+id,CommonResult.class);
    }
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(INVOME_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else
        return new CommonResult<>(444,"查询失败") ;
    }
    @GetMapping("/consumer/payment/postForEntity")
    public CommonResult<Payment> create1(Payment payment) {
        return restTemplate.postForEntity(INVOME_URL + "/payment/create", payment, CommonResult.class).getBody();
    }


}

