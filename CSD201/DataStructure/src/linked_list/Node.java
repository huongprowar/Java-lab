/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package linked_list;

/**
 *
 * @author yuyu
 */
public class Node<T> {

    public T value;
    public Node<T> next;

    public Node() {
    }

    public Node(T value) {
        this(value, null);
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}
