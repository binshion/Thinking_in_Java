package interviewTest;

import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int times = scan.nextInt();
        int[] prices = new int[times];
        for(int i = 0; i < times; i++){
            prices[i] = scan.nextInt();
        }
        Arrays.sort(prices);
        int n = 1;
        for(int i = 0; i < times; i++){
            if(i > 0 && prices[i] != prices[i - 1]){
                n++;
            }
            if(n == 3){
                System.out.println(prices[i]);
                break;
            }
        }
    }
}
