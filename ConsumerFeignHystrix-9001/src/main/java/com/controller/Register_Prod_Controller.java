package com.controller;

import com.CommonResult;
import com.entities.Register;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.service.ProviderHystrixRegister;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "register")
@Slf4j
@DefaultProperties(defaultFallback = "ProviderHystrixRegisterFallback", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  // 开启熔断器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  // 当请求达到这个数量之后，才进行错误占比的计算。
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),  // 半打开休眠时间，熔断之后过了这段休眠时间，就会半打开，尝试接口是否恢复，如果恢复就完全打开熔断器。
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
})
public class Register_Prod_Controller {
    @Resource
    private ProviderHystrixRegister providerHystrixRegister;

    @RequestMapping(value = "/signRegister")
    public CommonResult signRegister_prod(@RequestBody Register register){
        return  providerHystrixRegister.signRegister(register);
    }

    @GetMapping(value = "/getRegister/{id}")
    public CommonResult getRegister_prod(@PathVariable("id") Long id){
        return providerHystrixRegister.getRegister(id);
    }
}
