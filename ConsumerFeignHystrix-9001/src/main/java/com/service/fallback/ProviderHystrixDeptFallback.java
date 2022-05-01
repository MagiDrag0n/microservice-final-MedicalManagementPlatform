package com.service.fallback;

import com.CommonResult;
import com.entities.Dept;
import com.service.ProviderHystrixDept;

public class ProviderHystrixDeptFallback implements ProviderHystrixDept {
    @Override
    public CommonResult initDept(Dept dept) {
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }

    @Override
    public CommonResult getDept(Long id) {
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }

    @Override
    public CommonResult updateDept(Dept dept) {
        return new CommonResult(400,"服务正忙，请稍后再试。",null);
    }
}
