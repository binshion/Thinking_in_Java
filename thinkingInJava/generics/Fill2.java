package thinkingInJava.generics;

import thinkingInJava.generics.coffee.Coffee;
import thinkingInJava.generics.coffee.Latte;
import thinkingInJava.generics.coffee.Mocha;
import thinkingInJava.util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static thinkingInJava.util.Print.*;

interface Addable<T> {
    void add(T t);
}

/**
 * 适配器仿真
 */
public class Fill2 {
    //Classtoken version
    public static <T> void fill(Addable<T> addable,
                                Class<? extends T> classToken, int size) {
        for(int i = 0; i < size; i++) {
            try {
                addable.add(classToken.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Generator version
    public static <T> void fill(Addable<T> addable,
              Generator<T> generator, int size) {
        for(int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }
}

class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;
    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    @Override
    public void add(T t) {
        c.add(t);
    }
}

class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<T>(c);
    }
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    public void add(T item) {
        super.add(item);
    }
}

class Fill2Test {
    public static void main(String[] args){
        List<Coffee> carrier = new ArrayList<>();

        //Adapt a Collection
        Fill2.fill(new AddableCollectionAdapter<Coffee>(carrier),
                Coffee.class, 3);

        //Helper method captures the type
        Fill2.fill(Adapter.collectionAdapter(carrier),
                Coffee.class, 2);

        for (Coffee c : carrier) {
            print(c);
        }
        print("-------------------------------------");

        //Use an adapted class
        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<>();
        Fill2.fill(coffeeQueue, Mocha.class, 4);
        Fill2.fill(coffeeQueue, Latte.class, 1);

        for (Coffee c : coffeeQueue) {
            print(c);
        }
    }
}