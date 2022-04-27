package com.service;

import com.entities.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DoctorProviderService {
    public int empDoctor(Doctor doctor);
    public List<Doctor> getDoctor(@Param("id") Long id);
    public int updateDoctor(Doctor doctor);
    public int ueDoctor(@Param("id") Long id);
}
