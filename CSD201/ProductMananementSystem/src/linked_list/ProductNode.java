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
import product_management.Product;

public class ProductNode {

    public Product data;
    public ProductNode next;

    public ProductNode() {
    }

    public ProductNode(Product data) {
        this.data = data;
    }

    public ProductNode(Product data, ProductNode next) {
        this.data = data;
        this.next = next;
    }

    public Product getData() {
        return data;
    }

    public void setData(Product data) {
        this.data = data;
    }

    public ProductNode getNext() {
        return next;
    }

    public void setNext(ProductNode next) {
        this.next = next;
    }

}
