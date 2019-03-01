package thinkingInJava.containers;

/**
 * 程序中包含对个相同的字符串序列，那么这些String
 * 对象都映射在同一块内存区域。new String()出来的
 * 两个对象实例，虽然是相互独立的，但是对它们使用
 * hashcode应该生成同样的结果。
 */
public class StringHashCode {
    public static void main(String[] args){
        String[] hellos = "Hello Hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
    }
}
