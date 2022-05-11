package com.service.fallback;

import com.CommonResult;
import com.entities.User;
import com.service.ProviderHystrixUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;

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
        log.info("*****触发服务降级。");
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }

    @Override
    public CommonResult login(User user) {
        log.info(String.valueOf(user));
        log.info("*****触发服务降级。");
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }

    @Override
    public Boolean checkToken(@RequestHeader(value = "token") String token) {
        log.info("*****触发服务降级。");
        return false;
    }
}
