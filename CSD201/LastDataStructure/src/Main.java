
import binary_search_tree.*;
import graph.Graph;

/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
/**
 *
 * @author yuyu
 */
public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph("ABCDE".toCharArray(), new int[][]{
            {0, 1, 0, 0, 0},
            {1, 0, 1, 0, 1},
            {0, 1, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 1, 1, 1, 0},}
        );

        graph.depth(2);
    }
}
