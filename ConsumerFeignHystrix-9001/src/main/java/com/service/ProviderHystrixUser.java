package com.service;

import com.CommonResult;
import com.entities.User;
import com.service.fallback.ProviderHystrixUserFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "provider-hystrix-user-8001",contextId = "User", fallbackFactory = ProviderHystrixUserFallback.class)
public interface ProviderHystrixUser {
    @RequestMapping(value = "/user/regisUser")
    CommonResult regisUser_OK(@RequestBody User user);

    @GetMapping(value = "/user/getUser/{id}")
    CommonResult getUser_OK(@PathVariable("id") Long id);
}
