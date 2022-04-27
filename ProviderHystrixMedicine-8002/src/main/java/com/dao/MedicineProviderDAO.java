package com.dao;

import com.entities.Medicine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MedicineProviderDAO {
    public int addMedicine(Medicine medicine);
    public Medicine getMedicine(@Param("id") Long id);
    public int updateMedicine(Medicine medicine);
    public int deleteMedicine(@Param("id") Long id);
}
