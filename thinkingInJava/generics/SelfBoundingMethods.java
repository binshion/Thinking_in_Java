package thinkingInJava.generics;

/**
 * 自限定用于泛型方法
 */
public class SelfBoundingMethods {
    static <T extends SelfBounded<T>> T f(T arg) {
        return arg.set((arg)).get();
    }

    public static void main(String[] args) {
        A a = f(new A());
    }
}
