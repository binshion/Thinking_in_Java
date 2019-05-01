package thinkingInJava.concurrency;

public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;
    public SimpleThread() {
        //store the thread name:
        super(Integer.toString(++threadCount));
        start();
    }

    /**
     * 通过调用适当的Thread构造器为Thread对象赋予具体的名称
     * 通过getName()从toString()中获得
     * @return
     */
    @Override
    public String toString() {
        return "#" + getName() + "(" + countDown + "), ";
    }

    @Override
    public void run() {
       while (true) {
           System.out.print(this);
           if(--countDown == 0) {
               return;
           }
       }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
