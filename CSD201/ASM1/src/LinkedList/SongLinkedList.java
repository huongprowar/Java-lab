package LinkedList;

import asm1.Song;

public class SongLinkedList {

    Node head, tail;

    public SongLinkedList() {
        head = tail = null;
    }

    public void addHead(Song song) {
        head = new Node(song, head);

        if (tail == null) {
            tail = head;
        }
    }

    public void addTail(Song song) {
        Node node = new Node(song);

        if (tail != null) {
            tail.next = node;
        }

        tail = node;

        if (head == null) {
            head = tail;
        }
    }

    public boolean isEmpty() {
        return head == null || tail == null;
    }

    public void traverse() {
        Node node = head;
        while (node != null) {
            System.out.println(node.info);
            node = node.next;
        }
    }

    public int size() {
        int result = 0;
        Node node = head;
        while (node != null) {
            result++;
            node = node.next;
        }
        return result;
    }

    public void remove(Node node) {
        if (isEmpty()) {
            return;
        }

        Node p = head, prev = null;
        while (p != null) {
            if (p == node) {
                break;
            }
            prev = p;
            p = p.next;
        }

        if (prev != null) {
            prev.next = node.next;
        } else {
            head = head.next;
        }
    }

    public void sortByName() {
        while (true) {
            boolean isSorted = true;

            Node p = head;
            while (p != null && p.next != null) {
                if (p.info.getName().compareTo(p.next.info.getName()) > 0) {
                    Song tmp = p.info;
                    p.info = p.next.info;
                    p.next.info = tmp;

                    isSorted = false;
                }
                p = p.next;
            }

            if (isSorted) {
                break;
            }
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
}
