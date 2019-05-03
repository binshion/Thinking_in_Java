package thinkingInJava.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用原子类重写MutexEvenGenerator类
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);
    @Override
    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
