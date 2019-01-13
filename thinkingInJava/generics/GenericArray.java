package thinkingInJava.generics;

/**
 * 在运行时，仍然是Object数组。
 * 成功创建泛型数组的唯一方式是创建一个呗擦除的类型新数组，然后对其转型
 * @param <T>
 */
public class GenericArray<T> {
    private T[] array;

    public GenericArray(int size) {
        array = (T[])new Object[size];
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
        GenericArray<Integer> gai =
                new GenericArray<>(10);

        //ClassCastException
//        Integer[] ia = gai.rep();

        Object[] oa = gai.rep();
    }
}
