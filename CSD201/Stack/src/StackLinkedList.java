/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */

/**
 *
 * @author yuyu
 */
public class StackLinkedList {

    LinkedList list;

    public StackLinkedList() {
        list = new LinkedList();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(int value) {
        list.addTail(value);
    }

    public void pop() {
        list.removeHead();
    }

    public Integer top() {
        if (isEmpty()) {
            return null;
        }

        return list.head.value;
    }
}
