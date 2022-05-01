package com.service;

import com.CommonResult;
import com.entities.Medicine;
import com.service.fallback.ProviderHystrixMedicineFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "PROVIDER-HYSTRIX-MEDICINE-8002", fallback = ProviderHystrixMedicineFallback.class)
public interface ProviderHystrixMedicine {
    @RequestMapping(value = "/medicine/addMedicine")
    CommonResult addMedicine(@RequestBody Medicine medicine);

    @GetMapping(value = "/medicine/getMedicine/{id}")
    CommonResult getMedicine(@PathVariable("id") Long id);

    @RequestMapping(value = "/medicine/updateMedicine")
    CommonResult updateMedicine(@RequestBody Medicine medicine);

    @GetMapping(value = "/medicine/deleteMedicine")
    CommonResult deleteMedicine(@PathVariable("id") Long id);
}
