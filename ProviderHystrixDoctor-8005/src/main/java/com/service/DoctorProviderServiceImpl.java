package com.service;

import com.dao.DoctorProviderDAO;
import com.entities.Doctor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DoctorProviderServiceImpl implements DoctorProviderService{
    @Resource
    private DoctorProviderDAO doctorProviderDAO;

    @Override
    public int empDoctor(Doctor doctor) {
        return doctorProviderDAO.empDoctor(doctor);
    }

    @Override
    public Doctor getDoctor(Long id) {
        return doctorProviderDAO.getDoctor(id);
    }

    @Override
    public int updateDoctor(Doctor doctor) {
        return doctorProviderDAO.updateDoctor(doctor);
    }

    @Override
    public int ueDoctor(Long id) {
        return doctorProviderDAO.ueDoctor(id);
    }
}
