package thinkingInJava.typeinfo;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    Toy() {}
    Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots{
    FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
            " is interface? [" + cc.isInterface() + "]");

        System.out.println("Simple name: " + cc.getSimpleName());  //不含包名的类名

        System.out.println("Canonical name: " + cc.getCanonicalName());  //全限定类名
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c= Class.forName("thinkingInJava.typeinfo.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }

        printInfo(c);

        for(Class face : c.getInterfaces()) {
            printInfo(face);
        }

        Class up = c.getSuperclass();
        Object obj = null;

        try {
            obj = up.newInstance();  //使用newInstance()创建的类，必须带有默认的构造器
        } catch (InstantiationException e) {
            System.out.println("Can't instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }

        printInfo(obj.getClass());
    }
}
