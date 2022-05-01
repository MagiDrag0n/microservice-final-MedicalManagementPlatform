package com.service.fallback;

public class ProviderHystrixUserFallback{
    public String GlobalFallback(){
        return "服务正忙，请稍后再试。";
    }
}
