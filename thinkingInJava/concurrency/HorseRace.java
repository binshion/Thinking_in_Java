package thinkingInJava.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static thinkingInJava.util.Print.*;

class Horse implements Runnable {
    private static int counter = 1;
    private final int id = counter++;
    private int strides = 0;
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier b) {
        barrier = b;
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    strides += rand.nextInt(3);  //produces 0, 1 or 2
                }
                barrier.await();
            }
        } catch (InterruptedException e) {
            //a legitimate way to exit
        } catch (BrokenBarrierException e) {
            //this one we want to know about
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Horse " + id + " ";
    }

    public String tracks() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            s.append("*");
        }
        s.append(id);

        return s.toString();
    }
}

public class HorseRace {
    static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    public HorseRace(int nHorse, final int pause) {
        //向CyclicBarrier提供一个“栅栏动作”，它是一个Runnable，当计数值到达0时自动执行。
        barrier = new CyclicBarrier(nHorse, new Runnable() {
            @Override
            public void run() {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++) {
                    s.append("=");  //the fence on the racetrack
                }
                print(s);
                for (Horse horse : horses) {
                    print(horse.tracks());
                }
                for (Horse horse : horses) {
                    if(horse.getStrides() >= FINISH_LINE) {
                        print(horse + "won!");
                        exec.shutdownNow();
                        return;
                    }
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    print("barrier-action sleep interrupted");
                }
            }
        });

        for (int i = 0; i < nHorse; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHourse = 7;
        int pause = 200;
        if(args.length > 0) {  //可选参数
            int n = new Integer(args[0]);
            nHourse = n > 0 ? n : nHourse;
        }

        if(args.length > 1) {  //可选参数
            int p = new Integer(args[1]);
            pause = p > -1 ? p : pause;
        }

        new HorseRace(nHourse, pause);
    }
}
