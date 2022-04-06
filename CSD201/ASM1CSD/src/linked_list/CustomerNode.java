/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;

/**
 *
 * @author PC
 */
import Product_Management.Customer;

public class CustomerNode {

    public Customer data;
    public CustomerNode next;

    public CustomerNode() {
    }

    public CustomerNode(Customer data) {
        this.data = data;
    }

    public CustomerNode(Customer data, CustomerNode next) {
        this.data = data;
        this.next = next;
    }

}
