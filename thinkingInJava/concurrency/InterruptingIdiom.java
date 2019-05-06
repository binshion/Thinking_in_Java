package thinkingInJava.concurrency;

import java.util.concurrent.TimeUnit;
import static thinkingInJava.util.Print.*;

/**
 * java thinkingInJava.concurrency.InterruptingIdiom 1100
 * 1.point1 和point2之间发生，则再第一层试图调用阻塞操作之前，经由异常退出
 * 2.point2之后，循环将结束，然后所有本地对象将被销毁，最后循环经由while()语句顶部退出
 */
class NeedsCleanup {
    private final int id;
    public NeedsCleanup(int id) {
        this.id = id;
        print("NeedsCleanup " + id);
    }

    public void cleanup() {
        print("Cleaning up " + id);
    }
}

class Blocked3 implements Runnable {
    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //point1
                NeedsCleanup n1 = new NeedsCleanup(1);

                try {
                    print("Sleeping");
                    TimeUnit.SECONDS.sleep(1);

                    //point2
                    NeedsCleanup n2 = new NeedsCleanup(2);

                    try {
                        print("Calculating");
                        for (int i = 0; i < 2500000; i++) {
                            d = d + (Math.PI + Math.E) / d;
                        }
                        print("Finished time-consuming operation");
                    } finally {
                        n2.cleanup();
                    }
                } finally {
                    n1.cleanup();
                }
            }
            print("Exiting via while() test");
        } catch (InterruptedException e) {
            print("Exiting via InterruptedException");
        }
    }
}

public class InterruptingIdiom {
    public static void main(String[] args) throws Exception {
        if(args.length != 1) {
            print("usage: java InterruptingIdiom delay-in-mS");
            System.exit(1);
        }
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
        t.interrupt();
    }
}
