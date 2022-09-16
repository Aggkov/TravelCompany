
package com.travelcompany.eshop.service.impl;

import com.travelcompany.eshop.model.BaseEntity;
import com.travelcompany.eshop.model.Order;
import com.travelcompany.eshop.repository.JpaRepository;
import com.travelcompany.eshop.repository.OrderRepository;
import com.travelcompany.eshop.repository.impl.OrderRepositoryImpl;
import com.travelcompany.eshop.service.OrderService;
import java.util.List;


public class OrderServiceImpl  implements OrderService {
    
    OrderRepository orderRepository = new OrderRepositoryImpl();
    
    @Override
    public Order findById(Long id) {
        return orderRepository.getById(id);
    }
    
    public List<Order> getAll() {
        
        return orderRepository.findAll();
    }

    public Order addOrder(Order order) {

        return orderRepository.create(order);
    }

    
}
