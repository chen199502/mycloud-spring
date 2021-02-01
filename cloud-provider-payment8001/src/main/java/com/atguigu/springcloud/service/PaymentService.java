package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Payment;

/**
 * Created by zhangchen on 2021/1/27 15:21
 */
public interface PaymentService {
    public int create(Payment payment); //写

    public Payment getPaymentById(Long id);  //读取

}
