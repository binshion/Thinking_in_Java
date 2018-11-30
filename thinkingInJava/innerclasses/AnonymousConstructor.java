package thinkingInJava.innerclasses;

/**
 * 为匿名内部类创建一个构造器
 */
public class AnonymousConstructor {
    public static Base getBase(int i) {
        //参数i未被内部类直接使用，可以不用声明为final
        return new Base(i) {
            {
                System.out.println("Inside instance initializer");
            }

            public void f(){
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args){
        Base base = getBase(47);
        base.f();
    }
}

abstract class Base {
    public Base(int i) {
        System.out.println("Base constructor, i = " + i);
    }

    public abstract void f();
}
