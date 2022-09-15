package com.travelcompany.eshop.utils.validators;

import com.travelcompany.eshop.exception.BadRequestException;
import com.travelcompany.eshop.exception.InvalidEmailException;
import com.travelcompany.eshop.model.Itinerary;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class InputValidator {

    private final static Scanner sc = new Scanner(System.in);

    public static String ValidateEmail() throws InvalidEmailException {

        System.out.print("Please provide your email: ");

        String email = sc.nextLine();
        if (Pattern.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}"
                + "~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\."
                + "[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)"
                + "+[a-zA-Z]{2,}))$", email.trim())) {
            return email.trim();
        } else {
            throw new InvalidEmailException("Email is not valid");
        }
    }

    public static String validateString() throws BadRequestException {

        System.out.print("Which is your desired payment method? (CASH,CREDIT): ");
        String input = sc.next();
        if (input.equalsIgnoreCase("CASH") || input.equalsIgnoreCase("CREDIT")) {
            return input;
        } else {
            throw new BadRequestException("Only CASH or CREDIT are supported ,please provide the correct input");
        }
    }
//amolinari@mail.com
    public static int validateIntegerInput(String question) {
        System.out.print(question);
        int resultNum;
        while (true) {
            try {
                String input = sc.next();
                int number = Integer.parseInt(input);
                resultNum = number;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Only integers allowed please!");
            }
        }
        return resultNum;
    }

    public static int validateIntegerInput(String question, int[] availableChoices) throws NumberFormatException {

        System.out.print(question);

        if (!sc.hasNextInt()) {
            sc.next();
            throw new NumberFormatException("Only integers allowed please!");

        } else {
            int num = sc.nextInt();
            for (int i : availableChoices) {
                if (num == i) {
                    return num;
                }
            }
        }
        return -1;
    }

    public static int[] getOptionsNumbers(List<Itinerary> options) {

        int[] optionsToInt = new int[options.size()];
        for (int i = 0; i < optionsToInt.length; i++) {
            optionsToInt[i] = i + 1;
        }
        return optionsToInt;
    }

    public static String getOptionsNames(List<Itinerary> options) {
        String tmp = " ";

        for (int i = 0; i < options.size(); i++) {
            tmp += " [" + (i + 1) + "] " + options.get(i) + "\n";
        }
        return tmp;
    }
}
