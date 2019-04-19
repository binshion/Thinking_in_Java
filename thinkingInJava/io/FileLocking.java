package thinkingInJava.io;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("e:/JavaProject/Thinking_in_Java/thinkingInJava/io/MappedIO.java");
        FileLock fl = fos.getChannel().tryLock();  //tryLock为非阻塞的，lock为阻塞的
        if (fl != null) {
            System.out.println("Locked File");
            TimeUnit.MILLISECONDS.sleep(100);
            fl.release();
            System.out.println("Released Lock");
        }
        fos.close();
    }
}
