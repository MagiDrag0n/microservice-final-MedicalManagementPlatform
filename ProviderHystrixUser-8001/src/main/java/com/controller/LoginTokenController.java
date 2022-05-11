package com.controller;

import com.CommonResult;
import com.entities.User;
import com.service.UserProviderService;
import com.util.jwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping(value = "user")
public class LoginTokenController {
    @Resource
    private UserProviderService userProviderService;
    @PostMapping("/login")
    public CommonResult login(@RequestBody User user){
        log.info("Received Login Requirement.");
        Long id = user.getId();
        log.info(String.valueOf(id));
        User vari_user = userProviderService.getUser(id);
        log.info(String.valueOf(vari_user));
        if(vari_user != null){
            log.info(String.valueOf(user));
            if(vari_user.getId().equals(user.getId()) && vari_user.getName().equals(user.getName())){
                //添加token
                log.info("AC JWT Token");
                user.setToken(jwt.createToken());
                return new CommonResult(200,"颁发JWT Token。",user);
            }
        }
        return null;
    }

    @PostMapping("/checkToken")
    public Boolean checkToken(@RequestHeader(value = "token") String token){
        log.info("CHECKED JWT Token");
        return jwt.checkToken(token);
    }
}
