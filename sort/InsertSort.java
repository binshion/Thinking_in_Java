package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 2};
        InsertSort.insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void insertSort(int[] a) {
        int insertItem;
        //从第二项开始作为插入项
        for(int i = 1; i < a.length; i++) {
            insertItem = a[i];
            int j = i - 1;  //插入项前面已排好序的项目
            for(; j >= 0; j--) {
                if(a[j] > insertItem) {
                    a[j + 1] = a[j];
                }else {  //插入项比初始相邻项大，无需更换插入位置
                    break;
                }
            }

            //发生过调换，说明插入项找到了位置
            if(j != i - 1) {
                a[j + 1] = insertItem;
            }
        }
    }
}
