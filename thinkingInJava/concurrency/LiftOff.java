package thinkingInJava.concurrency;

public class LiftOff implements Runnable {
    protected int countDown = 10;  //Default
    private static int taskCount = 0;
    private final int id = taskCount++;  //多实例的id使用final来定义，以便区分

    public LiftOff() {}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());

            //对线程调度器的一种建议，出让执行时间
            Thread.yield();
        }
    }
}
