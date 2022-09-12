
package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.DataBase.DataBase;
import com.travelcompany.eshop.exception.BadRequestException;
import com.travelcompany.eshop.exception.ResourceNotFoundException;
import com.travelcompany.eshop.model.Order;
import com.travelcompany.eshop.repository.OrderRepository;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    
    DataBase databaseInstance = DataBase.getInstance();
    List<Order> orders = databaseInstance.getOrders();


    @Override
    public Order findById(Long id) {
        
        return orders.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Order with that id " + id + "was not found"));
    }
    
    public List<Order> getAll() {
        
       return orders; 
    }

    public Order addOrder(Order order) throws BadRequestException {

        if(!orders.contains(order)) {
            orders.add(order);
            return order;
        }
        throw new BadRequestException("Order already exists");
    }
    
}    
    
    

