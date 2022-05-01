package com.service;

import com.CommonResult;
import com.entities.Order;
import com.service.fallback.ProviderHystrixOrderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "PROVIDER-HYSTRIX-ORDER-8003", fallback = ProviderHystrixOrderFallback.class)
public interface ProviderHystrixOrder {
    @RequestMapping(value = "/order/createOrder")
    CommonResult createOrder(@RequestBody Order Order);

    @GetMapping(value = "/order/getOrder/{id}")
    CommonResult getOrder(@PathVariable("id") Long id);

    @GetMapping(value = "/order/deleteOrder/{id}")
    CommonResult deleteOrder(@PathVariable("id") Long id);
}
