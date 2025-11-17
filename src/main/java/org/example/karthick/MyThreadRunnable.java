package org.example.karthick;

public class MyThreadRunnable implements Runnable{

    private int sharedData = 0;

    @Override
    public void run() {
        try {
            System.out.println("Current Thread Name: " + Thread.currentThread().getName());
//            System.out.println("Thread waits for 1 sec");
            updateSharedData(100);
            System.out.println("The updated sharedData: " + getData());
//            Thread.sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



    public void updateSharedData(int data){
        this.sharedData = data;
    }

    public int getData(){
        return sharedData;
    }


}
