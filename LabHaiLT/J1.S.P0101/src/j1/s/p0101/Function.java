package j1.s.p0101;
//(Id, First Name, Last Name, Phone, Email, Address, DOB, Sex, Salary, Egency

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Function extends ArrayList<Employee> {

    SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);
    Validation v = new Validation();
    ArrayList<Employee> list = new ArrayList<>();

    void display() {
        System.out.printf("%-15s | %-15s | %-15s | %-15s | %-30s | %-30s | %-20s | %-5s | %-15s | %-15s\n", "ID", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Egency");
        for (Employee employee : this) {
            System.out.println(employee.toString());
        }
    }

//    boolean checkId(String id) {
//        for (Employee employee : list) {
//            if (employee.getId().equals(id)) {
//                return false;
//            }
//        }
//        return true;
//    }
    Employee findEmployeeById(String id) {
        for (Employee employee : this) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    void addEmployee() {
        Employee e = new Employee();
        while (true) {
            e.setId(v.getStringRegex("Input employee ID: ", "[A-Za-z0-9]+"));
            if (this.isEmpty()) {
                break;
            }
            if (findEmployeeById(e.getId()) == null) {
                break;
            }
            System.out.println("The id is duplicate!");
        }
        e.setFirstName(v.getStringRegex("Input employee First Name: ", "[A-Za-z\\s]+"));
        e.setLastName(v.getStringRegex("Input employee Last Name: ", "[A-Za-z\\s]+"));
        e.setPhone(v.getStringRegex("Input employee phone: ", "0[0-9]{9,10}+"));
        e.setEmail(v.getStringRegex("Input employee email: ", "[A-Za-z]\\w*(\\.\\w+)*@(\\w+\\.)+\\w+"));//ngohainam@fpt.edu.vn
        e.setAddress(v.getString("Input employee address: "));
        e.setDob(v.getDate("Input employee date of birth: ", "dd/MM/yyyy"));
        e.setSex(v.getStringRegex("Input employee sex: ", "[FMfm]"));
        e.setSalary(v.getDouble("Input employee salary: ", 0, Double.MAX_VALUE));
        e.setEgency(v.getStringRegex("Input employee egency: ", "[A-Za-z]+"));
        this.add(e);
    }

    void updateEmployee() {
        if (this.isEmpty()) {
            System.out.println("List empty, nothing to update");
            return;
        }
        String id = v.getStringRegex("Input employee ID: ", "[A-Za-z0-9]+");
        Employee tmp = findEmployeeById(id);
        if (tmp == null) {
            System.out.println("ID not found");
            return;
        }
        tmp.setFirstName(v.getStringRegex("Input employee First Name: ", "[A-Za-z\\s]+"));
        tmp.setLastName(v.getStringRegex("Input employee Last Name: ", "[A-Za-z\\s]+"));
        tmp.setPhone(v.getStringRegex("Input employee phone: ", "0[0-9]{9,10}+"));
        tmp.setEmail(v.getStringRegex("input employee email: ", "[A-Za-z]\\w*(\\.\\w+)*@(\\w+\\.)\\w+"));
        tmp.setAddress(v.getString("Input employee address: "));
        tmp.setDob(v.getDate("Input employee date of birth: ", "dd/MM/yyyy"));
        tmp.setSex(v.getStringRegex("Input employee sex: ", "[FMfm]"));
        tmp.setSalary(v.getDouble("Input employee salary: ", 0, Double.MAX_VALUE));
        tmp.setEgency(v.getStringRegex("Input employee egency: ", "[A-Za-z]+"));
    }

    void removeEmployee() {
        if (this.isEmpty()) {
            System.out.println("List empty, nothing to remove");
            return;
        }
        String id = v.getStringRegex("Input employee ID: ", "[A-Za-z0-9]+");
        Employee tmp = findEmployeeById(id);
        if (tmp == null) {
            System.out.println("ID not found");
            return;
        }
        this.remove(tmp);
    }

    void searchEmployee() {
        if (this.isEmpty()) {
            System.out.println("List empty, nothing to find");
            return;
        }
        Function lst = new Function();
        String name = v.getStringRegex("Input Employee name to search: ", "[A-Za-z\\s]+");
        for (Employee employee : this) {
            String fullName = employee.getFirstName() + " " + employee.getLastName();
            if (fullName.toLowerCase().contains(name)) {
                lst.add(employee);
            }
        }
        if (lst.isEmpty()) {
            System.out.println("Not found employee");
            return;
        }
        lst.display();
    }

    void sortBySalary() {
        if (this.isEmpty()) {
            System.out.println("Nothing to sort!");
            return;
        }
        Collections.sort(this);
    }

    void add() throws ParseException {
        Employee e1 = new Employee("HE163297", "Ngo Hai", "Nam", "0364104616", "huongprowar@gmail.com", "Viet Nam", SDF.parse("25/12/2002"), "M", 223.7, "BT");
        Employee e2 = new Employee("HE162564", "Chu Minh", "Trung", "0983068976", "chuminhtrung@gmail.com", "Viet Nam", SDF.parse("12/10/2002"), "F", 132.45, "Non");
        Employee e3 = new Employee("HE163060", "Trieu Dinh", "Quang", "0378625876", "quandinhtrieu@gmail.com", "Ha Long", SDF.parse("11/06/2002"), "M", 435.3, "ThongMinh");
        this.add(e1);
        this.add(e2);
        this.add(e3);
    }
}
