package com.service;

import com.dao.UserProviderDAO;
import com.entities.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProviderServiceImpl implements ProviderService{
    @Resource
    private UserProviderDAO userProviderDAO;

    @Override
    public int regisUser(User user) {
        return userProviderDAO.regisUser(user);
    }

    @Override
    public User getUser(Long id) {
        return userProviderDAO.getUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userProviderDAO.updateUser(user);
    }
}
