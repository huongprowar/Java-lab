
import Validation.Validation;
import binary_search_tree.*;
import linked_list.*;

/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
/**
 *
 * @author yuyu
 */
public class Main {

    public static Validation v = new Validation();

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Stack stack = new Stack();
        Queue queue = new Queue();
//        LinkedList<Integer> list = new LinkedList<>();
//        list.addHead(2);
//        list.addTail(6);
//        list.addTail(9);
//        Node<> p = head; 
        String s = v.getString("Input string: ");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                queue.dequeue();
            } else {
                queue.enqueue(s.charAt(i) + "");
            }
        }
        //       System.out.println("false");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue());
        }
    }
}
