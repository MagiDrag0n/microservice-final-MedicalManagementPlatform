package com.controller;

import com.entities.User;
import com.util.jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayLoginControllerTester {
    private final String id = "441900";
    private final String name = "王喵喵";

    @GetMapping("/login")
    public User login(User user){
        if(id.equals(user.getId()) && name.equals(user.getName())){
            //添加token
            user.setToken(jwt.createToken());
            return user;
        }
        return null;
    }
}
