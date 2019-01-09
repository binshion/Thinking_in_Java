package thinkingInJava.generics;

import thinkingInJava.util.Generator;

import java.util.Collection;

public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for(int i = 0; i < n; i++) {
            coll.add(gen.next());
        }

        return coll;
    }
}
