package thinkingInJava.concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 从任务中返回值
 *      实现Callable接口而不是Runnable接口。必须使用
 *      ExecutorService.submit()方法调用call()方法
 */
class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        return "result to TaskWithResult " + id;
    }
}

/**
 * submit方法会产生Future对象，它用Callable返回结果的特定类型进行了参数化。
 * 可以用isDone()方法来查询Future是否已经完成。当任务完成时，它具有一个结果，
 * 可调用get()方法来获取结果。也可以不使用isDone()检查而直接get(),但会阻塞直到
 * 结果准备就绪。
 */
public class CallableDemo {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : results) {
            try {
                //get() blocks until completion
//                if (fs.isDone())
                    System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
        }
    }
}
