package com.service;

import com.entities.Medicine;
import org.apache.ibatis.annotations.Param;

public interface MedicineProviderService {
    public int addMedicine(Medicine medicine);
    public Medicine getMedicine(@Param("id") Long id);
    public int updateMedicine(Medicine medicine);
    public int deleteMedicine(@Param("id") Long id);
}
