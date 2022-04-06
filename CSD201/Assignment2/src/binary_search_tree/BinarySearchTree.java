package binary_search_tree;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<T>(data);
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

            node.setData(minValue(node.getRight()));
            node.setRight(remove(node.getRight(), node.getData()));
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

    public boolean contains(T data) {
        return search(root, data) != null;
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
        } else {
            return node;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return size(node.getLeft()) + 1 + size(node.getRight());
    }

    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public void traversalInorder(TraversalCallback<T> callback) {
        traversalInorder(root, callback);
    }

    public static <T extends Comparable<T>> void traversalInorder(Node<T> node, TraversalCallback<T> callback) {
        if (node == null) {
            return;
        }

        traversalInorder(node.getLeft(), callback);
        callback.traversal(node);
        traversalInorder(node.getRight(), callback);
    }

    public void traversalPreorder(TraversalCallback<T> callback) {
        traversalPreorder(root, callback);
    }

    public static <T extends Comparable<T>> void traversalPreorder(Node<T> node, TraversalCallback<T> callback) {
        if (node == null) {
            return;
        }

        callback.traversal(node);
        traversalPreorder(node.getLeft(), callback);
        traversalPreorder(node.getRight(), callback);
    }

    public void traversalPostorder(TraversalCallback<T> callback) {
        traversalPostorder(root, callback);
    }

    public static <T extends Comparable<T>> void traversalPostorder(Node<T> node, TraversalCallback<T> callback) {
        if (node == null) {
            return;
        }

        traversalPostorder(node.getLeft(), callback);
        traversalPostorder(node.getRight(), callback);
        callback.traversal(node);
    }

    public void traversalBreadthFirst(TraversalCallback<T> callback) {
        traversalBreadthFirst(root, callback);
    }

    public static <T extends Comparable<T>> void traversalBreadthFirst(Node<T> node, TraversalCallback<T> callback) {
        if (node == null) {
            return;
        }

        java.util.Queue<Node<T>> queue = new java.util.LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node<T> current = queue.remove();
            callback.traversal(current);

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }

    public Node<T> getRoot() {
        return root;
    }

    public void clear() {
        root = null;
    }

    public void balance() {
        ArrayList<T> list = new ArrayList<>();

        traversalInorder((node) -> {
            list.add(node.getData());
        });

        clear();
        balance(this, list, 0, list.size() - 1);
    }

    public void balance(Node<T> node) {
        ArrayList<T> list = new ArrayList<>();

        traversalInorder(node, (v) -> {
            list.add(v.getData());
        });

        BinarySearchTree<T> tree = new BinarySearchTree<>();
        balance(tree, list, 0, list.size() - 1);

        node.setData(tree.getRoot().getData());
        node.setLeft(tree.getRoot().getLeft());
        node.setRight(tree.getRoot().getRight());
    }

    private static <T extends Comparable<T>> void balance(BinarySearchTree<T> tree, ArrayList<T> list, int start,
            int end) {
        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;
        tree.insert(list.get(mid));

        balance(tree, list, start, mid - 1);
        balance(tree, list, mid + 1, end);
    }
}
