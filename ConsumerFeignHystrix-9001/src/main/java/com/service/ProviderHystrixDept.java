package com.service;

import com.service.fallback.ProviderHystrixDeptFallback;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "PROVIDER-HYSTRIX-DEPT-8004", fallback = ProviderHystrixDeptFallback.class)
public interface ProviderHystrixDept {
    @
}
