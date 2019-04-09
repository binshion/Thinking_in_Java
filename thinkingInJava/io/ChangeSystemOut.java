package thinkingInJava.io;

import java.io.PrintWriter;

public class ChangeSystemOut {
    public static void main(String[] args){
        //第二个参数，开启自动清空功能，否则可能看不到输出
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello World");
    }
}
