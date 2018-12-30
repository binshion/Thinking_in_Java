package thinkingInJava.exceptions;

/**
 * 在异常处理程序中，调用了在Throwable类声明（Exception继承自Throwable）的
 * printStackTrace()方法。它将打印“从方法调用处知道异常抛出处”的方法调用序列。
 */
public class FullConstructors {
    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            //这里，信息被发送到System.out，并自动被捕获和显示在输出中。
            //但是如果调用默认版本e.printStackTrace()则信息被输出到标准错误流。
            e.printStackTrace(System.out);
        }

        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
}

class MyException extends Exception {
    public MyException() {}

    public MyException(String msg) {
        super(msg);
    }
}
