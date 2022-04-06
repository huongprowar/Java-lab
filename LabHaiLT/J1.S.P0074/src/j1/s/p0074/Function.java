/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0074;

/**
 *
 * @author PC
 */
public class Function {

    Validation v = new Validation();

    public int[][] getMatrix(int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {            
            for (int j = 0; j < col; j++) {
                matrix[i][j] = v.getInteger("Enter Matrix1[" + (i + 1) + "][" + (j + 1) + "]:", Integer.MIN_VALUE, Integer.MAX_VALUE);                
            }
        }
        return matrix;
    }

    public void display(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public int[][] addMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] rst = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                rst[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return rst;
    }

    public int[][] subMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] rst = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                rst[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return rst;
    }

    public int[][] mulMatrix(int[][] matrix1, int[][] matrix2) {        
        int[][] rst = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    rst[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return rst;
    }
}
