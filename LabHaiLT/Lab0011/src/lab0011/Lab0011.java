package lab0011;

import java.util.Scanner;

public class Lab0011 {

    public static void printBinary(int num) {
        if (num == 0) {
            System.out.print(0);
            return;
        }
        if (num < 0) {
            num = ~num + 1;
        }

        int[] arr = new int[32];
        int idx = arr.length - 1;

        while (num > 0) {
            arr[idx] = num % 2;
            num /= 2;
            idx--;
        }

        for (int i = idx + 1; i < 32; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose the base number");
        System.out.println("1: Binary");
        System.out.println("2: Decimal");
        System.out.println("3: Hexadecimal");
        Validation valid = new Validation();
        int userChoice = Integer.parseInt(sc.nextLine());
        int number = 0;
        switch (userChoice) {
            case 1:
                System.out.print("Input a 32-bit string number: ");
                number = valid.getBinaryNumber();
                break;
            case 2:
                System.out.print("Input a decimal number: ");
                number = valid.getDecimalNumber();
                break;
            case 3:
                System.out.print("Input a 32-bit hexadecimal number: ");
                number = valid.getHexaNumber();
                break;
        }
        System.out.print("Please choose the output number: ");
        userChoice = Integer.parseInt(sc.nextLine());
        switch (userChoice) {
            case 1:
                printBinary(number);
                break;
            case 2:
                System.out.print(number);
                break;
            case 3:
                System.out.printf("%X\n", number);
                break;
        }
    }

}
