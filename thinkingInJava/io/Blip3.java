package thinkingInJava.io;

import java.io.*;

import static thinkingInJava.util.Print.*;

public class Blip3 implements Externalizable {
    private int i;
    private String s;
    public Blip3() {  //i, s 未初始化
        print("Blip3 Constructor");
    }

    public Blip3(String s, int i) {
        //s & i only initialized in non-default constructor.
        this.s = s;
        this.i = i;
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip3.writeExternal");

        //must do this
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip3.readExternal");

        //must do this
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        print("Constructing objects:");
        Blip3 b3 = new Blip3("A String ", 47);
        print(b3);

        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream("E:/JavaProject/Thinking_in_Java/thinkingInJava/io/Blip3.out")
        );
        print("Saving object:");

        o.writeObject(b3);
        o.close();

        //Now get it back
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("E:/JavaProject/Thinking_in_Java/thinkingInJava/io/Blip3.out")
        );
        print("Recovering b3:");
        b3 = (Blip3) in.readObject();
        print(b3);
    }
}
