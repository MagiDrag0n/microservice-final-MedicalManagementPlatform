package com.service;

import com.dao.ProviderDAO;
import com.entities.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProviderServiceImpl implements ProviderService{
    @Resource
    private ProviderDAO providerDAO;

    @Override
    public int regisUser(User user) {
        return providerDAO.regisUser(user);
    }

    @Override
    public User getUser(Long id) {
        return providerDAO.getUser(id);
    }

    @Override
    public int updateUser(User user) {
        return providerDAO.updateUser(user);
    }
}
