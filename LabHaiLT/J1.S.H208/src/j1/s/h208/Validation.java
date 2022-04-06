package j1.s.h208;

import java.util.Scanner;

public class Validation {
    //check user input integer number or not
    public static long getInteger(String msg, long min, long max) {
        Scanner sc = new Scanner(System.in);
        long result = 0;
        //loop until user input correct        
        while (true) {
            try {
                System.out.print(msg);
                result = Long.parseLong(sc.nextLine());
                if (result > min && result < max) {
                    break;
                }
                System.out.println("Out of range");
            } catch (Exception e) {
                System.out.println("Please input an integer number");
            }
        }
        return result;
    }
}
