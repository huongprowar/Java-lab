package j1.s.p0103;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    Scanner sc = new Scanner(System.in);

    Date CheckDate(String Mess, String format) {
        // parse 1 String -> Date
        SimpleDateFormat SDF = new SimpleDateFormat(format);
        // If you enter the wrong date like 30/02, it will be reported wrong and must be re-entered
        SDF.setLenient(false);
        Date ret;
        while (true) {
            System.out.print("\n" + Mess);
            try {
                ret = SDF.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid date input, please try again!");
            }
        }
        return ret;
    }
}
