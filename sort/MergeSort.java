package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 1, 8, 4, 2, 7, 6, 9};
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] a, int L, int R) {
        if(L == R) {
            return;
        }

        int M = (L + R) / 2;
        mergeSort(a, L, M);
        mergeSort(a, M + 1, R);
        merge(a, L, M, R);
    }

    public static void merge(int[] a, int L, int M, int R) {
        int[] temp = new int[R - L + 1];
        int i = L;
        int j = M + 1;
        int k = 0;

        while (i <= M && j <= R){
            if(a[i] < a[j]) {
                temp[k++] = a[i++];
            }
            else {
                temp[k++] = a[j++];
            }
        }

        while (i <= M) {
            temp[k++] = a[i++];
        }

        while (j <= R) {
            temp[k++] = a[j++];
        }

        for(i = 0; i < temp.length; i++) {
            a[i + L] = temp[i];
        }
    }
}
