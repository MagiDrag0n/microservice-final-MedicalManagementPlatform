package com.service.fallback;

import com.CommonResult;
import com.entities.Register;
import com.service.ProviderHystrixRegister;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProviderHystrixRegisterFallback implements ProviderHystrixRegister {
    @Override
    public CommonResult signRegister(Register register) {
        log.info("*****触发服务降级。");
        return new CommonResult(400, "服务正忙，请稍后再试。", null);
    }

    @Override
    public CommonResult getRegister(Long id) {
        log.info("*****触发服务降级。");
        return new CommonResult(400, "服务正忙，请稍后再试。", null);
    }
}
