package com.travelcompany.eshop.view;

public class MainMenu {

    private static MainMenu instance;

    public static MainMenu getInstance() {
        if (instance == null) {
            instance = new MainMenu();
        }
//        instance.showMainMenu();
        return instance;
    }

    public void showMainMenu() {
        System.out.println("Welcome to app, Please login with your email");
    }
}
