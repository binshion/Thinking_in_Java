package thinkingInJava.io;

import java.io.*;

import static thinkingInJava.util.Print.*;

/**
 * Externalizable的使用，所有的默认构造器都会被调用然后调用readExternal()
 */
public class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        print("Constructing objects:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();

        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream("E:/JavaProject/Thinking_in_Java/thinkingInJava/io.Blips.out")
        );
        print("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();

        //now get them back:
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("E:/JavaProject/Thinking_in_Java/thinkingInJava/io.Blips.out")
        );
        print("Recovering b1:");
        b1 = (Blip1) in.readObject();

        //Blip2的构造器为default
        print("Recovering b2:");
        b2 = (Blip2) in.readObject();
    }
}

class Blip1 implements Externalizable {
    public Blip1() {
        print("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
    public Blip2() {
        print("Blip2 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip2.readExternal");
    }
}
