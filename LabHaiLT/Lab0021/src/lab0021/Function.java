package lab0021;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class Function {

    Scanner sc = new Scanner(System.in);

    public static void create(ArrayList<Student> ls) {
        while (true) {
            System.out.print("\nEnter student's ID: ");
            String id = Validation.checkStringInput();
            if (Validation.checkIdExist(ls, id)) {
                System.out.println("Duplicate, please input again!");
                continue;
            }
            System.out.print("Enter student's name: ");
            String name = Validation.checkStringInput();
            int age = Validation.checkIntInput("Enter student's age: ", 18, 99);
            System.out.print("Enter student's semester: ");
            String semester = Validation.checkStringInput();
            System.out.print("Enter student's course: ");
            String course = Validation.checkStringInput();
            ls.add(new Student(id, name, age, semester, course));
            break;
        }
    }

    public static void createStudent(ArrayList<Student> ls) {
        int count = 0;
        while (count < 5) {
            create(ls);
            count++;
        }
        while (true) {
            System.out.print("Do you want to continue (Y/N): ");
            if (Validation.checkInputYN()) {
                create(ls);
                continue;
            }
            break;
        }
    }

    public static ArrayList<Student> findStudentByName(ArrayList<Student> ls, String name) {
        ArrayList<Student> list = new ArrayList<Student>();
        for (Student student : ls) {
            if (student.getName().contains(name)) {
                list.add(student);
            }
        }
        return list;
    }

    public static void findAndSort(ArrayList<Student> ls) {
        if (ls.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        String name = Validation.checkStringInput();
        findStudentByName(ls,name);
    }

    public static void Menu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Updata/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
    }

}
