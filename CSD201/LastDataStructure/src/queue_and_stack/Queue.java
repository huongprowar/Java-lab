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
public class Queue<T> {
    // linked-list
    // head - ... - ... - ... - ... - ... - tail
    // FIFO
    // enqueue -> tail
    // dequeue -> head

    linked_list.LinkedList<T> list;

    public Queue() {
        list = new LinkedList<>();
    }

    public void enqueue(T value) {
        list.addTail(value);
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        return list.removeHead().value;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
