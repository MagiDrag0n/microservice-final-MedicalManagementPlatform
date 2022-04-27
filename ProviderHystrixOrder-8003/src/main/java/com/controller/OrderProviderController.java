package com.controller;

import com.service.OrderProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "order")
@Slf4j
public class OrderProviderController {
    @Resource
    private OrderProviderService orderProviderService;


}
