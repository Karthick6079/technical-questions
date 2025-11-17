import org.example.karthick.MyThread;

public class MyThreadTest {

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.join();
        t1.start();

        MyThread t2 = new MyThread();
        t2.start();

        MyThread t3 = new MyThread();
        t3.start();

        System.out.println("Threads created and executed");


    }
}
