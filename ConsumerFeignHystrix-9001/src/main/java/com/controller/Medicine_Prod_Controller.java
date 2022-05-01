package com.controller;

import com.CommonResult;
import com.entities.Medicine;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.service.ProviderHystrixMedicine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "me")
@Slf4j
@DefaultProperties(defaultFallback = "ProviderHystrixMedicineFallback", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  // 开启熔断器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  // 当请求达到这个数量之后，才进行错误占比的计算。
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),  // 半打开休眠时间，熔断之后过了这段休眠时间，就会半打开，尝试接口是否恢复，如果恢复就完全打开熔断器。
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
})
public class Medicine_Prod_Controller {
    @Resource
    private ProviderHystrixMedicine providerHystrixMedicine;

    @RequestMapping(value = "/addMedicine")
    public CommonResult addMedicine_prod(@RequestBody Medicine medicine){
        return providerHystrixMedicine.addMedicine(medicine);
    }

    @GetMapping(value = "/getMedicine/{id}")
    public CommonResult getMedicine_prod(@PathVariable("id") Long id){
        return providerHystrixMedicine.getMedicine(id);
    }

    @RequestMapping(value = "/updateMedicine")
    public CommonResult updateMedicine_prod(@RequestBody Medicine medicine){
        return providerHystrixMedicine.updateMedicine(medicine);
    }

    @GetMapping(value = "/deleteMedicine/{id}")
    public CommonResult deleteMedicine_prod(@PathVariable("id") Long id){
        return providerHystrixMedicine.deleteMedicine(id);
    }
}
