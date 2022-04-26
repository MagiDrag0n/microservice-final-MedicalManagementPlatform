package com.dao;
import com.entities.Medicine;
import com.entities.Order;
import com.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface providerDAO {
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
//    开药订单不应修改，确实要修改则作废重新开单
    public int deleteOrder(@Param("id") Long id);
}
