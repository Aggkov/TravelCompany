/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.service.impl;

import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.repository.PassengerRepository;
import com.travelcompany.eshop.repository.impl.PassengerRepositoryImpl;
import com.travelcompany.eshop.service.PassengerService;

public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerServiceImpl() {
        this.passengerRepository = new PassengerRepositoryImpl();
    }

    @Override
    public Passenger findByEmail(String email) {

        return passengerRepository.findByEmail(email);
    }
}
