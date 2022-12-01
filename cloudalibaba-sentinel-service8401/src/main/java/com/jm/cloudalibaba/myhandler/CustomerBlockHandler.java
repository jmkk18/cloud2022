package com.jm.cloudalibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jm.springcloud.entities.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信CustomerBlockHandler---1");
    }
    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信CustomerBlockHandler---2");
    }
}
