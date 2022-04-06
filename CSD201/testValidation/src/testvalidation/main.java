/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testvalidation;

/**
 *
 * @author PC
 */
public class main {
    public static void main(String[] args) {
        TestValidation t = new TestValidation();
        String name = t.checkString("Enter your name: ", "(\\w+\\s{0,1})+");
        String addr = t.checkString("Enter your address: ", "(\\w+\\s{0,1})*");
        String phone = t.checkString("Enter your phone: ", "(\\+\\d{1,2}\\s?)?(\\d){10,11}");
        String email = t.checkString("Enter your email: ", "[a-zA-Z]\\w+@\\w+(\\.\\w+){1,3}");
        String date = t.checkDate("Enter date: ", "dd/MM/yyyy");
        int menuChoice = t.checkInt("Enter your choice 1-5", 1, 5);
        int integer = t.checkInt("Enter any integer number", Integer.MIN_VALUE, Integer.MAX_VALUE);        
        int posInt = t.checkInt("Enter any positive integer number", 0, Integer.MAX_VALUE);        
        int nigInt = t.checkInt("Enter any positive integer number", Integer.MIN_VALUE, -1);        
        System.out.println("\nYou've just inputed:\n");
        System.out.println("Name: "+name);
        System.out.println("Address: "+addr);
        System.out.println("Phone: "+phone);
        System.out.println("Email: "+email);
        System.out.println("Date: "+date);
    }
}
