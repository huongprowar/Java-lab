package randomnodupe;

import java.util.Scanner;

public class RandomNoDupe {

    public static int[] arrGenerate() {
        int[] arr = new int[11];
        for (int i = 0; i < 11; i++) {
            boolean check = false;
            int tmp = (int) (Math.random() * (11 - 1 + 1) + 1);
            //     while (true) {
            for (int j = 0; j < 11; j++) {
                if (arr[j] == tmp) {
                    check = true;
                }
            }
            if (check) {
                i--;
            } else {
                arr[i] = tmp;
            }
            //  }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[11];
        arr = arrGenerate();
        int i=0;
        while (true) {
            String str = sc.nextLine().trim();
            System.out.println(arr[i]);
            i++;
        }
    }
}
