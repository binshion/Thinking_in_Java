package interviewTest;

import java.util.Arrays;
import java.util.Scanner;

public class MMSJS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()){
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }

            Arrays.sort(arr);

            for(int i = 0; i < arr.length; i++) {
                if(i == 0 || (i > 0 && arr[i] != arr[i - 1])){
                    System.out.println(arr[i]);
                }
            }
        }
    }
}
