
package com.travelcompany.eshop;

import com.travelcompany.eshop.DataBase.DataBase;
import com.travelcompany.eshop.boot.Application;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.KeyValue;
import com.travelcompany.eshop.model.Order;
import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.model.enums.Authority;
import com.travelcompany.eshop.model.enums.Category;
import com.travelcompany.eshop.model.enums.DestinationAirportCode;
import com.travelcompany.eshop.model.enums.Nationality;
import com.travelcompany.eshop.payload.PassengerDetails;
import com.travelcompany.eshop.utils.validators.InputValidator;
import com.travelcompany.eshop.view.UserMenu;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;


public class App {

    public static void main(String[] args) {

        Application.run();











//        System.out.println("System property: " + System.getProperty("user.dir"));

//        Passenger passenger11 = new Passenger(1L, "Maria Iordanou", "miordanou@mail.com", "Athens", Nationality.GREEK, Category.INDIVIDUAL, Authority.USER);
//
//        UserMenu.getInstance().showUserMenu(passenger11);


//        DataBase instance = DataBase.getInstance();
//        List<Order> orders = instance.getOrders();
//        Set<Passenger> passengers = instance.getPassengers();
//        List<Itinerary> itineraries = instance.getItineraries();

        //  List of the total offered itineraries per destination and offered itineraries per departure
//        Map<DestinationAirportCode, List<Itinerary>> itinerariesPerDestination1 = itineraries.stream()
//                .collect(Collectors.groupingBy(Itinerary::getDestinationAirportCode));
//
//        itinerariesPerDestination1.forEach((k, v) -> System.out.println(k + " " + v));
//
//        Map<DestinationAirportCode, Long> itinerariesPerDestination2 = itineraries.stream()
//                .collect(Collectors.groupingBy(Itinerary::getDestinationAirportCode, Collectors.counting()))
//                ;
//        System.out.println(itinerariesPerDestination2);


        // passenger ,ticket count
//        Map<Passenger, Integer> passengerDetails2 =
//                passengers.stream()
//                        .collect(Collectors.toMap(Function.identity(), p -> p.getItineraries().size()));
//
//        passengerDetails2.forEach((k, v) -> System.out.println(
//                k.getFullName() + ", ticket count = " + v));


        // pass, count , total paid
//        List passengerDetails3 =
//                passengers.stream()
//                        .map(p -> {
//                            Integer count = p.getItineraries().size();
//                            BigDecimal totalPaid2 = p.getOrders().parallelStream()
//                                    .map(Order::getPaymentAmount)
//                                    .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//                            return new KeyValue(p, new PassengerDetails(count, totalPaid2));
//                        }).collect(Collectors.toList());

//        for(Object obj: passengerDetails3) {
//            System.out.println(obj);
//        }

        // list of customers with the largest cost of purchases



//        for(Passenger passenger : instance.getPassengers()) {
//            if(passenger.getId() == 1) {
//                Passenger found = passenger;
//                System.out.println(found);
//            }
//        }



            // list of customers with the most tickets
//        List<Passenger> passengerDetails4 = passengers.stream()
//                .sorted((passenger1, passenger2) -> {
//                    if (passenger1.getItineraries().size() == passenger2.getItineraries().size())
//                        return 0;
//                    else if (passenger1.getItineraries().size() < passenger2.getItineraries().size())
//                        return 1;
//                    else
//                        return -1;
//                })
//                .limit(3)
//                .collect(Collectors.toCollection(ArrayList::new));

//        for (Passenger passenger : passengerDetails4) {
//            System.out.println(passenger.getFullName() + " has bought " + passenger.getItineraries().size() + " tickets");
//        }


        // TEST
//        List<KeyValue<Passenger, PassengerDetails>> passengerDetails4 = new ArrayList<>();
//        passengerDetails4 =
//                passengers.stream()
//                        .map(p -> {
//                            Integer count = p.getItineraries().size();
//                            BigDecimal totalPaid2 = p.getOrders().parallelStream()
//                                    .map(o -> o.getPaymentAmount())
//                                    .reduce(BigDecimal.ZERO, BigDecimal::add);
////                            KeyValue keyValue =  new KeyValue(p, new PassengerDetails(count,totalPaid2));
//                            return new ArrayList<KeyValue>(p, new PassengerDetails(count, totalPaid2));
//                        }).collect(Collectors.toCollection(new ArrayList<>(keyValue)));

//        for(Object obj: passengerDetails4) {
//            Passenger passenger = (Passenger) obj;
//            PassengerDetails passengerDetails = (PassengerDetails) obj;
//            System.out.println(passenger.getFullName() + " " + passengerDetails.getItinaryCount() + " " + passengerDetails.getTotalPaid());
//        }


//                        .collect(Collectors.toMap(Function.identity(), passengers.stream().collect(Collectors.toMap(
//                                (p -> p.getItineraries().size()) , totalPaid))));

//                                                HashMap::new));
//                                                .orders.stream()
//                                                .map(o -> o.getPaymentAmount()))

//                                        .reduce(BigDecimal.ZERO, BigDecimal::add)));

//        System.out.println(pass.getItineraries());

//        Order order = orders.stream()
//                .filter(o -> o.getId() == 2)
//                .findFirst()
//                .orElse(null);
//        System.out.println(order);
//        System.out.println(order.getPassenger().getItineraries());


    }
}
