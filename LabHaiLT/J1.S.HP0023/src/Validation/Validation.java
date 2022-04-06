/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Validation {

    public static Scanner sc = new Scanner(System.in);

    public static double getDouble(String msg, double min, double max) {
        Scanner sc = new Scanner(System.in);
        double result = 0;
        //loop until user input correct
        while (true) {
            try {
                System.out.print(msg);
                result = Double.parseDouble(sc.nextLine());
                if (result >= min && result <= max) {
                    break;
                }
                System.out.println("Out of range");
            } catch (Exception e) {
                System.out.println("Please input an integer number");
            }
        }
        return result;
    }

    public static int getInt(String msg, int min, int max) {
        int result = 0;
        //loop until user input correct
        while (true) {
            try {
                System.out.print(msg);
                result = Integer.parseInt(sc.nextLine());
                if (result >= min && result <= max) {
                    break;
                }
                System.out.println("Out of range");
            } catch (Exception e) {
                System.out.println("Please input an integer number");
            }
        }
        return result;
    }

    public static String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String str = sc.nextLine().trim();
            if (str.isEmpty()) {
                System.out.println("The string can't be empty!");
                continue;
            }
            return str;
        }
    }

    public static String getStringRegex(String msg, String format) {
        while (true) {
            System.out.print(msg);
            String str = sc.nextLine().trim();
            if (str.isEmpty()) {
                System.out.println("The string can't be empty!");
                continue;
            }
            if (str.matches(format)) {
                return str;
            } else {
                System.out.println("Wrong format");
                continue;
            }
        }
    }

    public static boolean getYN(String msg) {
        while (true) {
            {
                System.out.print(msg);
                String str = sc.nextLine().trim();
                if (str.isEmpty()) {
                    System.out.println("The string can't be empty!");
                    continue;
                }
                if (str.matches("[YyNn]")) {
                    if (str.toLowerCase().equals("y")) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    continue;
                }
            }
        }
    }

}
