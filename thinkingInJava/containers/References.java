package thinkingInJava.containers;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class References {
    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<>();

    public static void checkQueue() {
        Reference<? extends VeryBig> inq = rq.poll();
        if (inq != null) {
            System.out.println("In queue: " + inq.get());
        }
    }
}

class VeryBig {
    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;
    public VeryBig(String id) {
        ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }

    protected void finalize() {
        System.out.println("Finalizing " + ident);
    }
}