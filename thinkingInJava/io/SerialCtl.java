package thinkingInJava.io;

import java.io.*;

public class SerialCtl implements Serializable {
    private String a;
    private transient String b;
    public SerialCtl(String a, String b) {
        this.a = "Not Transient: " + a;
        this.b = "Transient: " + b;
    }

    public String toString() {
        return a + "\n" + b;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(b);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        b = (String) stream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialCtl sc = new SerialCtl("TEST1", "TEST2");
        System.out.println("Before:\n" + sc);

        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buf);
        o.writeObject(sc);

        //now get it back:
        ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(buf.toByteArray())
        );
        SerialCtl sc2 = (SerialCtl) in.readObject();
        System.out.println("After:\n" +sc2);
    }
}
