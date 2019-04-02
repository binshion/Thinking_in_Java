package thinkingInJava.io;

import java.io.*;

public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("e:/JavaProject/Thinking_in_Java/thinkingInJava/io/TestEOF.java")));
        while (in.available() != 0) {  //在没有阻塞的情况下所能读取的字节数
            System.out.print((char) in.readByte());
        }
    }
}
