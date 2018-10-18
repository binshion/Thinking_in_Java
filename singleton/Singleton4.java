package singleton;

/**静态内部类懒汉式*/
public class Singleton4 {
    //使用内部类的方式实现懒加载
    private static class LazyHolder {
        //创建单利对象
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    //获取对象
    public static final Singleton4 getInstance() {
        return LazyHolder.INSTANCE;
    }
}
