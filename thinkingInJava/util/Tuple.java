package thinkingInJava.util;

/**
 * 简化元组的使用
 */
public class Tuple {
    public static <A,B> TwoTuple<A,B> tuple(A a, B b) {
        return new TwoTuple<A,B>(a, b);
    }
}
