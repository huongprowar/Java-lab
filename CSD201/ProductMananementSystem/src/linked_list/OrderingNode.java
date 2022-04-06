package linked_list;

import product_management.Ordering;

public class OrderingNode {

    public Ordering data;
    public OrderingNode next;

    public OrderingNode() {
    }

    public OrderingNode(Ordering data) {
        this.data = data;
    }
    
    public OrderingNode(Ordering data, OrderingNode next) {
        this.data = data;
        this.next = next;
    }

}
