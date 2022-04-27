package com.service;

import com.entities.Doctor;
import org.apache.ibatis.annotations.Param;

public interface DoctorProviderService {
    public int empDoctor(Doctor doctor);
    public Doctor getDoctor(@Param("id") Long id);
    public int updateDoctor(Doctor doctor);
    public int ueDoctor(@Param("id") Long id);
}
