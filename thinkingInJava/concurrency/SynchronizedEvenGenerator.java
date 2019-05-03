package thinkingInJava.concurrency;

public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    @Override
    public synchronized int next() {
        ++currentEvenValue;
//        Thread.yield();  //cause failure faster  提高在currentEvenValue是奇数状态时上下文切换的可能性
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
