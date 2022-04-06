package lab0021;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String [] args){
        ArrayList<Student> ls = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            Function.Menu();
            int choice = Validation.checkIntInput("Input your choice: ",1, 5);
            switch(choice){
                case 1:
                    Function.createStudent(ls);
                    break;
                case 2:
                    Function.findAndSort(ls);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    return;
            }
        }
    }
}
