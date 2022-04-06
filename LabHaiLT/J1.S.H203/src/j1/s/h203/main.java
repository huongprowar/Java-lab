package j1.s.h203;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String str = Validation.getStringInput();
        
        //cắt string gốc theo dấu ra        
        String[] arrOfStr = str.split("[.!?]+");
        String sign = "!.?";
        int z = 0;
        //lấy số dấu trong str
        for (int i = 0; i < str.length(); i++) {
            if (sign.contains("" + str.charAt(i))) {
                z++;
            }
        }
        //thêm dấu vào signOfStr
        char[] signOfStr = new char[z];
        z = 0;
        for (int i = 0; i < str.length(); i++) {
            if (sign.contains("" + str.charAt(i))) {
                signOfStr[z] = str.charAt(i);
                z++;
            }
        }
        z = signOfStr.length - 1;
        //ngo hai nam. abc xyz? mzd
        //
        
        //đảo vị trí của chữ trong string
        for (int i = arrOfStr.length - 1; i >= 0; i--) {
            String tmp = "";
            String[] subStr = arrOfStr[i].split("\\s+");//[abc][xyz]   
            //đảo ngược vị trí của các chữ trong arrOfStr theo thứ tự
            for (int j = subStr.length - 1; j >= 0; j--) {
                tmp += subStr[j] + " ";
            }
            //nối các chữ trong subStr với nhau và viết hoa chữ cái đầu
            result.append(tmp.substring(0, 1).toUpperCase() + tmp.substring(1).trim());
            if (z >= 0) {
                result.append(signOfStr[z] + " ");
                z--;
            }
        }
        System.out.println(result);
    }
}
