package org.example.karthick.threads;

public class Bank {

    public static void main(String[] args)
    {
        BankAccount account = new BankAccount(); // Shared resource

        // Thread 1 to deposit money into the account
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(200);
                try {
                    Thread.sleep(50); // Simulate some delay
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Thread 2 to withdraw money from the account
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(100);
                try {
                    Thread.sleep(
                            100); // Simulate some delay
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final balance
        System.out.println("Final Balance: " + account.getBalance());
    }
}
