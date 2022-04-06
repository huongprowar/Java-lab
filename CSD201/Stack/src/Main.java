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
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        
        stack.push(1);
        stack.push(6);
        stack.push(13);
        stack.push(19);
        
        while (!stack.isEmpty()) {
            System.out.print(stack.top() + " ");
            stack.pop();
        }
    }
}
