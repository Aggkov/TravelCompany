
package com.travelcompany.eshop.repository;


import com.travelcompany.eshop.model.Passenger;


public interface UserRepository {

    public Passenger findByEmail(String email);

}
