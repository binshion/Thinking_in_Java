package sort;

public class BubbleSort {
    public static void bubbleSort(int[] arrays) {
        if(arrays.length < 2 || arrays == null) return;
        //外层循环排序的趟数
        for(int i = 0; i < arrays.length - 1; i++) {

            //初始化当前趟数是否已经是排好序的
            boolean isChanged = false;

            //内层循环是当前趟数需要比较的次数
            for(int j = 0; j < arrays.length - 1 - i; j++) {

                //如果前一位比后一位数大，则交换位置
                if(arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                    isChanged = true;  //该趟发生过顺序调换
                }
            }

            //该趟未发生顺序调换，已排好序，退出循环
            if(!isChanged) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 5, 4};

        bubbleSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
