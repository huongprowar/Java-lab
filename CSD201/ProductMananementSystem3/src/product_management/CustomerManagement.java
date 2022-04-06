/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package product_management;

import linked_list.Node;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import linked_list.LinkedList;
import utilities.Input;

/**
 *
 * @author yuyu
 */
public class CustomerManagement {

    LinkedList<Customer> list;

    public CustomerManagement() {
        list = new LinkedList<>();
    }

    public void loadDataFromFile(String filename) {
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                for (Object o : reader.lines().toArray()) {
                    String line = (String) o;
                    String[] tokens = line.split("\\|");

                    if (tokens.length == 5) {
                        list.addTail(new Customer(
                                tokens[0].trim(),
                                tokens[1].trim(),
                                tokens[2].trim()
                        ));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Cannot open file");
        }
    }

    public Node<Customer> findCustomerByCode(String code) {
        return list.find(new Customer(code, "", ""));
    }

    public void insertData() {
        Customer p = new Customer();

        p.setCcode(Input.getString("Enter customer code: ", (value) -> {
            if (findCustomerByCode(value) != null) {
                System.out.println("Thang nay da ton tai");
                return false;
            }
            return true;
        }));

        p.setCname(Input.getString("Enter customer name: "));
        p.setPhone(Input.getString("Enter phone: ", "\\d+"));

        list.addTail(p);
    }

    public void display() {
        list.forEach((value) -> {
            System.out.println(value);
        });
    }

    public void saveToFile(String filename) {
        try {
            try (FileWriter fw = new FileWriter(new File(filename))) {
                list.forEach((value) -> {
                    try {
                        fw.append(value.toString() + "\n");
                    } catch (Exception e) {
                    }
                });
            }
        } catch (Exception e) {
        }
    }

    public void searchByCode() {
        String code = Input.getString("Enter customer code: ");

        Node<Customer> node = findCustomerByCode(code);

        if (node == null) {
            System.out.println("Ko ton tai");
        } else {
            System.out.println(node.getData());
        }
    }

    public void deleteByCode() {
        String code = Input.getString("Enter customer code: ");

        Node<Customer> node = findCustomerByCode(code);

        list.remove(node);
    }
}
