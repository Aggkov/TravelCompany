
package com.travelcompany.eshop;

import com.travelcompany.eshop.DataBase.DataBase;
import com.travelcompany.eshop.boot.Application;
import com.travelcompany.eshop.model.Order;
import com.travelcompany.eshop.model.Passenger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class App {

    public static void main(String[] args) {

        Application.run();



    }
}
