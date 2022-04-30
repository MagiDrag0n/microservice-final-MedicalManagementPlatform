package com.controller;

import com.service.RegisterProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "register")
@Slf4j
public class RegisterProviderController {
    @Resource
    private RegisterProviderService registerProviderService;
}
