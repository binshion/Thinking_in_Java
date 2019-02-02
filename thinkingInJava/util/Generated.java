package thinkingInJava.util;

public class Generated {
    //Fill an existing array
    public static <T> T[] array(T[] a, Generator<T> gen) {
        return new CollectionData<T>(gen, a.length).toArray();
    }
}
