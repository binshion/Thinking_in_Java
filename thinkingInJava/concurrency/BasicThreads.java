package thinkingInJava.concurrency;

public class BasicThreads {
    /**
     * start产生的是对LiftOff.run()的方法调用，并且这个党阀还未完成。
     *  但是因为LiftOff.run()是由不同的线程执行的，因此仍旧可执行main()线程
     *  的其他操作。
     * @param args
     */
    public static void main(String[] args){
        Thread t = new Thread(new LiftOff());  //Thread接收一个Runnable对象
        t.start();  //为该线程执行必须的初始化操作，然后调用Runnable的run()方法
        System.out.println("Waiting for LiftOff");  //最新执行
    }
}
