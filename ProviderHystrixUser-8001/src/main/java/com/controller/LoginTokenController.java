package com.controller;

import com.entities.User;
import com.util.jwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@CrossOrigin
public class LoginTokenController {
    private final Long id = Long.valueOf(441900);
    private final String name = "magi";

    @GetMapping("/login")
    public User login(User user){
        log.info(String.valueOf(user));
        if(id.equals(user.getId()) && name.equals(user.getName())){
            //添加token
            log.info("!@ACCEPT JWT");
            user.setToken(jwt.createToken());
            return user;
        }
        return null;
    }

    @GetMapping("/checkToken")
    public Boolean checkToken(HttpServletRequest request){
        log.info("AC REQUEST");
        String token = request.getHeader("token");
        return jwt.checkToken(token);
    }
}
