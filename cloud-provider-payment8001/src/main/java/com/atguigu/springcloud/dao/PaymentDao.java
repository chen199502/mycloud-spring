package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangchen on 2021/1/27 14:44
 */
@Mapper
//@Repository
public interface PaymentDao {
     int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
