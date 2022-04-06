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
public interface TraversalCallback<T extends Comparable<T>> {

    public void traversal(Node<T> node);
}
