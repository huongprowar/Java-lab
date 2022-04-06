package j1.s.h203.pkg1;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String str = Validation.getStringInput();
        String[] arrOfStr = str.split("[.!?]+");
        String[] pureStr = str.split("[.?!\\s]+");
        String sign = "!.?";
        int z = 0;
        for (int i = 0; i < str.length(); i++) {
            if (sign.contains("" + str.charAt(i))) {
                z++;
            }
        }
        char[] signOfStr = new char[z];
        int k = 0;
        for (int i = 0; i < str.length(); i++) {
            if (sign.contains("" + str.charAt(i))) {
                signOfStr[k] = str.charAt(i);
                k++;
            }
        }
        // ngo hai nam. abc xyz
        z = signOfStr.length-1;
        k = pureStr.length - 1;
        for (int i = 0; i < arrOfStr.length; i++) {
            String tmp = "";
            String[] subStr = arrOfStr[i].trim().split("\\s+");//[abc][xyz]   
            for (int j = subStr.length - 1; j >= 0; j--) {
                tmp += pureStr[k] + " ";
                k--;
            }
            result.append(tmp.substring(0, 1).toUpperCase() + tmp.substring(1).trim());
            if (z >= 0) {
                result.append(signOfStr[z] + " ");
                z--;
            }
        }
        System.out.println(result);
    }
//nguyen van hieu. abc xyz? mzd
//Mzd xyz abc. Hieu van? Nguyen
}
