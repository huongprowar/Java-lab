package LinkedList;

import asm1.Song;

public class Node {

    public Song info;
    public Node next;

    Node() {
    }

    Node(Song x, Node q) {
        info = x;
        next = q;
    }

    Node(Song x) {
        this(x, null);
    }
}
