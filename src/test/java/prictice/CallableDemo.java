package prictice;

import javafx.concurrent.Task;

import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        Future future = executor.submit(new Task());
        // 这里会阻塞线程
        System.out.println("子线程执行结果：" + future.get());
        executor.shutdown();
    }

    public static class Task implements Callable<Integer> {

        public Integer call() throws Exception {
            System.out.println("子线程正在执行...");
            Thread.sleep(2000);
            return 1;
        }
    }
}