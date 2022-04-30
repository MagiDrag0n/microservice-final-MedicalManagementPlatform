package com.service;

import com.entities.Register;
import org.apache.ibatis.annotations.Param;

public interface RegisterProviderService {
    public int signRegister(Register register);
    public Register getRegister(@Param("id") Long id);
}
