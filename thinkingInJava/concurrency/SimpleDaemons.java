package thinkingInJava.concurrency;

import java.util.concurrent.TimeUnit;

import static thinkingInJava.util.Print.*;

public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            print("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);  //必须在线程启动前调用，才能设置为吼他线程
            daemon.start();
        }

        print("All daemons starterd");
        TimeUnit.MILLISECONDS.sleep(100);  //休眠时间长短，输出内容不同
    }
}
