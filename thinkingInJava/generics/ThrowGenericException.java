package thinkingInJava.generics;

import java.util.ArrayList;
import java.util.List;

interface Processor<T,E extends Exception> {
    void process(List<T> resultCollector) throws E;
}

class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T,E>> {
    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<T>();
        for(Processor<T, E> processor : this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Failure1 extends Exception {}

class Processor1 implements Processor<String, Failure1> {
    static int count = 3;
    public void process(List<String> resultCollector) throws Failure1 {
        if(count-- > 1) {
            resultCollector.add("Hep!");
        } else {
            resultCollector.add("Ho!");
        }

        if(count < 0) {
            throw new Failure1();
        }
    }
}

class Failure2 extends Exception {}

class Processor2 implements Processor<Integer, Failure2> {
    static int count = 2;
    public void process(List<Integer> resultCollector) throws Failure2 {
        if(count-- == 0) {
            resultCollector.add(47);
        } else {
            resultCollector.add(11);
        }

        if(count < 0) {
            throw new Failure2();
        }
    }
}

/**
 * Processor执行process()，并且可能会抛出具有类型E的异常。
 * process()的结果存储在List<T> resultCollector中。这被称为收集参数。
 * ProcessRunner有一个processAll()方法，它将执行所吃鱼哦的每个Process对象，
 * 并返回resultCollector。
 */
public class ThrowGenericException {
    public static void main(String[] args){
        ProcessRunner<String, Failure1> runner =
                new ProcessRunner<>();

        for(int i = 0; i < 3; i++) {
            runner.add(new Processor1());
        }

        try {
            System.out.println(runner.processAll());
        } catch (Failure1 e) {
            System.out.println(e);
        }

        ProcessRunner<Integer, Failure2> runner2 =
                new ProcessRunner<>();

        for(int i = 0; i < 3; i++) {
            runner2.add(new Processor2());
        }

        try {
            System.out.println(runner2.processAll());
        } catch (Failure2 e) {
            System.out.println(e);
        }
    }
}
