
package com.travelcompany.eshop.repository;


import com.travelcompany.eshop.model.Passenger;


public interface PassengerRepository extends JpaRepository<Passenger> {

    Passenger findByEmail(String email);

//    Passenger save(Passenger passenger);

}
