package com.travelcompany.eshop.view;

import com.travelcompany.eshop.exception.InvalidEmailException;
import com.travelcompany.eshop.exception.ResourceNotFoundException;
import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.service.UserService;
import com.travelcompany.eshop.service.impl.UserServiceImpl;
import com.travelcompany.eshop.utils.validators.InputValidator;

import java.util.Scanner;

public class MainMenu {

    private static MainMenu instance;
    private Scanner sc = new Scanner(System.in);
    private UserService userService = new UserServiceImpl();

    private MainMenu() {
    }

    public static MainMenu getInstance() {
        if (instance == null) {
            instance = new MainMenu();
        }
        return instance;
    }

    public void showMainMenu() {
        System.out.println("Welcome to app, Please login with your email");
        String inputEmail = "";
        while (true) {
            try {
                inputEmail = InputValidator.ValidateEmail();
                Passenger foundPassenger = userService.findByEmail(inputEmail);
                if (foundPassenger.getAuthority().name().equals("USER")) {
                    UserMenu.getInstance().showUserMenu(foundPassenger);
                }
                else {
                    AdminMenu.getInstance().showAdminMenu(foundPassenger);
                }
                break;
            } catch (InvalidEmailException ex) {
                System.out.println(ex.getMessage());
                continue;
            } catch (ResourceNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
}
