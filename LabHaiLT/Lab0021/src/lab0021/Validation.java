package lab0021;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Validation {

    public static Scanner scn = new Scanner(System.in);

    public static String checkStringInput() {
        while (true) {
            String result = scn.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("No empty, please re-input: ");
            } else {
                return result;
            }
        }
    }

    public static boolean checkIdExist(ArrayList<Student> ls, String id) {
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getID())) {
                return true;
            }
        }
        return false;
    }

    public static int checkIntInput(String msg, int min, int max) {
        System.out.print(msg);
        while (true) {
            try {
                int result = Integer.parseInt(scn.nextLine());
                if (result >= min && result <= max) {
                    return result;
                }
                System.out.println("Out of range!");
            } catch (Exception e) {
                System.out.println("Please input integer only!");
            }
            System.out.print(msg);
        }
    }
    
    public static boolean checkInputYN() {
        while (true) {
            String result = checkStringInput();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.print("Please input Y/N:");
        }
    }
    


}
