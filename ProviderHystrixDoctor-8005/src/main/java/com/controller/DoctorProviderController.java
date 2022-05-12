package com.controller;

import com.CommonResult;
import com.entities.Doctor;
import com.service.DoctorProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "doctor")
@Slf4j
public class DoctorProviderController {
    @Resource
    private DoctorProviderService doctorProviderService;

    @RequestMapping(value = "/empDoctor")
    public CommonResult empDoctor(@RequestBody Doctor doctor){
        int result = doctorProviderService.empDoctor(doctor);
        log.info("*****插入结果：{result}");
        if(result > 0 ){
            return new CommonResult(200,"插入数据成功",result);
        }else {
            return new CommonResult(400,"插入数据失败",null);
        }
    }

    @GetMapping(value = "/getDoctor/{id}")
    public CommonResult getDoctor(@PathVariable("id") Long id){
        List<Doctor> doctor = doctorProviderService.getDoctor(id);
        log.info("*****查询结果：{doctor}");
        if(doctor != null){
            return new CommonResult(200,"查询数据成功",doctor);
        }else {
            return new CommonResult(400,"无记录",null);
        }
    }

    @RequestMapping(value = "/updateDoctor")
    public CommonResult updateDoctor(@RequestBody Doctor doctor){
        int result = doctorProviderService.updateDoctor(doctor);
        log.info("*****更新结果：{result}");
        if(result > 0 ){
            return new CommonResult(200,"更新数据成功",result);
        }else {
            return new CommonResult(400,"更新数据失败",null);
        }
    }

    @RequestMapping(value = "/ueDoctor/{id}")
    public CommonResult ueDoctor(@PathVariable("id") Long id) {
        int result = doctorProviderService.ueDoctor(id);
        log.info("*****删除结果：{result}");
        if (result > 0) {
            return new CommonResult(200, "删除数据成功", result);
        } else {
            return new CommonResult(400, "删除数据失败", null);
        }
    }
}
