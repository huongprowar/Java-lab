package j1.s.h206;

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
                    return result;
                }
                System.out.println("Out of range");
            } catch (Exception e) {
                System.out.println("Please input an integer number");
            }
        }
    }
}
