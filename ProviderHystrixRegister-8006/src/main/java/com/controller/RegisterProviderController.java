package com.controller;

import com.CommonResult;
import com.entities.Register;
import com.service.RegisterProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "register")
@Slf4j
public class RegisterProviderController {
    @Resource
    private RegisterProviderService registerProviderService;

    @RequestMapping(value = "/signRegister")
    public CommonResult signRegister(@RequestBody Register register){
        int result = registerProviderService.signRegister(register);
        log.info("*****插入结果:"+result);
        if(result > 0) {
            return new CommonResult(200,"插入数据成功。", result);
        }else{
            return new CommonResult(400,"插入数据失败", null);
        }
    }

    @GetMapping(value = "/getRegister/{id}")
    public CommonResult getRegister(@PathVariable("id") Long id){
        Register register = registerProviderService.getRegister(id);
        log.info("*****查询结果：{register}");
        if (register != null) {
            return new CommonResult(200,"查询成功", register);
        } else {
            return new CommonResult(400, "无记录", null);
        }
    }
}
