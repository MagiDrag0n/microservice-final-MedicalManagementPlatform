package com.service.fallback;

import com.CommonResult;
import com.entities.Doctor;
import com.service.ProviderHystrixDoctor;
import org.springframework.stereotype.Component;

@Component
public class ProviderHystrixDoctorFallback implements ProviderHystrixDoctor {
    @Override
    public CommonResult empDoctor(Doctor doctor) {
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }

    @Override
    public CommonResult getDoctor(Long id) {
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }

    @Override
    public CommonResult updateDoctor(Doctor doctor) {
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }

    @Override
    public CommonResult ueDoctor(Long id) {
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }
}
