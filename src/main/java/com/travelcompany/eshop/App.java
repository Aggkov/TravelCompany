
package com.travelcompany.eshop;

import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.repository.PassengerRepository;
import com.travelcompany.eshop.repository.impl.PassengerRepositoryImpl;

public class App {

    public static void main(String[] args) {

//        Application.run();









        // FIND BY EMAIL
        PassengerRepository passengerRepository = new PassengerRepositoryImpl();

        Passenger foundPassenger = passengerRepository.findByEmail("ada@mail.com");
        System.out.println(foundPassenger);
//
//        // CREATE
//        System.out.println(DataBase.getInstance().getPassengers());
//        passengerRepository.create(new Passenger(20L,"John Johnson", "john@mail.com", "address",
//                Nationality.FRENCH, Category.BUSINESS, Authority.USER));
//        System.out.println(DataBase.getInstance().getPassengers());
//
//        // UPDATE
//        foundPassenger.setAddress("XXXXX");
//        passengerRepository.update(foundPassenger);
//        System.out.println(foundPassenger);




    }
}
