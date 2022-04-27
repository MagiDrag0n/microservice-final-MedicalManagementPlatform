package com.dao;

import com.entities.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderProviderDAO {
    public int createOrder(Order order);
    public List<Order> getOrder(@Param("id") Long id);
    //    public int updateOrder(Order order);
//    开药订单不应修改，确实要修改则作废重新开单。
    public int deleteOrder(@Param("id") Long id);
}
