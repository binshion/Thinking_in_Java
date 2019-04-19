package thinkingInJava.io;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import static thinkingInJava.util.Print.*;

public class LargeMappedFiles {
    static int length = 0x8FFFFFF;  //128MB
    public static void main(String[] args) throws Exception{
        MappedByteBuffer out = new RandomAccessFile(
                "e:/JavaProject/Thinking_in_Java/thinkingInJava/io/BigFile.dat", "rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            out.put((byte)'x');
        }

        print("Finished writing");

        for (int i = length / 2; i < length / 2 + 6; i++) {
            printnb((char)out.get(i));
        }
    }
}
