
package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.database.DataBase;
import com.travelcompany.eshop.exception.BadRequestException;
import com.travelcompany.eshop.exception.ResourceNotFoundException;
import com.travelcompany.eshop.model.Order;
import com.travelcompany.eshop.repository.AbstractRepository;
import com.travelcompany.eshop.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrderRepositoryImpl extends AbstractRepository<Order> implements OrderRepository {

    // convert entitySet to List for queries (GET)
    List<Order> orderList = new ArrayList<>(getEntitySet());

    @Override
    protected Set<Order> getEntitySet() {
        return DataBase.getInstance().getOrders();
    }
    @Override
    public Order findById(Long id) {
        
        return orderList.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(getEntity() + " with that id " + id + "was not found"));
    }
    
    public List<Order> getAll() {
        
       return orderList;
    }

    public Order addOrder(Order order) throws BadRequestException {

        if(!getEntitySet().contains(order)) {
            getEntitySet().add(order);
            return order;
        }
        throw new BadRequestException("Order already exists");
    }


}
    
    

