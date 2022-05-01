package com.controller;

import com.CommonResult;
import com.entities.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.service.ProviderHystrixUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "me")
@Slf4j
@DefaultProperties(defaultFallback = "ProviderHystrixUserFallback", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  // 开启熔断器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  // 当请求达到这个数量之后，才进行错误占比的计算。
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),  // 半打开休眠时间，熔断之后过了这段休眠时间，就会半打开，尝试接口是否恢复，如果恢复就完全打开熔断器。
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
})
public class User_Prod_Controller {
    @Resource
    private ProviderHystrixUser providerHystrixUser;

    @GetMapping(value = "/getUser/{id}")
    public CommonResult getUser_prod(@PathVariable("id") Long id){
        return providerHystrixUser.getUser(id);
    }

    @RequestMapping(value = "/updateUser")
    public CommonResult updateUser_prod(@RequestBody User user){
        return providerHystrixUser.updateUser(user);
    }

    @RequestMapping(value = "/regisUser")
    public CommonResult regisUser(@RequestBody User user){
        return providerHystrixUser.regisUser(user);
    }
}
