package lab0011;

import java.util.Scanner;

public class Validation {

    Scanner sc = new Scanner(System.in);

    public int getBinaryNumber() {
        int result = 0;
        while (true) {
            String input = sc.nextLine().trim();
            if (input.matches("[01]+")) {
                if (input.length() > 32) {
                    System.out.print("You must enter an 32-bit binary string");
                    continue;
                }
                for (int i = 0; i < input.toCharArray().length; i++) {
                    result *= 2;
                    result += (input.charAt(i) - '0');
                }
                break;
            }
            System.out.print("Please input an binary string");
        }
        return result;
    }

    public int getHexaNumber() {
        int result = 0;
        while (true) {
            String input = sc.nextLine().trim();
            if (input.matches("[0-9A-Fa-f]+")) {
                if (input.length() > 32) {
                    System.err.print("You must enter an 8-digits hexadecimal:");
                    continue;
                }
                for (char c : input.toCharArray()) {
                    result *= 16;
                    if (Character.isDigit(c)) {
                        result += (c - '0');
                    } else {
                        result += (Character.toUpperCase(c) - 'A' + 10);
                    }
                }
                break;
            }
            System.out.print("Please input a hexadecimal string: ");
        }
        return result;
    }

    public int getDecimalNumber() {
        int result = 0;
        while (true) {
            try {
                result = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.print("Please input an integer number: ");
            }
        }
        return result;
    }

}
