package com.service;

import com.entities.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptProviderService {
    public int initDept(Dept dept);
    public Dept getDept(@Param("id") Long id);
    public int updateDept(Dept dept);
//    public int deleteDept(@Param("id") Long id);
//    医院大概率不会取消某个科室吧？
}
