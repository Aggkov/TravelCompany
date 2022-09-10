package com.travelcompany.eshop.view;

// Singleton
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.service.ItineraryService;
import com.travelcompany.eshop.service.OrderService;
import com.travelcompany.eshop.service.impl.ItineraryServiceImpl;
import com.travelcompany.eshop.service.impl.OrderServiceImpl;
import com.travelcompany.eshop.utils.validators.InputValidator;
import java.util.List;

public class UserMenu {

    private static UserMenu instance;
    private ItineraryService itineraryService = new ItineraryServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

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
        while (true) {
            try {
                int orderId = InputValidator.validateIntegerInput("Please make your choice: " + "\n" + InputValidator.getOptionsNames(itineraries),
                        InputValidator.getOptionsNumbers(itineraries));
                System.out.println(orderService.findById(Long.valueOf(orderId)));
                break;

            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

}
