package com.controller;

import com.CommonResult;
import com.entities.Medicine;
import com.service.MedicineProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("medicine")
@Slf4j
public class MedicineProviderController {
    @Resource
    private MedicineProviderService medicineProviderService;

    @RequestMapping("/addMedicine")
    public CommonResult addMedicine(@RequestBody Medicine medicine){
        int result = medicineProviderService.addMedicine(medicine);
        log.info("*****插入结果:"+ result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功。", result);
        }else{
            return new CommonResult(400,"插入数据失败。", null);
        }
    }

    @GetMapping(value = "/getMedicine/{id}")
    public CommonResult getMedicine(@PathVariable("id") Long id){
        Medicine medicine = medicineProviderService.getMedicine(id);
        log.info("*****查询结果：{medicine}");
        if(medicine != null){
            return new CommonResult(200,"查询数据成功。", medicine);
        }else{
            return new CommonResult(400,"查询数据失败。", null);
        }
    }

    @RequestMapping(value = "/updateMedicine")
    public CommonResult updateMedicine(@RequestBody Medicine medicine){
        int result = medicineProviderService.updateMedicine(medicine);
        log.info("*****更新结果：{result}");
        if(result > 0){
            return new CommonResult(200,"更新数据成功。", result);
        }else {
            return new CommonResult(400,"更新数据失败。", result);
        }
    }

    @GetMapping("/deleteMedicine/{id}")
    public CommonResult deleteMedicine(@PathVariable("id") Long id){
        int result = medicineProviderService.deleteMedicine(id);
        log.info("*****删除结果：{result}");
        if(result > 0){
            return new CommonResult(200,"删除数据成功。", result);
        }else {
            return new CommonResult(400,"删除数据失败。", result);
        }
    }
}
