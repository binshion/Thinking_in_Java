package singleton;

/**懒汉式*/
public class Singleton2 {
    private Singleton2(){}

    private static Singleton2 instance;

    public static Singleton2 getInstance() {
        //不存在时创建一个实例
        if(null == instance) {
            instance = new Singleton2();
        }
        return instance;
    }

    /**如果多线程下，加入同步关键字即可
    public static synchronized Singleton2 getInstance()
     */
}
