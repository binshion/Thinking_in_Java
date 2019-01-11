package thinkingInJava.generics;

class Building {}

class House extends Building {}

public class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    /**
     * 引入类型标签，转而使用动态的isInstance()
     * @param arg
     * @return
     */
    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args){
        ClassTypeCapture<Building> ctrl =
                new ClassTypeCapture<Building>(Building.class);

        System.out.println(ctrl.f(new Building()));  //true
        System.out.println(ctrl.f(new House()));  //true

        ClassTypeCapture<House> ctrl2 =
                new ClassTypeCapture<House>(House.class);

        System.out.println(ctrl2.f(new Building()));  //false
        System.out.println(ctrl2.f(new House()));  //true
    }
}
