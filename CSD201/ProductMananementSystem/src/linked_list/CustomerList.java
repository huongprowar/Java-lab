/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;
import product_management.Customer;
import java.io.FileWriter;

/**
 *
 * @author PC
 */
public class CustomerList {

    private CustomerNode head, tail;

    public CustomerList() {
    }

    public void clear() {
        head = tail = null;
    }

    public void addTail(Customer data) {
        CustomerNode node = new CustomerNode();
        node.data = data;

        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void loadDataFromFile(String filename) {
        try {
            Scanner sc = new Scanner(new File(filename));

            sc.useLocale(Locale.US);

            while (sc.hasNext()) {
                String line = sc.nextLine();

                String[] tokens = line.split("\\|");

                if (tokens.length == 3) {
                    addTail(new Customer(tokens[0].trim(), tokens[1].trim(), tokens[2].trim()));
                }
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Loi khi load data!");
        }
    }

    public CustomerNode findCustomerByCode(String ccode) {
        if (head == null && tail == null) {
            return null;
        }
        CustomerNode it = head;
        while (it != null) {
            if (it.data.getCcode().equals(ccode)) {
                return it;
            }
            it = it.next;
        }

        return null;
    }

    public void addCustomerToTheEnd() {
        Scanner sc = new Scanner(System.in);

        System.out.print("ccode: ");
        String ccode = sc.nextLine();

        if (findCustomerByCode(ccode) != null) {
            System.out.println("Da ton tai!");
            return;
        }
        System.out.print("cus_name: ");
        String cus_name = sc.nextLine();

        System.out.print("phone: ");
        String phone = sc.nextLine();

        addTail(new Customer(ccode, cus_name, phone));

        System.out.println("Them thanh cong!");
    }

    public void display() {
        CustomerNode it = head;
        System.out.printf("%6s | %20s | %10s \n",
                "ccode", "cus_name", "phone");

        System.out.println("-------------------------------------------------------------------------------------");
        while (it != null) {
            System.out.printf("%6s | %20s | %10s \n",
                    it.data.getCcode(),
                    it.data.getCname(),
                    it.data.getPhone());
            it = it.next;
        }
    }

    public void saveDataToFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            CustomerNode it = head;
            while (it != null) {
                String line = String.format(Locale.US, "%6s | %20s | %10s\n",
                        it.data.getCcode(),
                        it.data.getCname(),
                        it.data.getPhone());
                fw.append(line);
                it = it.next;
            }

            fw.close();
        } catch (Exception e) {
            System.out.println("Loi khi save file!");
        }
    }

    public void searchByCCode() {
        Scanner sc = new Scanner(System.in);

        String code = sc.nextLine();

        CustomerNode customerNode = findCustomerByCode(code);

        if (customerNode != null) {
            System.out.printf("Found: %6s | %10s | %10s\n",
                    customerNode.data.getCcode(),
                    customerNode.data.getCname(),
                    customerNode.data.getPhone());
        } else {
            System.out.println("Not found!");
        }
    }

    public void deleteByCCode() {
        Scanner sc = new Scanner(System.in);

        System.out.print("ccode: ");
        String code = sc.nextLine();

        CustomerNode customerNode = findCustomerByCode(code);

        remove(customerNode);
        System.out.println("xoa thanh cong!");
    }

    public void remove(CustomerNode node) {
        if (node == null) {
            return;
        }

        if (node == tail) {
            CustomerNode it = head;
            CustomerNode previousTail = null;
            while (it.next != null) {
                previousTail = it;
                it = it.next;
            }

            tail = previousTail;
            tail.next = null;
        } else {
            node.data = node.next.data;
            node.next = node.next.next;
        }
    }

}
