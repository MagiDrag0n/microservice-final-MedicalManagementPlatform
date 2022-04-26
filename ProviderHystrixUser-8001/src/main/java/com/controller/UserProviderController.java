package com.controller;

import com.CommonResult;
import com.entities.User;
import com.service.UserProviderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("provider")
public class UserProviderController {
    @Resource
    private UserProviderService userProviderService;

//    @Value("${server.port}")
//    private String serverPort;

    @RequestMapping(value = "/regisUser")
    public CommonResult regisUser(@RequestBody User user){
        int result = userProviderService.regisUser(user);
//        log.info("*****插入结果:"+ result);
//        log4j ???
        if(result > 0) {
            return new CommonResult(200,"插入数据成功。" + result);
        }else{
            return new CommonResult(400,"插入数据失败",null);
        }
    }

    @GetMapping(value = "/getUser/{id}")
    public CommonResult getUser(@PathVariable("id") Long id){
        User user = userProviderService.getUser(id);
//        log.info("*****插入结果：{payment}");
        if (user != null) {
            return new CommonResult(200,"查询成功",user);
        } else {
            return new CommonResult(444, "无记录");
        }
    }

    @RequestMapping(value = "/updateUser")
    public CommonResult updateUser(@RequestBody User user){
        int result = userProviderService.updateUser(user);
        //        log.info("*****插入结果:"+ result);
        if(result > 0) {
            return new CommonResult(200,"插入数据成功。" + result);
        }else{
            return new CommonResult(400,"插入数据失败",null);
        }
    }
}
