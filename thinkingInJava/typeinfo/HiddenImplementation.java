package thinkingInJava.typeinfo;

import thinkingInJava.typeinfo.interfacea.A;
import thinkingInJava.typeinfo.packageaccess.HiddenC;

import java.lang.reflect.Method;

public class HiddenImplementation {
    public static void main(String[] args) throws Exception{
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());

        callHiddenMethod(a, "g");

        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    /**
     * 如果知道方法名，通过使用反射，在其method对象上调用setAccessible(true)可以到达并调用所有方法，
     * 甚至是private方法
     * @param a
     * @param methodName
     * @throws Exception
     */
    static void callHiddenMethod(Object a, String methodName) throws Exception{
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
