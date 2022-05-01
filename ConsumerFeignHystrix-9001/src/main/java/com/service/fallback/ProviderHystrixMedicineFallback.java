package com.service.fallback;

import com.CommonResult;
import com.entities.Medicine;
import com.service.ProviderHystrixMedicine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProviderHystrixMedicineFallback implements ProviderHystrixMedicine {
    @Override
    public CommonResult addMedicine(Medicine medicine) {
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }

    @Override
    public CommonResult getMedicine(Long id) {
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }

    @Override
    public CommonResult updateMedicine(Medicine medicine) {
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }

    @Override
    public CommonResult deleteMedicine(Long id) {
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }
}
