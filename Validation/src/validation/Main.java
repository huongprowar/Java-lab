package validation;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    Validation v = new validation.Validation();

    public static void main(String[] args) {
        SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }
}
