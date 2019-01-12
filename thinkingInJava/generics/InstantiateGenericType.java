package thinkingInJava.generics;

class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {}

public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe =
                new ClassAsFactory<>(Employee.class);

        System.out.println("ClassAsFactory<Employee> succeeded");

        /**
         * 可以编译，但是<Integer>会失败，因为Integer没有任何默认的构造器。
         */
        try {
            ClassAsFactory<Integer> fi =
                    new ClassAsFactory<>(Integer.class);
        } catch (Exception e) {
            System.out.println("ClassAsFactory<Integer> failed");
        }
    }
}
