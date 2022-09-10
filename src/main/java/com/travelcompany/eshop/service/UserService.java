
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Passenger;


public interface UserService {
    
    Passenger findByEmail(String email);
}
