package j1.s.h208;

public class main {

    public static long[] intToArray(long n) {
        int length = 0;
        //get the array length
        for (long k = n; k > 0; k /= 10) {
            length++;
        }
        long[] arr = new long[length];
        for (int i = length - 1; i >= 0; i--) {
            arr[i] += n % 10;
            //12345
            n /= 10;
        }
        return arr;
    }

    public static long arrayToInt(long[] arr) {
        long rst = 0;
        long n = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            rst += arr[i] * n;
            n *= 10;
        }
        return rst;
    }

    public static void swapDigitPairs(long[] arr) {
        int j = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            //swap 2 value
            if (j > 0) {
                //2 1 4 3 6 5
                long tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
            } else {
                return;
            }
            j = j - 2;
        }
    }

    public static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {
        long n = Validation.getInteger("Input integer number: ", 0, Long.MAX_VALUE);
        long[] arr = intToArray(n);
        swapDigitPairs(arr);
        System.out.println(arrayToInt(arr));
    }
}
