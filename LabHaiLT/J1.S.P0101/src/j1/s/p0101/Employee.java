package j1.s.p0101;
//(Id, First Name, Last Name, Phone, Email, Address, DOB, Sex, Salary, Egency

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Comparable<Employee> {

    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private Date dob;
    private String sex;
    private double salary;
    private String engency;

    SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public Employee() {
    }

    public Employee(String id, String firstName, String lastName, String phone, String email, String address, Date dob, String sex, double salary, String engency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.sex = sex;
        this.salary = salary;
        this.engency = engency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEgency() {
        return engency;
    }

    public void setEgency(String egency) {
        this.engency = egency;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-15s | %-15s | %-15s | %-30s | %-30s | %-20s | %-5s | %-15.2f | %-15s", getId(), getFirstName(), getLastName(), getPhone(), getEmail(), getAddress(), SDF.format(getDob()), getSex().toUpperCase(), getSalary(), getEgency());
    }

    @Override
    public int compareTo(Employee t) {
        return (int)(this.getSalary()-t.getSalary());
    }

}
