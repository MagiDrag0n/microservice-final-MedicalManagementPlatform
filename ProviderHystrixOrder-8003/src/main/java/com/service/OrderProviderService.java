package com.service;

import com.entities.DTO.MedicineOrder;
import com.entities.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderProviderService {
    public int createOrder(Order order);
    public List<Order> getOrder(@Param("id") Long id);
    //    public int updateOrder(Order order);
//    开药订单不应修改，确实要修改则作废重新开单。
    public int deleteOrder(@Param("id") Long id);
}
