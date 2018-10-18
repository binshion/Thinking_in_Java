package sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 5, 4};
        SelectSort.selectSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void selectSort(int[] a) {
        int temp;  //临时交换数据
        int minIndex;  //假定最小值位置

        //外循环控制次数
        for(int i = 0; i < a.length - 1; i++) {
            minIndex = i;  //假定最小值为第一位

            //找出比最小值还小的数
            for(int j = i + 1; j < a.length; j++) {
                if(a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }

            //存在比假设的最小值小的数时，交换位置
            if(minIndex != i) {
                temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }
}
