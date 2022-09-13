package com.travelcompany.eshop.view;

import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.report.ReportService;
import com.travelcompany.eshop.service.ItineraryService;
import com.travelcompany.eshop.service.impl.ItineraryServiceImpl;
import com.travelcompany.eshop.utils.validators.InputValidator;

public class AdminMenu {
    private static AdminMenu instance;
    private final ItineraryService itineraryService = new ItineraryServiceImpl();
    private final ReportService reportService = new ReportService();

    private AdminMenu() {
    }

    public static AdminMenu getInstance() {
        if (instance == null) {
            instance = new AdminMenu();
        }
        return instance;
    }

    public void showAdminMenu() {

        while (true) {

            System.out.println(("1") + " -  List of the total number and list of the cost of tickets for all customers");
            System.out.println(("2") + " -  List of the total offered itineraries per destination");
            System.out.println(("3") + " -  List of the total offered itineraries per departure");
            System.out.println(("4") + " -  List of the customers with the most tickets");
            System.out.println(("5") + " -  List of the customers  with the largest cost of purchases");
            System.out.println(("6") + " -  List of the customers who have not purchased any tickets\n");

            int choice;
            try {
                choice = InputValidator.validateIntegerInput("Please select one of the following Reports: ");
                switch (choice) {
                    case 1:
                        reportService.listTotalNumberAndTotalCostOfTicketsPerCustomer();
                        break;
                    case 2:
                        reportService.listTotalOfferedItinerariesPerDestination();
                        break;
                    case 3:
                        reportService.listTotalOfferedItinerariesPerDeparture();
                        break;
                    case 4:
                        reportService.listOfCustomersWithMostTickets();
                        break;
                    case 5:
                        reportService.listCustomersWithLargestPurchases();
                        break;
                    case 6:
                        reportService.listCustomersWithNoTickets();
                        break;
                    default:
                        MainMenu.getInstance().showMainMenu();

                }
            } catch (NumberFormatException ex) {
                ex.getMessage();
            }
        }
    }
}
