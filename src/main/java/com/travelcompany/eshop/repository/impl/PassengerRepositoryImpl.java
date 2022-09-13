/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.DataBase.DataBase;
import com.travelcompany.eshop.exception.ResourceNotFoundException;
import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.repository.PassengerRepository;

import java.util.Set;

/**
 *
 * @author Aggelos
 */
public class PassengerRepositoryImpl implements PassengerRepository {

    DataBase databaseInstance = DataBase.getInstance();
    Set<Passenger> passengers = databaseInstance.getPassengers();

//    public PassengerRepositoryImpl() {}

    public Passenger findByEmail(String email) {
        return passengers.stream()
                .filter(p -> p.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Passenger with that email was not found"));

    }

}
