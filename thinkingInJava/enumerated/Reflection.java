package thinkingInJava.enumerated;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import static thinkingInJava.util.Print.*;

enum Explore {HERE, THERE}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        print("----- Analyzing " + enumClass + " -----");
        print("Interface:");
        for (Type t : enumClass.getGenericInterfaces()) {
            print(t);
        }

        print("Base: " + enumClass.getGenericSuperclass());
        print("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        print(methods);
        return methods;
    }

    public static void main(String[] args){
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);

        print("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        printnb("Exprore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        print(exploreMethods);
    }
}
