package com.service;

import com.dao.DeptProviderDAO;
import com.entities.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeptProviderServiceImpl implements DeptProviderService{
    @Resource
    private DeptProviderDAO deptProviderDAO;

    @Override
    public int initDept(Dept dept) {
        return deptProviderDAO.initDept(dept);
    }

    @Override
    public Dept getDept(Long id) {
        return deptProviderDAO.getDept(id);
    }

    @Override
    public int updateDept(Dept dept) {
        return deptProviderDAO.updateDept(dept);
    }
}
