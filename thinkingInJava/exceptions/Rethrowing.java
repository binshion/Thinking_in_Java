package thinkingInJava.exceptions;

public class Rethrowing {
    public static void f() throws Exception {
        System.out.println("originating the exception in f()");
        throw new Exception("thrown from f()");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside g(), e.printStackTrace()");
            e.printStackTrace(System.out);
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside h(), e.printStackTrace()");
            e.printStackTrace(System.out);

            //调用fillInStackTrace()通过把当前调用栈信息填入原来那个异常对象
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            //g()方法中的f()方法重抛异常，会把异常抛给上一级环境中的异常处理程序
            //同一个try块的后续catch子句将被忽略
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }

        System.out.println("------------------------------------------------------------");

        try {
            h();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}
