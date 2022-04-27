package com.service;

import com.entities.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface OrderProviderService {
    public int createOrder(Order order);
    public Order getOrder(@Param("id") Long id);
    //    public int updateOrder(Order order);
//    开药订单不应修改，确实要修改则作废重新开单。
    public int deleteOrder(@Param("id") Long id);
}
