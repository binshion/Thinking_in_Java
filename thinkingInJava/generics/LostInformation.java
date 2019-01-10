package thinkingInJava.generics;

import java.util.*;

class Frob {}
class Fnorkle {}
class Quark<Q> {}
class Particle<POSITION, MOMENTUM> {}

/**
 * 在泛型代码内部，无法获得任何有关泛型参数类型的信息。
 * Java泛型是使用擦除来实现的
 * main:
 * [E]
 * [K, V]
 * [Q]
 * [POSITION, MOMENTUM]
 */
public class LostInformation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList<Frob>();
        Map<Frob, Fnorkle> map = new HashMap<Frob, Fnorkle>();
        Quark<Fnorkle> quark = new Quark<Fnorkle>();
        Particle<Long, Double> p = new Particle<Long, Double>();

        //Class.getTypeParameters()返回一个TypeVariable对象数组，表示有泛型声明所声明的类型参数
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));

        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));

        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));

        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
    }
}
