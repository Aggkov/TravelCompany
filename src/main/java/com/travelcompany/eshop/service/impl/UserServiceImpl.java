/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.service.impl;

import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.repository.UserRepository;
import com.travelcompany.eshop.repository.impl.UserRepositoryImpl;
import com.travelcompany.eshop.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public Passenger findByEmail(String email) {

        return userRepository.findByEmail(email);
    }
}
