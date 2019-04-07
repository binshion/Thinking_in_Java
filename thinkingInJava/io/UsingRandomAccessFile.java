package thinkingInJava.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {
    static String file = "e:/JavaProject/Thinking_in_Java/thinkingInJava/io/rtest.dat";
    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println("Value " + i + ": " + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++) {
            rf.writeDouble(i * 1.414);
        }
        rf.writeUTF("The end of the file");
//        rf.close();  //关闭流此时会导致异常，提示流已关闭

        display();
        rf.seek(5 * 8);  //double为8字节长度
        rf.writeDouble(47.0001);
        rf.close();
        display();
    }
}
