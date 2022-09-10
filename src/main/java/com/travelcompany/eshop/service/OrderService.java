
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Order;
import java.util.List;

public interface OrderService {
    
    Order findById(Long id);
    
    List<Order> getAll();
}
