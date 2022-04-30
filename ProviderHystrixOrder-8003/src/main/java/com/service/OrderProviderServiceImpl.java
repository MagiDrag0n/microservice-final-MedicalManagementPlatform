package com.service;

import com.dao.OrderProviderDAO;
import com.entities.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderProviderServiceImpl implements OrderProviderService{
    @Resource
    private OrderProviderDAO orderProviderDAO;

    @Override
    public int createOrder(Order order) {
        return orderProviderDAO.createOrder(order);
    }

    @Override
    public List<Order> getOrder(Long id) {
        return orderProviderDAO.getOrder(id);
    }

    @Override
    public int deleteOrder(Long id) {
        return orderProviderDAO.deleteOrder(id);
    }
}
