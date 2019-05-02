package thinkingInJava.concurrency;

/**
 * 在一个无限循环里执行运算，程序不会读取到控制台的输入的那一行
 * （编译器被欺骗了，相信了while条件使得程序能到达读取输入的这一行）
 */
class UnresponsiveUI {
    private volatile double d = 1;
    public UnresponsiveUI() throws Exception {
        while (d > 0) {
            d = d + (Math.PI + Math.E) / d;
        }
        System.in.read();
    }
}

/**
 * 想让程序有响应，就得把计算程序放在run()方法中，这样它就能让出处理器给别的程序。
 * 让出控制权读取输入
 */
public class ResponsiveUI extends Thread {
    private static volatile double d = 1;
    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws Exception {
//        new UnresponsiveUI();
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
