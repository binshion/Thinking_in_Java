package thinkingInJava.innerclasses;

/**
 * 内部类标识符
 * Counter.class
 * LocalInnerClass$1.class  匿名内部类，编译器简单地产生一个数字作为其标识符
 * LocalInnerClass$LocalCounter.class  嵌套内部类
 * LocalInnerClass.class
 */
interface Counter {
    int next();
}

public class LocalInnerClass {
    private int count = 0;
    Counter getCounter(final String name) {
        class LocalCounter implements Counter {
            public LocalCounter() {
                System.out.println("LocalCounter()");
            }

            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        }

        return new LocalCounter();
    }

    Counter getCounter2(final String name) {
        return new Counter() {
            {
                System.out.println("Counter()");
            }

            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter
                c1 = lic.getCounter("Local inner "),
                c2 = lic.getCounter2("Anonymous inner ");

        for(int i = 0; i < 5; i++) {
            System.out.println(c1.next());
        }

        System.out.println("***************");

        for(int i = 0; i < 5; i++) {
            System.out.println(c2.next());
        }
    }
}
