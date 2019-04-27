package thinkingInJava.io;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class FreezeAlien {
    public static void main(String[] args) throws Exception {
        ObjectOutput out = new ObjectOutputStream(
                new FileOutputStream("E:/JavaProject/Thinking_in_Java/thinkingInJava/io/X.file")
        );

        Alien quellek = new Alien();
        out.writeObject(quellek);
    }
}
