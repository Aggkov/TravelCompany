package com.travelcompany.eshop.report;

import com.travelcompany.eshop.DataBase.DataBase;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.KeyValue;
import com.travelcompany.eshop.model.Order;
import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.model.enums.DepartureAirportCode;
import com.travelcompany.eshop.model.enums.DestinationAirportCode;
import com.travelcompany.eshop.payload.PassengerDetailsResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportService {

    DataBase instance = DataBase.getInstance();
    List<Order> orders = instance.getOrders();
    Set<Passenger> passengers = instance.getPassengers();
    List<Itinerary> itineraries = instance.getItineraries();

    public void listTotalNumberAndTotalCostOfTicketsPerCustomer() {
        List passengerList =
                passengers.stream()
                        .map(p -> {
                            Integer ticketCount = p.getItineraries().size();
                            BigDecimal totalPaid = p.getOrders().parallelStream()
                                    .map(Order::getPaymentAmount)
                                    .reduce(BigDecimal.ZERO, BigDecimal::add);

                            return new KeyValue(p, new PassengerDetailsResponse(ticketCount, totalPaid));
                        }).collect(Collectors.toList());

        for (Object obj : passengerList) {
            System.out.println(obj);
        }
    }

    public void listTotalOfferedItinerariesPerDestination() {
        Map<DestinationAirportCode, List<Itinerary>> itinerariesPerDestination = itineraries.stream()
                .collect(Collectors.groupingBy(Itinerary::getDestinationAirportCode));

        itinerariesPerDestination.forEach((k, v) -> System.out.println(k + " " + v));
    }

    public void listTotalOfferedItinerariesPerDeparture() {
        Map<DepartureAirportCode, List<Itinerary>> itinerariesPerDeparture = itineraries.stream()
                .collect(Collectors.groupingBy(Itinerary::getDepartureAirportCode));

        itinerariesPerDeparture.forEach((k, v) -> System.out.println(k + " " + v));
    }

    public void listOfCustomersWithMostTickets() {
        List<Passenger> passengersWithMostTickets = passengers.stream()
                .sorted((passenger1, passenger2) -> {
                    if (passenger1.getItineraries().size() == passenger2.getItineraries().size())
                        return 0;
                    else if (passenger1.getItineraries().size() < passenger2.getItineraries().size())
                        return 1;
                    else
                        return -1;
                })
                .limit(3)
                .collect(Collectors.toCollection(ArrayList::new));

        passengersWithMostTickets.forEach(System.out::println);
    }

    public void listCustomersWithLargestPurchases() {
        for (Passenger passenger : instance.getPassengers()) {
            if (passenger.getOrders().size() > 0) {
                Set<Order> ordersSet = passenger.getOrders();
                BigDecimal sumAmount = BigDecimal.ZERO;
                for (Order order : ordersSet) {
                    if (order.getPaymentAmount().doubleValue() > 400.00) {
                        sumAmount = sumAmount.add(order.getPaymentAmount());
                        System.out.println("Passenger " + " with name " + passenger.getFullName() + " has a total of " + sumAmount + " paid \n");
                    }
                }
            }
        }
    }

    public void listCustomersWithNoTickets() {
        List<Passenger> passengersWithNoTickets = passengers.stream()
                .filter(p -> p.getItineraries().size() == 0)
                .collect(Collectors.toList());

        passengersWithNoTickets.forEach(System.out::println);

    }
}
