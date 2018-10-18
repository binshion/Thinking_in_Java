package work;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentScore {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] scores = new int[N];
        for(int i = 0; i < N; i++) {
            int temp = scan.nextInt();
            scores[i] = temp;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            String operateType = scan.next();
            int s1 = scan.nextInt();
            int s2 = scan.nextInt();

            if(operateType.equals("Q")){
                int returnValue = query(scores, s1, s2);
                arrayList.add(returnValue);
            }
            if(operateType.equals("U") ){
                update(scores, s1, s2);
            }
        }

        for(int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

    }

    public static void update(int[] arr, int index, int score) {
        arr[index - 1] = score;
    }

    public static int query(int[] arr, int begin, int end) {
        int left = begin < end ? begin : end;
        int right = begin > end ? begin : end;
        int maxIndex = left - 1;

        for(int i = left - 1; i < right; i++) {
            if(arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }
}
