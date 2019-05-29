package thinkingInJava.concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizationComparisons {
}

abstract class Accumulator {
    public static long cycles = 50000L;

    //Number of modifiers and Readers during each test
    private static final int N = 4;
    public static ExecutorService exec = Executors.newFixedThreadPool(N * 2);
    private static CyclicBarrier barrier = new CyclicBarrier(N * 2 + 1);
    protected volatile int index = 0;
}
