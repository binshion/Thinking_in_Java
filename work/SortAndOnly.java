package work;

import java.util.Arrays;
import java.util.Scanner;

public class SortAndOnly {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            int n = scan.nextInt();
            int[] array = new int[n];
            for(int i = 0; i < n; i++) {
                int temp = scan.nextInt();
                array[i] = temp;
            }

            Arrays.sort(array);

            for(int i = 0; i < array.length; i++) {
                if((i > 0 && array[i] != array[i - 1]) || i == 0) {
                    System.out.println(array[i]);
                }
            }
        }

    }
}
