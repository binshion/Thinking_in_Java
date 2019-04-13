package thinkingInJava.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception {
        //Write a file:
        FileChannel fc = new FileOutputStream("f:/JavaProject/Thinking_in_Java/thinkingInJava/io/getChannel.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        //add to the end of the file:
        fc = new RandomAccessFile("f:/JavaProject/Thinking_in_Java/thinkingInJava/io/getChannel.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap(" Some more".getBytes()));
        fc.close();

        //Read the file:
        fc = new FileInputStream("f:/JavaProject/Thinking_in_Java/thinkingInJava/io/getChannel.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()) {
            System.out.println((char) buff.get());
        }
    }
}
