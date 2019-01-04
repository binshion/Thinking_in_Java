package thinkingInJava.typeinfo;

import java.util.*;

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception{
        Class initable = Initable.class;  //仅仅使用.class获得对类的引用不会引发初始化
        System.out.println("After creating Initable ref");

        //Does not trigger initialization:
        System.out.println(Initable.staticFinal);  //static final编译器常量，不需要对类初始化就可以被读取

        //Does trigger initialization:
        System.out.println(Initable.staticFinal2);  //static final非编译器常量的访问，将强制类的初始化

        //Does trigger initialization:
        System.out.println(Initable2.staticNonFinal);  //域static但是非final,在对它访问时，先进行链接（为这个域分配存储空间）
        //和初始化（初始化该存储空间）

        Class initable3 = Class.forName("Initable3");  //Class.forName()立即进行初始化
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
