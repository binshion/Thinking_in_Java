package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] a = {1, 2,3,5,4};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void heapSort(int[] a) {
        if(a.length < 2 || a == null) return;

        buildMaxHeap(a);  //第一次排序时构建最大堆

        for(int i = a.length - 1; i >= 1; i--) {
            swap(a, 0, i);

            maxHeap(a, i, 0);
        }
    }

    public static void buildMaxHeap(int[] a) {
        if(a.length < 2 || a == null) {
            return;
        }

        int cursor = a.length / 2;
        for(int i = cursor; i >= 0; i--) {
            maxHeap(a, a.length, i);
        }
    }

    public static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static void maxHeap(int[] a, int size, int index) {
        int left = 2 * index + 1; //左子节点
        int right = 2 * index + 2;  //右子节点
        int max = index;  //假定最大值为当前节点

        if(left < size && a[left] > a[max]) {
            max = left;
        }
        if(right < size && a[right] > a[max]) {
            max = right;
        }

        if(max != index) {
            swap(a, max, index);
            maxHeap(a, size, max);
        }
    }
}
