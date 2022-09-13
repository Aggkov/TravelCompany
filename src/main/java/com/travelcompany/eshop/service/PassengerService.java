
package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Passenger;


public interface PassengerService {
    
    Passenger findByEmail(String email);
}
