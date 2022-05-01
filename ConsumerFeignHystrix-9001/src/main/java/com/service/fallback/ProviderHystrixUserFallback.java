package com.service.fallback;

import com.CommonResult;
import com.service.ProviderHystrixUser;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProviderHystrixUserFallback implements FallbackFactory<ProviderHystrixUser> {
    @Override
    public ProviderHystrixUser create(Throwable cause) {
        return (ProviderHystrixUser) new CommonResult<ProviderHystrixUser>(400,"服务正忙，请稍后重试。",null);
    }
}
