package com.service;

import com.CommonResult;
import com.entities.User;
import com.service.fallback.ProviderHystrixUserFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "PROVIDER-HYSTRIX-USER-8001", fallback = ProviderHystrixUserFallback.class)
public interface ProviderHystrixUser {
    @RequestMapping(value = "/user/regisUser")
    CommonResult regisUser(@RequestBody User user);

    @GetMapping(value = "/user/getUser/{id}")
    CommonResult getUser(@PathVariable("id") Long id);

    @RequestMapping(value = "/user/updateUser")
    CommonResult updateUser(@RequestBody User user);

}
