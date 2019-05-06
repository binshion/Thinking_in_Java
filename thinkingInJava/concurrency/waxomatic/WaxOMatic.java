package thinkingInJava.concurrency.waxomatic;

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

public class WaxOMatic {
}
