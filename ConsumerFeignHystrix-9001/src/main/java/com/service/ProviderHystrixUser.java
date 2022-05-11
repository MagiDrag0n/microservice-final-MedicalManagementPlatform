package com.service;

import com.CommonResult;
import com.entities.User;
import com.service.fallback.ProviderHystrixUserFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@FeignClient(value = "PROVIDER-HYSTRIX-USER-8001", fallback = ProviderHystrixUserFallback.class)
public interface ProviderHystrixUser {
    @RequestMapping(value = "/user/regisUser")
    CommonResult regisUser(@RequestBody User user);

    @GetMapping(value = "/user/getUser/{id}")
    CommonResult getUser(@PathVariable("id") Long id);

    @RequestMapping(value = "/user/updateUser")
    CommonResult updateUser(@RequestBody User user);

    @PostMapping(value = "/user/login")
    CommonResult login(@RequestBody User user);

    @PostMapping(value = "/user/checkToken")
    Boolean checkToken(@RequestHeader(value = "token") String token);

}
