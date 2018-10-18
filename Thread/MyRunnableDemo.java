package Thread;

public class MyRunnableDemo {
    public static void main(String[] args){
        MyRunnable my = new MyRunnable();

        Thread thread1 = new Thread(my);
        Thread thread2 = new Thread(my);

        thread1.start();
        thread2.start();
    }
}
