package thinkingInJava.exceptions;

/**
 * 一种更加简单丢失异常的方式：finally子句中返回
 */
public class ExceptionSilencer {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            return;
        }
    }
}
