package thinkingInJava.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * main:
 * [null, null, null, null, null,
 *          null, null, null, null]
 * @param <T>
 */
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    //对于在泛型中创建数组，推荐使用Array.newInstance()
    T[] create(int size) {
        return (T[])Array.newInstance(kind, size);
    }

    public static void main(String[] args){
        ArrayMaker<String> stringMaker =
                new ArrayMaker<String>(String.class);

        String[] stringArray = stringMaker.create(9);

        System.out.println(Arrays.toString(stringArray));
    }
}
