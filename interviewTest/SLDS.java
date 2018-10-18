package interviewTest;

import java.util.Scanner;

public class SLDS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            String str = scan.nextLine();
            String subStr = str.substring(2);
            char[] chars = subStr.toCharArray();
            int temp = 0;
            int base = 1;
            int num;

            for(int i = chars.length - 1; i >= 0; i--) {
                num = Character.getNumericValue(chars[i]);

                temp += num * base;
                base *= 16;
            }

            System.out.println(temp);
        }
    }
}
