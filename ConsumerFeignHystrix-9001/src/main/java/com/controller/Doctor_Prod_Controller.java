package com.controller;

import com.CommonResult;
import com.entities.Doctor;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.service.ProviderHystrixDoctor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "me")
@Slf4j
@DefaultProperties(defaultFallback = "ProviderHystrixDoctorFallback", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  // 开启熔断器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  // 当请求达到这个数量之后，才进行错误占比的计算。
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),  // 半打开休眠时间，熔断之后过了这段休眠时间，就会半打开，尝试接口是否恢复，如果恢复就完全打开熔断器。
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
})
public class Doctor_Prod_Controller {
    @Resource
    private ProviderHystrixDoctor providerHystrixDoctor;

    @RequestMapping(value = "/empDoctor")
    public CommonResult empDoctor_prod(@RequestBody Doctor doctor){
        return providerHystrixDoctor.empDoctor(doctor);
    }

    @GetMapping(value = "/getDoctor/{id}")
    public CommonResult getDoctor_prod(@PathVariable("id") Long id){
        return providerHystrixDoctor.getDoctor(id);
    }

    @RequestMapping(value = "/updateDoctor")
    public CommonResult updateDoctor_prod(@RequestBody Doctor doctor){
        return providerHystrixDoctor.updateDoctor(doctor);
    }

    @RequestMapping(value = "/ueDoctor/{id}")
    public CommonResult ueDoctor_prod(@PathVariable("id") Long id){
        return providerHystrixDoctor.ueDoctor(id);
    }
}
