package com.service;

import com.CommonResult;
import com.entities.Dept;
import com.service.fallback.ProviderHystrixDeptFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "PROVIDER-HYSTRIX-DEPT-8004", fallback = ProviderHystrixDeptFallback.class)
public interface ProviderHystrixDept {
    @RequestMapping(value = "/dept/initDept")
    CommonResult initDept(@RequestBody Dept dept);

    @GetMapping(value = "/dept/getDept/{id}")
    CommonResult getDept(@PathVariable("id") Long id);

    @RequestMapping(value = "/dept/updateDept")
    CommonResult updateDept(@RequestBody Dept dept);
}
