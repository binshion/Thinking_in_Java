package thinkingInJava.generics;

import java.lang.reflect.Array;

/**
 * 类型标记被传递到构造器中，以便从擦除中恢复
 * @param <T>
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;

    public GenericArrayWithTypeToken(Class<T> type, int size) {
        array = (T[])Array.newInstance(type, size);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai =
                new GenericArrayWithTypeToken<>(Integer.class, 10);

        Integer[] ia = gai.rep();
    }
}
