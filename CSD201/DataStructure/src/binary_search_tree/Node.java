/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package binary_search_tree;

/**
 *
 * @author yuyu
 */
public class Node {

    public int value;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int value) {
        this(value, null, null);
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
