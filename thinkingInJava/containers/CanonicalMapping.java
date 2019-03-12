package thinkingInJava.containers;

import java.util.WeakHashMap;

/**
 * 运行时，垃圾回收器每隔3个键就跳过一个，因为指向那个键的普通引用被存入了keys数组，
 * 所以那些对象不能被垃圾回收器回收。
 */
public class CanonicalMapping {
    public static void main(String[] args) {
        int size = 1000;
        if (args.length > 0) {
            size = new Integer(args[0]);
        }

        Key[] keys = new Key[size];
        WeakHashMap<Key,Value> map = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i % 3 == 0) {
                keys[i] = k;
            }
            map.put(k, v);
        }
        System.gc();
    }
}

class Element {
    private String ident;
    public Element(String id) {
        ident = id;
    }

    public String toString() {
        return ident;
    }

    public int hashCode() {
        return ident.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Element && ident.equals(((Element) obj).ident);
    }

    @Override
    protected void finalize() {
        System.out.println("Finalizing " + getClass().getSimpleName() + " " + ident);
    }
}

class Key extends Element {
    public Key(String id) {
        super(id);
    }
}

class Value extends Element {
    public Value(String id) {
        super(id);
    }
}
