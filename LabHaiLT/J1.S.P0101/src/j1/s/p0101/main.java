package j1.s.p0101;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class main {
//(Id, First Name, Last Name, Phone, Email, Address, DOB, Sex, Salary, Egency

    public static void main(String[] args) throws Exception {
        int choice = 0;
        SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Employee> list = new ArrayList<Employee>();
        Validation v = new Validation();
        Function f = new Function();
        Employee e = new Employee();

        while (choice != 6) {
            System.out.println("=======Employee Management=======\n1. Add employees\n2. Update employees\n3. Remove employees\n4. Search employees\n5. Sort employees by salary\n6. Exit");
            choice = v.getInteger("Input choice: ", 1, 8);
            switch (choice) {
                case 1:
                    f.addEmployee();
                    break;

                case 2:
                    f.updateEmployee();
                    break;

                case 3:
                    f.removeEmployee();
                    break;

                case 4:
                    f.searchEmployee();
                    break;

                case 5:
                    f.sortBySalary();
                    break;

                case 6:
                    f.display();
                    break;
                case 7:
                    f.add();
                    break;
                case 8:
                    f.display();
                    break;

            }
        }
    }
}
