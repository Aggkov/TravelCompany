package com.travelcompany.eshop.view;

// Singleton
public class UserMenu {

    private static UserMenu instance;

    private UserMenu() {
    }
    
    public static UserMenu getInstance() {
        if (instance == null) {
            instance = new UserMenu();
        }
        return instance;
    }
    
    public void showUserMenu() {
        System.out.println("hi from user menu");
        
        
    }

}
