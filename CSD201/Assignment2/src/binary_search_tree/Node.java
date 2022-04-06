package binary_search_tree;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> left, right;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public Node<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> setLeft(Node<T> left) {
        this.left = left;
        return this;
    }

    public Node<T> getRight() {
        return right;
    }

    public Node<T> setRight(Node<T> right) {
        this.right = right;
        return this;
    }

    public String toString() {
        return data.toString();
    }
}
