package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.model.Order;
import java.util.List;

public interface OrderRepository {

     Order findById(Long id);
     
     List<Order> getAll();

     Order addOrder(Order order);

}
