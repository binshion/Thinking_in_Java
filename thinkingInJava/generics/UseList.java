package thinkingInJava.generics;

import java.util.List;

public class UseList<W, T> {
    //由于擦除的原因，重载方法将产生相同的类型签名
    //void f(List<T> v) {}
    void f(List<W> v) {}
}

class UseList2<W, T> {
    //当被擦除的参数不能产生唯一的参数列表时，必须提供明显有区别的方法名
    void f1(List<W> v) {}
    void f2(List<T> v) {}
}
