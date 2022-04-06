package j1.s.h207;

import java.util.Scanner;

public class Validation {

    public static Scanner sc = new Scanner(System.in);

    public static String getStringInput() {
        while (true) {
            System.out.print("Enter a string: ");
            String str = sc.nextLine().trim();
            if (str.isEmpty()) {
                System.out.println("The string can't be empty!");
                continue;
            }
            return str;
        }
    }
}
