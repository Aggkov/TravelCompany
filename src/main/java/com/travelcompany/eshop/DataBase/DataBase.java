package com.travelcompany.eshop.DataBase;

import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.Order;
import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.model.enums.*;
import com.travelcompany.eshop.utils.fileWriters.CsvWriter;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Data
public class DataBase {

    private static DataBase instance;

    private Set<Passenger> passengers = new LinkedHashSet<>();
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

        Passenger passenger10 = new Passenger(10L, "Admin Admin", "admin@mail.com", "Athens", Nationality.GREEK, Category.INDIVIDUAL, Authority.ADMIN);
        Collections.addAll(this.passengers, passenger1, passenger2, passenger3, passenger4, passenger5, passenger6, passenger7, passenger8, passenger9,passenger10);

        Itinerary itinerary1 = new Itinerary(1L, DepartureAirportCode.ATH, DestinationAirportCode.PAR, LocalDateTime.of(2022,02,22, 13, 35), Airline.SKYLINE, new BigDecimal("300"));
        Itinerary itinerary2 = new Itinerary(2L, DepartureAirportCode.ATH, DestinationAirportCode.LON, LocalDateTime.of(2022,02,22, 13, 40), Airline.SKYLINE, new BigDecimal("420"));
        Itinerary itinerary3 = new Itinerary(3L, DepartureAirportCode.ATH, DestinationAirportCode.AMS, LocalDateTime.of(2022,02,22, 13, 45), Airline.SKYLINE, new BigDecimal("280"));
        Itinerary itinerary4 = new Itinerary(4L, DepartureAirportCode.ATH, DestinationAirportCode.PAR, LocalDateTime.of(2022,02,22, 14, 20), Airline.SKYLINE, new BigDecimal("310"));
        Itinerary itinerary5 = new Itinerary(5L, DepartureAirportCode.ATH, DestinationAirportCode.DUB, LocalDateTime.of(2022,02,22, 14, 35), Airline.SKYLINE, new BigDecimal("880"));
        Itinerary itinerary6 = new Itinerary(6L, DepartureAirportCode.ATH, DestinationAirportCode.FRA, LocalDateTime.of(2022,02,22, 14, 55), Airline.SKYLINE, new BigDecimal("380"));
        Itinerary itinerary7 = new Itinerary(7L, DepartureAirportCode.ATH, DestinationAirportCode.FRA, LocalDateTime.of(2022,02,22, 15, 35), Airline.SKYLINE, new BigDecimal("350"));
        Itinerary itinerary8 = new Itinerary(8L, DepartureAirportCode.ATH, DestinationAirportCode.MEX, LocalDateTime.of(2022,02,22, 16, 00), Airline.SKYLINE, new BigDecimal("1020"));
        Itinerary itinerary9 = new Itinerary(9L, DepartureAirportCode.ATH, DestinationAirportCode.DUB, LocalDateTime.of(2022,02,22, 16, 35), Airline.SKYLINE, new BigDecimal("770"));
        Collections.addAll(this.itineraries, itinerary1,itinerary2, itinerary3, itinerary4, itinerary5, itinerary6, itinerary7, itinerary8, itinerary9);



        Order order1 = new Order(1L, passenger1,itinerary2, PaymentMethod.CASH, new BigDecimal("462"));
        Order order2 = new Order(2L, passenger2,itinerary3, PaymentMethod.CASH, new BigDecimal("308"));
        Order order3 = new Order(3L, passenger3,itinerary3, PaymentMethod.CREDIT, new BigDecimal("224"));
        Order order4 = new Order(4L, passenger2,itinerary4, PaymentMethod.CREDIT, new BigDecimal("341"));
        Order order5 = new Order(5L, passenger3,itinerary4, PaymentMethod.CASH, new BigDecimal("248"));
        Order order6 = new Order(6L, passenger4,itinerary7, PaymentMethod.CREDIT, new BigDecimal("968"));
        Order order7 = new Order(7L, passenger5,itinerary7, PaymentMethod.CREDIT, new BigDecimal("968"));
        Collections.addAll(this.orders, order1, order2, order3, order4, order5,order6,order7);

        passenger1.addItinerary(itinerary2);
        passenger1.addOrder(order1);

        passenger2.addItinerary(itinerary3);
        passenger2.addItinerary(itinerary4);
        passenger2.addOrder(order2);
        passenger2.addOrder(order4);

        passenger3.addItinerary(itinerary3);
        passenger3.addItinerary(itinerary4);
        passenger3.addOrder(order3);
        passenger3.addOrder(order5);

        passenger4.addItinerary(itinerary7);
        passenger4.addOrder(order6);

        passenger5.addItinerary(itinerary7);
        passenger5.addOrder(order7);

    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();

        }
        return instance;
    }

}
