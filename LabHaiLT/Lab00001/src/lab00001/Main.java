package lab00001;

public class Main {

    //bubble sort algorithm
    public static void sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //swap 2 value
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

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

    public static void main(String[] args) {
        //input the size of an array
        int arrLength = Validation.getInteger("Enter size of array: ", 1, Integer.MAX_VALUE);
        int[] arr = new int[arrLength];
        int min = 0;
        int max = 0;
        //get the min max values
        
            //input any integer value from -2147483648 to 2147483647
            min = Validation.getInteger("Please input min value: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            max = Validation.getInteger("Please input max value: ", min, Integer.MAX_VALUE);
            //if min value > max value, repeat the loop until correct                    
        //generate an random number array in the range
        for (int i = 0; i < arrLength; i++) {
            arr[i] = (int) (Math.random() * (max - min + 1)) + min;
            //min=2;max=10 yeu cau [2,10]
            //[0,1) * (max-min) = [0,8);
            //[0,1) * (max-min) + min = [2,10);
            //[0,1) * (max-min+1) + min = [2,11) = [2,10];
        }
        System.out.print("Unsorted array: ");
        display(arr);
        sort(arr);
        System.out.print("\nSorted array: ");
        display(arr);
    }
}
