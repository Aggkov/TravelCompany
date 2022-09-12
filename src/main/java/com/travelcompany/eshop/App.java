
package com.travelcompany.eshop;

import com.travelcompany.eshop.DataBase.DataBase;
import com.travelcompany.eshop.boot.Application;
import com.travelcompany.eshop.model.Passenger;
import com.travelcompany.eshop.model.enums.Authority;
import com.travelcompany.eshop.model.enums.Category;
import com.travelcompany.eshop.model.enums.Nationality;
import com.travelcompany.eshop.view.UserMenu;


public class App {

    public static void main(String[] args) {
        Application.run();
//        Passenger passenger11 = new Passenger(1L, "Maria Iordanou", "miordanou@mail.com", "Athens", Nationality.GREEK, Category.INDIVIDUAL, Authority.USER);
//
//        UserMenu.getInstance().showUserMenu(passenger11);

//        DataBase instance = DataBase.getInstance();
//        System.out.println(instance.getOrders());

    }
}
