package com.service.fallback;

import com.CommonResult;
import com.entities.User;
import com.service.ProviderHystrixUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProviderHystrixUserFallback implements ProviderHystrixUser {
    @Override
    public CommonResult regisUser(User user) {
        log.info("*****触发服务降级。");
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }

    @Override
    public CommonResult getUser(Long id) {
        log.info("*****触发服务降级。");
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }

    @Override
    public CommonResult updateUser(User user) {
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }
}
