package org.example.karthick.threads;

public class BankAccount {

    private int balance = 1000; // Shared resource (bank balance)

    // Synchronized method for deposit operation
    public void deposit(int amount)
    {
        balance += amount;
        System.out.println("Deposited: " + amount + ", Balance: " + balance);
    }

    // Synchronized method for withdrawal operation
    public void withdraw(int amount)
    {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", Balance: " + balance);
        }
        else {
            System.out.println("Insufficient balance to withdraw: " + amount);
        }
    }

    public int getBalance() { return balance; }
}
