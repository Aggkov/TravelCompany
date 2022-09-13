
package com.travelcompany.eshop.repository;


import com.travelcompany.eshop.model.Passenger;


public interface PassengerRepository {

    public Passenger findByEmail(String email);

}
