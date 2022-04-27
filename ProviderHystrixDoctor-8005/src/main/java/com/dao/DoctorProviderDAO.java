package com.dao;

import com.entities.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DoctorProviderDAO {
    public int empDoctor(Doctor doctor);
    public Doctor getDoctor(@Param("id") Long id);
    public int updateDoctor(Doctor doctor);
    public int ueDoctor(@Param("id") Long id);
}
