package j1.s.h206;

public class main {

    public static void printSquare(int arr[]) {
        //loop i for print line
        for (int i = 0; i < arr.length; i++) {
            //print the elements of the array
            for (int j = i; j < arr.length; j++) {
                System.out.print(arr[j]);
            }
            //print the circular sequence if the previous haven't print all
            for (int k = 0; k < i; k++) {
                System.out.print(arr[k]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int min = Validation.getInteger("Input min value: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int max = Validation.getInteger("Input max value: ", min, Integer.MAX_VALUE);
        int[] arr = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] += min++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        printSquare(arr);
        
    }
}
