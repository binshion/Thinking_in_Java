package thinkingInJava.generics;

public class GenericMethods {
    /**
     * 要定义泛型方法，只需将泛型参数列表置于返回值之前
     * @param x
     * @param <T>
     */
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f("c");
        gm.f(gm);
        gm.f(1.0F);
    }
}
