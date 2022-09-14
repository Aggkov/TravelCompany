package com.travelcompany.eshop.utils.fileWriters;

import com.travelcompany.eshop.model.Order;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CsvWriter {

    public static void writeListOrdersToCsv(List<Order> orderList) {
        Path path = Paths.get("orders.csv");

        try (Writer writer = Files.newBufferedWriter(path);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            orderList.forEach(order -> {
                try {
                    csvPrinter.printRecord(order.getId(), order.getId(), order.getPassenger(),
                            order.getItinerary(), order.getPaymentMethod(), order.getPaymentAmount().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void writeNewOrderToCsv(Order order) {
        Path path = Paths.get("orders.csv");

        try {
            BufferedWriter writer = Files.newBufferedWriter((path),
                    StandardOpenOption.APPEND,
                    StandardOpenOption.CREATE);

            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

            csvPrinter.printRecord(order.getId(), order.getId(), order.getPassenger(),
                    order.getItinerary(), order.getPaymentMethod(), order.getPaymentAmount().toString());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
