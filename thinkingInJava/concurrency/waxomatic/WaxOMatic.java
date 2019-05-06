package thinkingInJava.concurrency.waxomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static thinkingInJava.util.Print.*;

class Car {
    private boolean waxOn = false;

    /**
     * 打蜡
     */
    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }

    /**
     * 抛光
     */
    public synchronized void buffed() {
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (!waxOn) {
            wait();
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn) {
            wait();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;
    public WaxOn(Car c) {
        car = c;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                printnb("Wax on! ");
                TimeUnit.MILLISECONDS.sleep(1000);  //模拟打蜡0.2s
                car.waxed();  //打蜡完成
                car.waitForBuffing();  //挂起抛光任务，直到WaxOff调用buffed
            }
        } catch (InterruptedException e) {
            print("Exiting via interrupt");
        }
        print("Ending Wax on task");
    }
}

class WaxOff implements Runnable {
    private Car car;
    public WaxOff(Car c) {
        car = c;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                printnb("Wax off! ");
                TimeUnit.MILLISECONDS.sleep(2000);
                car.buffed();
            }
        } catch (InterruptedException e) {
            printnb("Exiting via interrupt");
        }
        print("Ending Wax Off task");
    }
}

public class WaxOMatic {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(20);
        exec.shutdownNow();
    }
}
