package thinkingInJava.io;

import java.io.*;
import java.util.Random;

import static thinkingInJava.util.Print.*;

class Data implements Serializable {
    private int n;
    public Data(int n){
        this.n = n;
    }

    public String toString(){
        return Integer.toString(n);
    }
}

public class Worm implements Serializable {
    private static Random rand = new Random(47);
    private Data[] d = {new Data(rand.nextInt(10)),
                        new Data(rand.nextInt(10)),
                        new Data(rand.nextInt(10))};
    private Worm next;
    private char c;

    //Values if i = number of segments
    public Worm(int i, char x){
        print("Worm constructor: " + i);
        c = x;
        if(--i > 0) {
            next = new Worm(i, (char)(x + 1));
        }
    }

    public Worm() {
        print("Default constructor");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data data : d){
            result.append(data);
        }
        result.append(")");
        if (next != null){
            result.append(next);
        }
        return result.toString();
    }
    public static void main(String[] args) throws ClassNotFoundException,
            IOException {
        Worm w = new Worm(6, 'a');
        print("w = " + w);
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("F:/JavaProject/Thinking_in_Java/thinkingInJava/io/worm.out")
        );
        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close();

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("F:/JavaProject/Thinking_in_Java/thinkingInJava/io/worm.out")
        );

        String s = (String)in.readObject();
        Worm w2 = (Worm)in.readObject();

        print(s + "w2 = " + w2);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm storage\n");
        out2.writeObject(w);
        out2.flush();

        ObjectInputStream in2 = new ObjectInputStream(
                new ByteArrayInputStream(bout.toByteArray())
        );
        s = (String) in2.readObject();
        Worm w3 = (Worm)in2.readObject();
        print(s + "w3 = " + w3);
    }
}
