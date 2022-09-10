/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.DataBase.DataBase;
import com.travelcompany.eshop.exception.ResourceNotFoundException;
import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.repository.UserRepository;
import java.util.List;

/**
 *
 * @author Aggelos
 */
public class UserRepositoryImpl implements UserRepository {

    DataBase databaseInstance = DataBase.getInstance();
    List<Passenger> passengers = databaseInstance.getPassengers();

    public UserRepositoryImpl() {}

    public Passenger findByEmail(String email) {
        return passengers.stream()
                .filter(p -> p.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Passenger with that email was not found"));

    }

}
