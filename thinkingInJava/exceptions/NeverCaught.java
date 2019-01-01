package thinkingInJava.exceptions;

/**
 * 不受检查异常
 * 如果RuntimeException没有被捕获而直达main()，那么在程序退出前
 * 将调用异常的printStackTrace()方法。
 */
public class NeverCaught {
    static void f() {
        throw new RuntimeException("From f()");
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
    }
}
