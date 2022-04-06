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
public class main {

    public static void main(String[] args) {
        int choice = 0;
        Function f = new Function();
        Validation v = new Validation();
        while (choice != 4) {
            System.out.println("=======Calculator program=======\n1. Addition Matrix\n2. Subtraction Matrix\n3. Multiplication Matrix\n4. Quit");
            choice = v.getInteger("Input choice: ", 1, 4);
            switch (choice) {
                case 1:
                    int row1 = v.getInteger("Enter Row Matrix 1: ", 1, Integer.MAX_VALUE);
                    int col1 = v.getInteger("Enter Column Matrix 1: ", 1, Integer.MAX_VALUE);
                    int[][] matrix1 = f.getMatrix(row1, col1);
                    
                    

                    int row2 = v.getInteger("Enter Row Matrix 2: ", row1, row1);
                    int col2 = v.getInteger("Enter Column Matrix 2: ", col1, col1);
                    int[][] matrix2 = f.getMatrix(row2, col2);

                    f.display(matrix1);
                    System.out.println("+");
                    f.display(matrix2);
                    System.out.println("=");
                    f.display(f.addMatrix(matrix1, matrix2));
                    break;

                case 2:
                    row1 = v.getInteger("Enter Row Matrix 1: ", 1, Integer.MAX_VALUE);
                    col1 = v.getInteger("Enter Column Matrix 1: ", 1, Integer.MAX_VALUE);
                    matrix1 = f.getMatrix(row1, col1);

                    row2 = v.getInteger("Enter Row Matrix 2: ", row1, row1);
                    col2 = v.getInteger("Enter Column Matrix 2: ", col1, col1);
                    matrix2 = f.getMatrix(row2, col2);

                    f.display(matrix1);
                    System.out.println("-");
                    f.display(matrix2);
                    System.out.println("=");
                    f.display(f.subMatrix(matrix1, matrix2));
                    break;

                case 3:
                    row1 = v.getInteger("Enter Row Matrix 1: ", 1, Integer.MAX_VALUE);
                    col1 = v.getInteger("Enter Column Matrix 1: ", 1, Integer.MAX_VALUE);
                    matrix1 = f.getMatrix(row1, col1);

                    row2 = v.getInteger("Enter Row Matrix 2: ", col1, col1);
                    col2 = v.getInteger("Enter Column Matrix 2: ", 1, Integer.MAX_VALUE);
                    matrix2 = f.getMatrix(row2, col2);
                    f.display(matrix1);
                    System.out.println("*");
                    f.display(matrix2);
                    System.out.println("=");
                    f.display(f.mulMatrix(matrix1, matrix2));
                    break;
                    
                case 4:
                    break;
            }
        }
    }
}
