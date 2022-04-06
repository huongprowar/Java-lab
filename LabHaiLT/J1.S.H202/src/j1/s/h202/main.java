package j1.s.h202;

import java.util.Scanner;

public class main {

    public static Scanner sc = new Scanner(System.in);
    
    public static void printReverse(String str) {
        String res = "";
        //the string res will be the reverse of str
        for (int i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        String str = sc.nextLine().trim();
        //check if the string is empty or not
        if (!str.isEmpty()) {
            printReverse(str);
        }
    }
}
