package com.controller;

import com.CommonResult;
import com.service.ProviderHystrixUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "me")
@Slf4j
public class User_Prod_Controller {
    @Resource
    private ProviderHystrixUser providerHystrixUser;

    @GetMapping(value = "/getUser/{id}")
    public CommonResult getUser_prod(@PathVariable("id") Long id){
        return providerHystrixUser.getUser_OK(id);
    }

}
