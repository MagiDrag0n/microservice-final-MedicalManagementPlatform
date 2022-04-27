package com.controller;

import com.CommonResult;
import com.entities.DTO.MedicineOrder;
import com.entities.Order;
import com.service.OrderProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "order")
@Slf4j
public class OrderProviderController {
    @Resource
    private OrderProviderService orderProviderService;

    @RequestMapping("/createOrder")
    public CommonResult createOrder(@RequestBody Order order){
        int result = orderProviderService.createOrder(order);
        log.info("*****插入结果:"+ result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功。", result);
        }else{
            return new CommonResult(400,"插入数据失败。", null);
        }
    }

    @GetMapping(value = "/getOrder/{id}")
    public CommonResult getOrder(@PathVariable("id") Long id){
        List<Order> order = orderProviderService.getOrder(id);
        log.info("*****查询结果：{order}");
        if(order != null){
            log.info(String.valueOf(order));
            return new CommonResult(200,"查询数据成功。", order);
        }else{
            return new CommonResult(400,"查询数据失败。", null);
        }
    }

    @GetMapping("/deleteOrder/{id}")
    public CommonResult deleteOrder(@PathVariable("id") Long id){
        int result = orderProviderService.deleteOrder(id);
        log.info("*****删除结果：{result}");
        if(result > 0){
            return new CommonResult(200,"失效数据成功。", result);
        }else {
            return new CommonResult(400,"失效数据失败。", result);
        }
    }
}
