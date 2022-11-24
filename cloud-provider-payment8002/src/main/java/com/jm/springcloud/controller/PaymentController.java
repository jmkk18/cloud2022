package com.jm.springcloud.controller;

import com.jm.springcloud.entities.CommonResult;
import com.jm.springcloud.entities.Payment;
import com.jm.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "消息插入数据库成功,serverPort:"+serverPort, result);
        } else {
            return new CommonResult(444, "消息插入数据库失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果：" + payment);

        if (payment != null) {
            return new CommonResult(200, "消息查询成功,serverPort:"+serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID：" + id, null);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try{
            //暂停3秒线程
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
