package thinkingInJava.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " +
            method + ", args: " +args);

        if(args != null) {
            for(Object arg : args) {
                System.out.println("  " + arg);
            }
        }
        return method.invoke(proxied, args);
    }
}

/**
 * 动态代理
 */
public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        //Insert a proxy and call again:
        //通过调用静态方法Proxy.newProxyInstance()可以创建动态代理
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                                    new Class[]{Interface.class}, new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
