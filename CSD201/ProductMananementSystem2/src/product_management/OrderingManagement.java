/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package product_management;

import linked_list.*;
import utilities.Input;

/**
 *
 * @author yuyu
 */
public class OrderingManagement {

    LinkedList<Ordering> list;

    public OrderingManagement() {
        list = new LinkedList<>();
    }

    public void insertData() {
        Ordering p = new Ordering();

        p.setPcode(Input.getString("Enter product code: "));
        p.setCcode(Input.getString("Enter customer code: "));
        p.setQuantity(Input.getIntegerInclusive("Enter quantity: ", 0, Integer.MAX_VALUE));

        list.addTail(p);
    }

    public void display() {
        list.forEach((value) -> {
            System.out.println(value);
        });
    }

    public void sort() {
        list.sort((a, b) -> a.compareTo(b));
    }
}
