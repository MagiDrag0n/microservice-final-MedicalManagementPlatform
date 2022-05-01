package com.service;

import com.CommonResult;
import com.entities.Doctor;
import com.service.fallback.ProviderHystrixDoctorFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "PROVIDER-HYSTRIX-DOCTOR-8005", fallback = ProviderHystrixDoctorFallback.class)
public interface ProviderHystrixDoctor {
    @RequestMapping(value = "/doctor/empDoctor")
    CommonResult empDoctor(@RequestBody Doctor doctor);

    @GetMapping(value = "/doctor/getDoctor/{id}")
    CommonResult getDoctor(@PathVariable("id") Long id);

    @RequestMapping(value = "/doctor/updateDoctor")
    CommonResult updateDoctor(@RequestBody Doctor doctor);

    @RequestMapping(value = "/doctor/ueDoctor/{id}")
    CommonResult ueDoctor(@PathVariable("id") Long id);
}
