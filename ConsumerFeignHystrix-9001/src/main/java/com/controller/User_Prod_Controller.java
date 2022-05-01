package com.controller;

import com.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.service.ProviderHystrixUser;
import com.service.fallback.ProviderHystrixUserFallback;
import javafx.beans.DefaultProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "me")
@Slf4j
@DefaultProperties(defaultFallback = "ProviderHystrixUserFallback")
public class User_Prod_Controller {
    @Resource
    private ProviderHystrixUser providerHystrixUser;

    @GetMapping(value = "/getUser/{id}")
    public CommonResult getUser_prod(@PathVariable("id") Long id){
        return providerHystrixUser.getUser_OK(id);
    }
}
