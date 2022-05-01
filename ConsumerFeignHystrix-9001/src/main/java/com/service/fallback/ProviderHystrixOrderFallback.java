package com.service.fallback;

import com.CommonResult;
import com.entities.Order;
import com.service.ProviderHystrixOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProviderHystrixOrderFallback implements ProviderHystrixOrder {

    @Override
    public CommonResult createOrder(Order Order) {
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }

    @Override
    public CommonResult getOrder(Long id) {
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }

    @Override
    public CommonResult deleteOrder(Long id) {
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }
}
