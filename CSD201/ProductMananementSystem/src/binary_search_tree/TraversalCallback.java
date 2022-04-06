package binary_search_tree;


public interface TraversalCallback<T extends Comparable<T>> {

    public void traversal(Node<T> node);
}
