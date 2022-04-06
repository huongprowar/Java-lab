package Validation;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Validation {

    public static Scanner sc = new Scanner(System.in);

    public String checkString(String mess, String regex) {
        String ret = "";
        while (true) {
            System.out.print("\n" + mess);
            ret = sc.nextLine();
            if (ret.matches(regex)) {
                break;
            }
            System.out.println("Invalid string input");
        }
        return ret;
    }

    public String checkDate(String mess, String format) {
        String ret = "";
        SimpleDateFormat SDF = new SimpleDateFormat(format);
        SDF.setLenient(false);
        while (true) {
            System.out.print("\n" + mess);
            ret = sc.nextLine();
            try {
                SDF.parse(ret);
                break;
            } catch (Exception e) {
                System.out.println("Invalid date input, please try again!");
            }
        }
        return ret;
    }

    public static int getInt(String mess, int MIN, int MAX) {
        int ret = 0;
        while (true) {
            System.out.println(mess);
            try {
                ret = Integer.parseInt(sc.nextLine());
                if (ret >= MIN && ret <= MAX) {
                    break;
                }
                System.out.println("Out of range, please try again!");
            } catch (Exception e) {
                System.out.println("Invalid int input, please try again!");
            }
        }
        return ret;
    }
}
