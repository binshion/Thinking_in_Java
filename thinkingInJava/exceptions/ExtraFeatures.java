package thinkingInJava.exceptions;

/**
 * 新的异常类添加了字段x以及get set方法。此外还覆盖了Throwable.getMessage()方法，
 * 以产生更详细的信息。对于异常类来说，getMessage()有点类似于toString（）方法。
 */
class MyException2 extends Exception {
    private int x;

    public MyException2() {}

    public MyException2(String msg) {
        super(msg);
    }

    public MyException2(String msg, int x) {
        super(msg);
        this.x = x;
    }

    public int val() {
        return x;
    }

    public String getString() {
        return "Detail Message: " + x + " " + super.getMessage();
    }
}

public class ExtraFeatures {
    public static void f() throws MyException2 {
        System.out.println("Throwing MyException2 from f()");
        throw new MyException2();
    }

    public static void g() throws MyException2 {
        System.out.println("Throwing MyException2 from g()");
        throw new MyException2("Originated in g()");
    }

    public static void h() throws MyException2 {
        System.out.println("Throwing MyException2 from h()");
        throw new MyException2("Originated in h()", 47);
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
        }

        try {
            g();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
        }

        try {
            h();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
            System.out.println("e.val = " + e.val());
        }
    }
}
