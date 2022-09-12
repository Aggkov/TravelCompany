package com.travelcompany.eshop.view;

import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.Order;
import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.model.enums.Category;
import com.travelcompany.eshop.model.enums.PaymentMethod;
import com.travelcompany.eshop.service.OrderService;
import com.travelcompany.eshop.service.impl.OrderServiceImpl;

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

        System.out.println("checkout menu");

        List<Order> orders = orderService.getAll();
        // for auto increment
        int size = orders.size();

        BigDecimal totalCost;
        if(passenger.getCategory().equals(Category.INDIVIDUAL)) {
//            x 1.10
            if(paymentMethod.equals(PaymentMethod.CREDIT)) {
                totalCost = itinerary.getBasicPrice().multiply(new BigDecimal("1.10"));
                System.out.println("indivi, credit= " + totalCost);
//           x1.20 cash
            } else {
                totalCost = itinerary.getBasicPrice().multiply(new BigDecimal("1.10"));
                System.out.println("indivi, cash= " + totalCost);
            }
            // -20 % disc (business, credit)
        } else {
            if(paymentMethod.equals(PaymentMethod.CREDIT)) {
                totalCost = itinerary.getBasicPrice().multiply(new BigDecimal("0.80"));
            }
            // -10%
            else {
                totalCost = itinerary.getBasicPrice().multiply(new BigDecimal("0.90"));
            }
        }

        Order order = orderService.addOrder(new Order(Long.valueOf(++size) ,passenger, itinerary, paymentMethod, totalCost));
        System.out.println(order);

    }
}
