package com.jm.cloudalibaba.service;

import com.jm.springcloud.entities.CommonResult;
import com.jm.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,----PaymentFallbackService",
                new Payment(id, "errorSerial......"));
    }

}
