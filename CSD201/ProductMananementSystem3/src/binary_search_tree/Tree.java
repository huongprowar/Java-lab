/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package binary_search_tree;

import java.util.ArrayList;

/**
 *
 * @author yuyu
 */
public class Tree<T extends Comparable<T>> {

    private Node<T> root;

    public void clear() {
        root = null;
    }

    public Tree() {
        root = null;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(insert(node.getLeft(), data));
        } else {
            node.setRight(insert(node.getRight(), data));
        }

        return node;
    }

    public void remove(T data) {
        root = remove(root, data);
    }

    private Node<T> remove(Node<T> node, T data) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(remove(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(remove(node.getRight(), data));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            node.setData(maxValue(node.getLeft()));
            node.setLeft(remove(node.getLeft(), node.getData()));
        }

        return node;
    }

    private T minValue(Node<T> node) {
        T min = node.getData();

        while (node.getLeft() != null) {
            min = node.getLeft().getData();
            node = node.getLeft();
        }

        return min;
    }

    private T maxValue(Node<T> node) {
        T max = node.getData();

        while (node.getRight() != null) {
            max = node.getRight().getData();
            node = node.getRight();
        }

        return max;
    }

    public Node<T> search(T data) {
        return search(root, data);
    }

    private Node<T> search(Node<T> node, T data) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.getData()) < 0) {
            return search(node.getLeft(), data);
        } else if (data.compareTo(node.getData()) > 0) {
            return search(node.getRight(), data);
        }

        return node;
    }

    public boolean contains(T data) {
        return search(data) != null;
    }

    public void inorderTraversal(TraversalCallback<T> callback) {
        inorderTraversal(root, callback);
    }

    private void inorderTraversal(Node<T> node, TraversalCallback<T> callback) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.getLeft(), callback);
        callback.traversal(node);
        inorderTraversal(node.getRight(), callback);
    }

    public void preorderTraversal(TraversalCallback<T> callback) {
        preorderTraversal(root, callback);
    }

    private void preorderTraversal(Node<T> node, TraversalCallback<T> callback) {
        if (node == null) {
            return;
        }

        callback.traversal(node);
        preorderTraversal(node.getLeft(), callback);
        preorderTraversal(node.getRight(), callback);
    }

    public void postorderTraversal(TraversalCallback<T> callback) {
        postorderTraversal(root, callback);
    }

    private void postorderTraversal(Node<T> node, TraversalCallback<T> callback) {
        if (node == null) {
            return;
        }

        postorderTraversal(node.getLeft(), callback);
        postorderTraversal(node.getRight(), callback);
        callback.traversal(node);
    }

    public void breadthFirstTraversal(TraversalCallback<T> callback) {
        breadthFirstTraversal(root, callback, new ArrayList<>());
    }

    private void breadthFirstTraversal(Node<T> node, TraversalCallback<T> callback, ArrayList<Node<T>> queue) {
        if (node == null) {
            return;
        }

        callback.traversal(node);

        if (node.getLeft() != null) {
            queue.add(node.getLeft());
        }

        if (node.getRight() != null) {
            queue.add(node.getRight());
        }

        if (queue.size() > 0) {
            Node<T> nextNode = queue.get(0);
            queue.remove(0);
            breadthFirstTraversal(nextNode, callback, queue);
        }
    }

    public void balance() {
        ArrayList<T> list = new ArrayList<>();

        inorderTraversal((node) -> {
            list.add(node.getData());
        });

        root = null;
        balance(list, 0, list.size() - 1);
    }

    private void balance(ArrayList<T> list, int l, int r) {
        if (l > r) {
            return;
        }
        int k = (l + r) / 2;
        insert(list.get(k));
        balance(list, l, k - 1);
        balance(list, k + 1, r);
    }
}
