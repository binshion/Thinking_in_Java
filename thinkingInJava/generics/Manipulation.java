package thinkingInJava.generics;

class Manipulator<T> {
    private T obj;

    public Manipulator(T x) {
        obj = x;
    }

    //由于有擦除，编译器无法将方法必须能够在obj上调用f()这一需求映射到HasF拥有f()这一事实上。
    public void manipulate() {
        //编译错误
//        obj.f();
    }
}

/**
 * 为调用f()，必须协助反省了，给定泛型类的边界，以此告知编译器只能接受这个边界的类型
 * @param <T>
 */
class Manipulator2<T extends HasF> {
    private T obj;

    public Manipulator2(T x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}

public class Manipulation<T> {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
}
