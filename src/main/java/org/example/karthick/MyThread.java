package org.example.karthick;

public class MyThread extends Thread{

    @Override
    public void run() {
        try {
            System.out.println("Thread waits for 1 sec");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Current Thread Name: " + Thread.currentThread().getName());
    }
}
