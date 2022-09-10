package com.travelcompany.eshop.DataBase;

import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.Order;
import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.model.enums.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBase {

    private static DataBase instance;

    private List<Passenger> passengers = new ArrayList<>();
    private List<Itinerary> itineraries = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();


    private DataBase() {

        Passenger passenger1 = new Passenger(1L, "Maria Iordanou", "miordanou@mail.com", "Athens", Nationality.GREEK, Category.INDIVIDUAL, Authority.USER);
        Passenger passenger2 = new Passenger(2L, "Dimitriou Dimitrios", "ddimitriou@mail.com", "Athens", Nationality.GREEK, Category.INDIVIDUAL, Authority.USER);
        Passenger passenger3 = new Passenger(3L, "Ioannis Ioannou", "iiouanou@mail.com", "Athens", Nationality.GREEK, Category.BUSINESS, Authority.USER);
        Passenger passenger4 = new Passenger(4L, "Antonio Molinari", "amolinari@mail.com", "Milan", Nationality.ITALIAN, Category.INDIVIDUAL, Authority.USER);
        Passenger passenger5 = new Passenger(5L, "Frederico Rossi", "frossi@mail.com", "Milan", Nationality.ITALIAN, Category.INDIVIDUAL, Authority.USER);
        Passenger passenger6 = new Passenger(6L, "Mario Conti ", "mconti@mail.com", "Rome", Nationality.ITALIAN, Category.BUSINESS, Authority.USER);
        Passenger passenger7 = new Passenger(7L, "Nathan Martin", "nmartin@mail.com", "Lyon", Nationality.FRENCH, Category.BUSINESS, Authority.USER);
        Passenger passenger8 = new Passenger(8L, "Enzo Collin", "ecollim@mail.com", "Lyon", Nationality.FRENCH, Category.INDIVIDUAL, Authority.USER);
        Passenger passenger9 = new Passenger(9L, "Frederic Michel", "fmichel@mail.com", "Athens", Nationality.FRENCH, Category.INDIVIDUAL, Authority.USER);
        Collections.addAll(this.passengers, passenger1, passenger2, passenger3, passenger4, passenger5, passenger6, passenger7, passenger8, passenger9);

        Itinerary itinerary1 = new Itinerary(1L, DepartureAirportCode.ATH, DestinationAirportCode.PAR, LocalDateTime.of(2022,02,22, 13, 35), Airline.SKYLINE, new BigDecimal("300"));
        Itinerary itinerary2 = new Itinerary(2L, DepartureAirportCode.ATH, DestinationAirportCode.LON, LocalDateTime.of(2022,02,22, 13, 40), Airline.SKYLINE, new BigDecimal("420"));
        Itinerary itinerary3 = new Itinerary(3L, DepartureAirportCode.ATH, DestinationAirportCode.AMS, LocalDateTime.of(2022,02,22, 13, 45), Airline.SKYLINE, new BigDecimal("280"));
        Itinerary itinerary4 = new Itinerary(4L, DepartureAirportCode.ATH, DestinationAirportCode.PAR, LocalDateTime.of(2022,02,22, 14, 20), Airline.SKYLINE, new BigDecimal("310"));
        Collections.addAll(this.itineraries, itinerary1,itinerary2, itinerary3, itinerary4);

        Order order1 = new Order(1L, passenger1,itinerary2, PaymentMethod.CASH, new BigDecimal("462"));
        Collections.addAll(this.orders, order1);
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();


        }
        return instance;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
