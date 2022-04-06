/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */

/**
 *
 * @author yuyu
 */
public class LinkedList {

    Node head, tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    // add: head - tail
    // addAfter(node): 
    // remove(node): remove mot node
    // remove(head): remove(tail)
    // traverse: head -> head.next -> head.next.next -> head.next.next.next -> .next = null : tail
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void addHead(int value) {
        // tao mot node
        Node node = new Node(value, head);
        head = node;

        // neu trong truong hop, node nay la node duy nhat
        if (head.next == null) {
            tail = head;
        }
    }

    public void addTail(int value) {
        if (isEmpty()) {
            addHead(value);
        } else {
            Node node = new Node(value);
            tail.next = node;
            tail = node;
        }
    }

    public void addAfter(Node node, int value) {
        if (node == tail) {
            addTail(value);
        } else if (node != null) {
            Node temp = new Node(value, node.next);
            node.next = temp;
        }
    }

    public void remove(Node node) {
        if (node == null || isEmpty()) {
            return;
        }

        if (node == head) {
            head = head.next;
        } else {
            Node it = head, pre = null;

            while (it != null) {
                if (it == node) {
                    break;
                }
                pre = it;
                it = it.next;
            }

            if (pre != tail) {
                pre.next = node.next;

                if (pre.next == null) {
                    tail = pre;
                }
            }
        }
    }

    public void removeHead() {
        remove(head);
    }

    public void removeTail() {
        remove(tail);
    }

    public void traverse() {
//        Node it = head;
//
//        while (it != null) {
//            // code here
//            
//            it = it.next;
//        }
        
        
        for (Node it = head; it != null; it = it.next) {
            // code here
            System.out.print(it.value + " ");
        }
    }
}
