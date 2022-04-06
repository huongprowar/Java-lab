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

    // O(1)
    public void insertAfter(Node<T> node, T value) {
        if (node == null) {
            return;
        }

        node.next = new Node(value, node.next);
        if (node == tail) {
            tail = node.next;
        }
    }

    // O(n)
    public void insertAfter(int index, T value) {
        Node it = head;

        while (it != null) {
            if (index == 0) {
                break;
            }
            index--;
            it = it.next;
        }

        if (index == 0) {
            insertAfter(it, value);
        }
    }

    // O(1)
    public void insertBefore(Node<T> node, T value) {
        Node it = head, pre = null;

        while (it != null) {
            if (it == node) {
                break;
            }

            pre = it;
            it = it.next;
        }

        if (it == null) {
            return;
        }

        if (pre != null) {
            insertAfter(pre, value);
        } else {
            addHead(value);
        }
    }

    public void insertBefore(int index, T value) {
        if (index == 0) {
            addHead(value);
        } else if (index > 0) {
            insertAfter(index - 1, value);
        }
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

//    public void sortFirstNElements(int n) {
//        Node pi, pj;
//        pi = head;
//        int count = 0;
//        while (pi != null) {
//            count++;
//            pj = pi.next;
//            int count1 = 0;
//            while (pj != null) {
//                count1++;
//               pi la phan tu truoc, pj la sau
//                if (pi.info.type < pj.info.type) {
//                    Ball t = pi.info;
//                    pi.info = pj.info;
//                    pj.info = t;
//                }
//                pj = pj.next;
//                if (count1 == n - count) {
//                    break;
//                }
//            }
//            pi = pi.next;
//            if (count == n - 1) {
//                break;
//            }
//        }
//    }
    
    // O(n^2)
    public void sort() {
        while (!isEmpty()) {
            boolean isSorted = true;

            for (Node<T> it = head; it.next != null; it = it.next) {
                if (/*dieu kien sort*/false) {
                    T data = it.value;
                    it.value = it.next.value;
                    it.next.value = data;

                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }
        }
    }
}
