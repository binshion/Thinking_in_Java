package interviewTest;

public class FindSubstr {
    /**查找给定字符串的子串
     * 要求不能使用内置方法如IndexOf, subString等
     * 找到返回1，否则返回0
     */
    public static int findSubstr(String str, String substr) {
        //边界排除
        if(str == null || substr == null || str.length() < substr.length()) {
            return 0;
        }

        char[] aStr = str.toCharArray();
        char[] aSubstr = substr.toCharArray();

        for(int i = 0; i <= aStr.length - aSubstr.length; i++) {
            int j = 0;  //子串初始位置字符
            while (j < aSubstr.length) {
                if(aSubstr[j] == aStr[i + j]) {
                    j++;
                }
                else {
                    break;
                }
            }

            if(j == aSubstr.length) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int a = findSubstr("aaabcccc", "abcd");
        System.out.println(a);
    }
}
