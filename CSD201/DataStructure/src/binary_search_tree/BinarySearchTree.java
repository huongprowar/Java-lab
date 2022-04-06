/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package binary_search_tree;

import java.util.ArrayList;
import linked_list.LinkedList;

/**
 *
 * @author yuyu
 */
public class BinarySearchTree {

    public Node root;

    public BinarySearchTree() {
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        Node node = new Node(value);

        Node it = root;
        while (it != null) {
            if (it.value < value) {
                if (it.right == null) {
                    it.right = node;
                    return;
                }
                it = it.right;
            } else {
                if (it.left == null) {
                    it.left = node;
                    return;
                }
                it = it.left;
            }
        }
        root = node;
    }

    public void remove(int value) {
        root = nodeAfterRemove(root, value);
    }

    // remove by copy
    private Node nodeAfterRemove(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (node.value < value) {
            node.right = nodeAfterRemove(node.right, value);
        } else if (node.value > value) {
            node.left = nodeAfterRemove(node.left, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            Node maxNode = node.left;
            while (maxNode.right != null) {
                maxNode = maxNode.right;
            }

            node.value = maxNode.value;
            node.left = nodeAfterRemove(node.left, maxNode.value);
        }

        return node;
    }

    public void inorder() {
        inorder(root);
    }

    // L M R
    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.println(node.value);
        inorder(node.right);
    }

    // M L R
    public void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // L R M
    public void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.value);
    }

    public void breadthFirst() {
        if (root == null) {
            return;
        }
        linked_list.LinkedList<Node> list = new LinkedList<>();
        list.addTail(root); //enqueue

        while (!list.isEmpty()) {
            Node p = list.removeHead().value; //dequeue

            System.out.println(p.value);

            if (p.left != null) {
                list.addTail(p.left);
            }

            if (p.right != null) {
                list.addTail(p.right);
            }
        }
    }

    public void rotateRight() {
        root = rotateRight(root.left, root);
    }

    public void rotateLeft() {
        root = rotateLeft(root.right, root);
    }

    public Node rotateRight(Node node, Node parent) {
        Node tmp = node.right;
        node.right = parent;
        parent.left = tmp;

        return node;
    }

    public Node rotateLeft(Node node, Node parent) {
        Node tmp = node.left;
        node.left = parent;
        parent.right = tmp;

        return node;
    }

    public void selfBalance() {
        ArrayList<Integer> list = new ArrayList<>();
        inorderAddToArray(list, root);

        root = null;
        balance(list, 0, list.size() - 1);
    }

    private void balance(ArrayList<Integer> list, int l, int r) {
        if (l > r) {
            return;
        }

        int middle = (l + r) / 2;
        insert(list.get(middle));
        balance(list, l, middle - 1);
        balance(list, middle + 1, r);
    }

    public void inorderAddToArray(ArrayList<Integer> list, Node node) {
        if (node == null) {
            return;
        }
        inorderAddToArray(list, node.left);
        list.add(node.value);
        inorderAddToArray(list, node.right);
    }

}
