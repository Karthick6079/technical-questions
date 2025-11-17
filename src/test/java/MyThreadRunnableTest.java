import org.example.karthick.MyThread;
import org.example.karthick.MyThreadRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyThreadRunnableTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyThreadRunnable runnable = new MyThreadRunnable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
//        t1.join();
        t2.start();
        t3.start();

        Thread t4 = new Thread(() -> System.out.println("Thread is running " +  Thread.currentThread().getName()));
        t4.start();

        Runnable runnable1 = () -> {
            try {
//                Thread.sleep(1000);
                System.out.println("Thread executed via ExecutorService");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Callable<String> callable = () -> {
//            TimeUnit.MICROSECONDS.sleep(1000);
            System.out.println("Callable method is called");
            return "Task's Execution";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callable);
        callableTasks.add(callable);
        callableTasks.add(callable);
        callableTasks.add(callable);


        ExecutorService executorService = Executors.newFixedThreadPool(3);
        System.out.println(executorService.invokeAny(callableTasks));


        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

//        Future<String> resultFuture = scheduledExecutorService.schedule(callable, 1, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(runnable1, 100, 450, TimeUnit.SECONDS);

    }
}
