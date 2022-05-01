package com.service;

import com.CommonResult;
import com.entities.Register;
import com.service.fallback.ProviderHystrixRegisterFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "PROVIDER-HYSTRIX-REGISTER-8006",fallback = ProviderHystrixRegisterFallback.class)
public interface ProviderHystrixRegister {
    @RequestMapping(value = "/register/signRegister")
    CommonResult signRegister(@RequestBody Register register);

    @GetMapping(value = "/register/getRegister/{id}")
    CommonResult getRegister(@PathVariable("id") Long id);
}
