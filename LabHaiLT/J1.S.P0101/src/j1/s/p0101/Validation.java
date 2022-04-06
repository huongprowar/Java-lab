package j1.s.p0101;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    //check user input integer number or not
    public static int getInteger(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
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

    public static String getString(String msg) {
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
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

    Date getDate(String Mess, String format) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat SDF = new SimpleDateFormat(format);
        SDF.setLenient(false);
        Date ret;
        while (true) {
            System.out.print(Mess);
            try {
                ret = SDF.parse(sc.nextLine());
                if (checkDate(ret)) {
                    break;
                }
                System.out.println("Can not input future date!");
            } catch (Exception e) {
                System.out.println("Invalid date input, please try again!");
            }
        }
        return ret;
    }

    boolean checkDate(Date date) throws ParseException {
        SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        Date today = SDF.parse(dtf.format(now));
        return today.after(date);
    }
}
