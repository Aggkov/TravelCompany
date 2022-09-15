package com.travelcompany.eshop.view;

import com.travelcompany.eshop.database.DataBase;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.Order;
import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.model.enums.Category;
import com.travelcompany.eshop.model.enums.PaymentMethod;
import com.travelcompany.eshop.service.OrderService;
import com.travelcompany.eshop.service.impl.OrderServiceImpl;
import com.travelcompany.eshop.utils.fileWriters.CsvWriter;

import java.math.BigDecimal;
import java.util.List;

public class CheckOutMenu {

    private static CheckOutMenu instance;
    private final OrderService orderService = new OrderServiceImpl();

    private CheckOutMenu() {
    }

    public static CheckOutMenu getInstance() {
        if (instance == null) {
            instance = new CheckOutMenu();
        }
        return instance;
    }

    public void showCheckOutMenu(Passenger passenger, Itinerary itinerary, PaymentMethod paymentMethod) {

        System.out.println("------CHECKOUT MENU-------");

        List<Order> orders = orderService.getAll();

        // for auto increment
        int size = orders.size();

        BigDecimal totalCost;
        if(passenger.getCategory().equals(Category.INDIVIDUAL)) {
            if(paymentMethod.equals(PaymentMethod.CREDIT)) {
                totalCost = itinerary.getBasicPrice().multiply(new BigDecimal("1.10"));
            } else {
                totalCost = itinerary.getBasicPrice().multiply(new BigDecimal("1.20"));;
            }
        } else {
            if(paymentMethod.equals(PaymentMethod.CREDIT)) {
                totalCost = itinerary.getBasicPrice().multiply(new BigDecimal("0.80"));
            }
            else {
                totalCost = itinerary.getBasicPrice();
            }
        }

        Order newOrder = orderService.addOrder(new Order(Long.valueOf(++size) ,passenger, itinerary, paymentMethod, totalCost));

        CsvWriter.writeListOrdersToCsv(DataBase.getInstance().getOrders());

        System.out.println("You have selected the following itinerary " + itinerary + " with payment method of " + paymentMethod
        + " and the payment amount is " + totalCost);

    }
}
