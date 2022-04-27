package com.controller;

import com.CommonResult;
import com.entities.Dept;
import com.service.DeptProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "dept")
@Slf4j
public class DeptProviderController {
    @Resource
    private DeptProviderService deptProviderService;

    @RequestMapping(value = "/initDept")
    public CommonResult initDept(@RequestBody Dept dept){
        int result = deptProviderService.initDept(dept);
        log.info("*****插入结果:"+ result);
        if(result > 0) {
            return new CommonResult(200,"插入数据成功。", result);
        }else{
            return new CommonResult(400,"插入数据失败", null);
        }
    }

    @GetMapping(value = "/getDept/{id}")
    public CommonResult getDept(@PathVariable("id") Long id){
        Dept dept = deptProviderService.getDept(id);
        log.info("*****插入结果：{dept}");
        if (dept != null) {
            return new CommonResult(200,"查询成功", dept);
        } else {
            return new CommonResult(400, "无记录", null);
        }
    }

    @RequestMapping(value = "/updateDept")
    public CommonResult updateDept(@RequestBody Dept dept){
        int result = deptProviderService.updateDept(dept);
        log.info("*****插入结果:"+ result);
        if(result > 0) {
            return new CommonResult(200,"更新数据成功。", result);
        }else{
            return new CommonResult(400,"更新数据失败", null);
        }
    }
}
