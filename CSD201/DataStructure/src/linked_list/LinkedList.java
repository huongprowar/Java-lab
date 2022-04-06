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
public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    // O(1)
    public LinkedList() {
        head = null;
        tail = null;
    }

    // O(1)
    public boolean isEmpty() {
        return head == null || tail == null;
    }

    // O(n)
    public int size() {
        int count = 0;
        for (Node<T> it = head; it != null; it = it.next) {
            count++;
        }
        return count;
    }

    // O(1)
    public void clear() {
        head = null;
        tail = null;
    }

    // O(1)
    public Node<T> addHead(T value) {
        head = new Node<>(value, head);
        if (tail == null) {
            tail = head;
        }
        return head;
    }

    // O(1)
    public Node<T> addTail(T value) {
        if (isEmpty()) {
            return addHead(value);
        }

        tail.next = new Node<>(value);
        tail = tail.next;
        return tail;
    }

    // O(n)
    public Node<T> remove(Node<T> node) {
        Node<T> curr = head, prev = null;

        while (curr != null && curr != node) {
            prev = curr;
            curr = curr.next;
        }

        if (prev != null) {
            prev.next = node.next;
            if (prev.next == null) {
                tail = prev;
            }
        } else if (!isEmpty()) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            return null;
        }
        return node;
    }

    // O(1)
    public Node<T> removeHead() {
        return remove(head);
    }

    // O(n)
    public Node<T> removeTail() {
        return remove(tail);
    }

    // O(n)
    public void traverse(TraverseFunction<T> callback) {
        for (Node<T> it = head; it != null; it = it.next) {
            callback.traverse(it);
        }
    }
}
