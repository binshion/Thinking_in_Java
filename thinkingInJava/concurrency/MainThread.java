package thinkingInJava.concurrency;

/**
 * 从Runnable导出的类，它不会产生任何内在的线程能力。
 * 但是要实现线程行为，必须显式地将一个任务附着到线程上。
 */
public class MainThread {
    public static void main(String[] args){
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
