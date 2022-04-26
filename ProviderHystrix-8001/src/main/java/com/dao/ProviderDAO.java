package com.dao;
import com.entities.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProviderDAO {
    public int regisUser(User user);
    public User getUser(@Param("id") Long id);
    public int updateUser(User user);

    public int addMedicine(Medicine medicine);
    public Medicine getMedicine(@Param("id") Long id);
    public int updateMedicine(Medicine medicine);
    public int deleteMedicine(@Param("id") Long id);

    public int createOrder(Order order);
    public Order getOrder(@Param("id") Long id);
//    public int updateOrder(Order order);
//    开药订单不应修改，确实要修改则作废重新开单。
    public int deleteOrder(@Param("id") Long id);

    public int initDept(Dept dept);
    public Dept getDept(@Param("id") Long id);
    public int updateDept(Dept dept);
//    public int deleteDept(@Param("id") Long id);
//    医院大概率不会取消某个科室吧？

    public int empDoctor(Doctor doctor);
    public Doctor getDoctor(@Param("id") Long id);
    public int updateDoctor(Doctor doctor);
    public int ueDoctor(@Param("id") Long id);

    public int signRegister(Register register);
    public Register getRegister(@Param("id") Long id);
//    挂号当日有效，过期无效。换科室、医生只需要重新叫好即可。
}
