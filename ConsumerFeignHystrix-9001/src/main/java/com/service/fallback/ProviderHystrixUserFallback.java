package com.service.fallback;

import com.CommonResult;
import com.entities.User;
import com.service.ProviderHystrixUser;
import org.springframework.stereotype.Component;

@Component
public class ProviderHystrixUserFallback implements ProviderHystrixUser {
    @Override
    public CommonResult regisUser_OK(User user) {
        return null;
    }

    @Override
    public CommonResult getUser_OK(Long id) {
        return null;
    }
}
