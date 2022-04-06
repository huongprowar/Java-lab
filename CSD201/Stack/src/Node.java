/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */

/**
 *
 * @author yuyu
 */
public class Node {

    public int value;
    public Node next;

    public Node() {
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}
