/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package graph;

import queue_and_stack.*;

/**
 *
 * @author yuyu
 */
public class Graph {

    int[][] matrix;
    int size;
    char[] vertices;

    public Graph(char[] vertices, int[][] matrix) {
        this.matrix = matrix.clone();
        this.size = matrix.length;
        this.vertices = vertices;
    }

    private void breadth(int init, boolean[] isExist) {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(init);
        isExist[init] = true;

        while (!queue.isEmpty()) {
            int x = queue.dequeue();

            System.out.print(vertices[x] + " ");

            for (int i = 0; i < size; i++) {
                if (matrix[x][i] > 0 && !isExist[i]) {
                    queue.enqueue(i);
                    isExist[i] = true;
                }
            }
        }
    }

    public void breadth(int init) {
        boolean[] isExist = new boolean[size];

        breadth(init, isExist);

        for (int i = 0; i < size; i++) {
            if (!isExist[i]) {
                breadth(i, isExist);
            }
        }
    }

    private void depth(int init, boolean[] isExist) {
        System.out.print(vertices[init] + " ");
        isExist[init] = true;

        for (int i = 0; i < size; i++) {
            if (matrix[init][i] > 0 && !isExist[i]) {
                depth(i, isExist);
            }
        }
    }

    public void depth(int init) {
        boolean[] isExist = new boolean[size];

        depth(init, isExist);

        for (int i = 0; i < size; i++) {
            if (!isExist[i]) {
                depth(i, isExist);
            }
        }
    }
}
