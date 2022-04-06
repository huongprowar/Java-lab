package j1.s.p0020;

public class main {

    public static void display(int arr[]) {
        //print the first square brackets
        System.out.print("[");
        //print the number out
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            //check to prevent print ',' at the last number
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        //print the last square brackets
        System.out.print("]");
    }

    public static void sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            //find the min value in unsorted array
            int minidx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minidx]) {
                    minidx = j;
                }
            }
            //swap the min value with the first element
            if (minidx != i) {
                int tmp = arr[i];
                arr[i] = arr[minidx];
                arr[minidx] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        //get the array size
        int arrLength = Validation.getInteger("Enter number of array: ", 0, Integer.MAX_VALUE);
        int[] arr = new int[arrLength];
        //user input elements of array
        for (int i = 0; i < arrLength; i++) {
            System.out.println("\nInput elements of array: ");
            arr[i] = Validation.getInteger("", Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        System.out.println("Unsorted: ");
        display(arr);
        sort(arr);
        System.out.println("\nSorted: ");
        display(arr);
    }
}
