package com.service;

import com.dao.RegisterProviderDAO;
import com.entities.Register;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisterProviderServiceImpl implements RegisterProviderService{
    @Resource
    private RegisterProviderDAO registerProviderDAO;

    @Override
    public int signRegister(Register register) {
        return registerProviderDAO.signRegister(register);
    }

    @Override
    public Register getRegister(Long id) {
        return registerProviderDAO.getRegister(id);
    }
}
