package thinkingInJava.concurrency;

public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    /**
     * 一个任务可能在另一个任务执行第一个对currentEvenValue递增操作后，但还没执行第二次递增之前，盗用next()方法。
     * 这将使得这个值处于  不恰当 的状态
     * @return
     */
    @Override
    public int next() {
        ++currentEvenValue;  //Danger point here!
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
