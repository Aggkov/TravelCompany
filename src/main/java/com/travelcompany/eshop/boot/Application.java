package com.travelcompany.eshop.boot;

import com.travelcompany.eshop.DataBase.DataBase;
import com.travelcompany.eshop.utils.fileWriters.CsvWriter;
import com.travelcompany.eshop.view.MainMenu;

public class Application {

    public static void run() {

        MainMenu mainMenu = MainMenu.getInstance();
        mainMenu.showMainMenu();
    }

}
