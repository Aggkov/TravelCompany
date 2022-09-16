/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.database.DataBase;
import com.travelcompany.eshop.exception.ResourceNotFoundException;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.repository.AbstractRepository;
import com.travelcompany.eshop.repository.PassengerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PassengerRepositoryImpl extends AbstractRepository<Passenger> implements PassengerRepository {


    @Override
    protected List<Passenger> getEntityList() {
        return new ArrayList<>(DataBase.getInstance().getPassengers());
    }
    @Override
    protected Set<Passenger> getEntitySet() {
        return DataBase.getInstance().getPassengers();
    }

    public Passenger findByEmail(String email) {
        return  getEntitySet().stream()
                .filter(p -> p.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(getEntity() + " with that email was not found"));

    }
}
