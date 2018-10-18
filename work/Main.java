package work;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String strFirst = scan.next();
        String strSecond = scan.next();

        int fromFirst = getTenfromSeven(strFirst);
        int fromSecond = getTenfromSeven(strSecond);
        int sum = fromFirst + fromSecond;
        getSevenFromTen(sum);


    }

    public static int getTenfromSeven(String str) {
        char[] chars = str.toCharArray();

        int num;
        int base = 1;
        int temp = 0;
        for(int i = chars.length - 1; i >= 0; i--) {
            num = Character.getNumericValue(chars[i]);
            temp += num * base;
            base *= 7;
        }
        return temp;
    }

    public static void getSevenFromTen(int num) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        int shang = num;
        int yu = 0;
        while (true) {
            yu = shang % 7;
            shang = shang / 7;
            arrayList.add(yu);
            if(shang < 7){
                arrayList.add(shang);
                break;
            }
        }

        for(int i = arrayList.size() - 1; i >= 0; i--) {
            System.out.print(arrayList.get(i));
        }
    }
}
