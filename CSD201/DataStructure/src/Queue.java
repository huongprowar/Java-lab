// ======= DO NOT EDIT THIS FILE =============
//This queue is used for Graph breadth-first traversal
//----------------------------------------------------------------------

import java.util.*;

public class Queue {

    LinkedList<String> t;

    Queue() {
        t = new LinkedList<String>();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void clear() {
        t.clear();
    }

    void enqueue(String x) {
        t.addLast(x);
    }

    String dequeue() {
        if (isEmpty()) {
            return (null);
        }
        return (t.removeFirst());
    }

    String front() {
        if (isEmpty()) {
            return (null);
        }
        return (t.getFirst());
    }
}
