package com.service;

import com.dao.MedicineProviderDAO;
import com.entities.Medicine;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class MedicineProviderServiceImpl implements MedicineProviderService{
    @Resource
    private MedicineProviderDAO medicineProviderDAO;

    @Override
    public int addMedicine(Medicine medicine) {
        return medicineProviderDAO.addMedicine(medicine);
    }

    @Override
    public Medicine getMedicine(Long id) {
        return medicineProviderDAO.getMedicine(id);
    }

    @Override
    public int updateMedicine(Medicine medicine) {
        return medicineProviderDAO.updateMedicine(medicine);
    }

    @Override
    public int deleteMedicine(Long id) {
        return medicineProviderDAO.deleteMedicine(id);
    }
}
