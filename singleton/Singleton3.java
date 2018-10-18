package singleton;

/**双重检测机制（DCL)懒汉式*/
public class Singleton3 {
    private Singleton3(){

    }

    private volatile static Singleton3 instance;

    public static Singleton3 getInstance(){
        //此处判空主要是为了提高性能
        if(null == instance) {
            //将锁的范围缩小，提高性能
            synchronized (Singleton3.class) {
                if(null == instance) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
