package thinkingInJava.strings;

/**
 * regular express
 * \\:第一个\:转义第二个\。因为第二个\是正则表达式需要用的
 * ?:0个或1个
 * |：或运算
 * +：在正则表达式中有特殊意义，需要\\转义
 */
public class IntegerMatch {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));
    }
}
