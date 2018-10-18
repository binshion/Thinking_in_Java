import java.util.ArrayList;

public class NumChange {
    public static void main(String[] args) {
        int number = 401;
        n2ten(number, 8);
        ten2n(257, 8);
    }

    public static void n2ten(int number, int n) {
        char[] chars = Integer.toString(number).toCharArray();
        int num;
        int result = 0;
        int base = 1;
        for(int i = chars.length - 1; i >= 0; i--) {
            num = Character.getNumericValue(chars[i]);
            result += num * base;
            base *= n;
        }

        System.out.println(result);
    }

    public static void ten2n(int number, int n) {
        String str = "";
        for(int i = number; i > 0; i /= n) {
            str = i % n + str;
        }
        System.out.println(str);
    }
}
