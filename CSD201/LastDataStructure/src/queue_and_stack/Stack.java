/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package queue_and_stack;

import linked_list.LinkedList;

/**
 *
 * @author yuyu
 */
public class Stack<T> {
    // linked-list
    // head - ... - ... - ... - ... - ... - tail
    // FILO
    // push -> head O(1)
    // pop  -> head O(1)

    linked_list.LinkedList<T> list;

    public Stack() {
        list = new LinkedList<>();
    }

    public void push(T value) {
        list.addHead(value);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return list.removeHead().value;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
