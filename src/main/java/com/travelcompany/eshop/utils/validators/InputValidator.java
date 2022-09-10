
package com.travelcompany.eshop.utils.validators;

import com.travelcompany.eshop.exception.InvalidEmailException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class InputValidator {

    private final static Scanner sc = new Scanner(System.in);

    public static String ValidateEmail() throws InvalidEmailException {

        System.out.print("Please provide your email: ");

        String email = sc.nextLine();
        if (Pattern.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}"
                + "~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\."
                + "[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)"
                + "+[a-zA-Z]{2,}))$", email)) {
            return email;
        } else {
            throw new InvalidEmailException("Email is not valid");
        }
    }
}
