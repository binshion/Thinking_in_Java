package thinkingInJava.concurrency;

/**
 * 本例使用单一线程main()在创建所有的LiftOff线程。
 * 但是，如果多个线程在创建LiftOff线程，那么就要可能会有多个LiftOff拥有
 * 相同的id。
 */
public class MoreBasicThreads {
    public static void main(String[] args){
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
