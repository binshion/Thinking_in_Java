package singleton;

public class Singleton {
    //构造方法私有化
    private Singleton(){

    }

    //静态变量指向实例
    private static Singleton instance = new Singleton();

    //公有方法获取实例
    public static Singleton getInstance(){
        return instance;
    }
}
