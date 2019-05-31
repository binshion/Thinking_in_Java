package thinkingInJava.concurrency;

import java.util.List;

/**
 * Rough comparison of thread-safe List performance
 */
public class ListComparisons {
}

abstract class ListTest extends Tester<List<Integer>> {
    ListTest(String testId, int nReaders, int nWriters) {
        super(testId, nReaders, nWriters);
    }

    class Reader extends TestTask {
        long result = 0;

        @Override
        void test() {
            for (long i = 0; i < testCycles; i++) {
                for (int index = 0; index < containerSize; index++) {
                    testContainer.set(index, writeData[index]);
                }
            }
        }

        @Override
        void putResults() {
        writeTime += duration;
        }
    }
}
