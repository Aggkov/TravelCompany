package com.travelcompany.eshop.view;


import com.travelcompany.eshop.exception.BadRequestException;
import com.travelcompany.eshop.exception.ResourceNotFoundException;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.Order;
import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.model.enums.PaymentMethod;
import com.travelcompany.eshop.service.ItineraryService;
import com.travelcompany.eshop.service.OrderService;
import com.travelcompany.eshop.service.impl.ItineraryServiceImpl;
import com.travelcompany.eshop.service.impl.OrderServiceImpl;
import com.travelcompany.eshop.utils.validators.InputValidator;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

// Singleton
public class UserMenu {

    private static UserMenu instance;
    private final ItineraryService itineraryService = new ItineraryServiceImpl();

    private UserMenu() {
    }

    public static UserMenu getInstance() {
        if (instance == null) {
            instance = new UserMenu();
        }
        return instance;
    }

    public void showUserMenu(Passenger passenger) {
        System.out.println("hi from user menu");
        List<Itinerary> itineraries = itineraryService.getAllItineraries();
        boolean flag1 = false;
        boolean flag2 = false;
        String paymentMethodInput = "";
        while (!flag1) {
            try {
                int orderId = InputValidator.validateIntegerInput("Which itinerary would you like? : " + "\n" + InputValidator.getOptionsNames(itineraries),
                        InputValidator.getOptionsNumbers(itineraries));
                Itinerary foundItinerary = (itineraryService.findById((long) orderId));

                while(!flag2) {
                    paymentMethodInput = InputValidator.validateString();
                    flag2 = true;
                }

                PaymentMethod paymentMethod = PaymentMethod.valueOf(paymentMethodInput.toUpperCase());

                CheckOutMenu.getInstance().showCheckOutMenu(passenger, foundItinerary, paymentMethod);

                flag1 = true;

            } catch (NumberFormatException | ResourceNotFoundException | BadRequestException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

}
