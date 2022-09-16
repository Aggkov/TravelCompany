
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


    @Override
    protected List<Order> getEntityList() {
        return new ArrayList<>(DataBase.getInstance().getOrders());
    }

    @Override
    protected Set<Order> getEntitySet() {
        return DataBase.getInstance().getOrders();
    }

    @Override
    public Order create(Order entity) throws BadRequestException {
        if(!getEntitySet().contains(entity)) {
            getEntitySet().add(entity);
            return entity;
        }
        throw new BadRequestException("Order already exists");
    }


}
    
    

