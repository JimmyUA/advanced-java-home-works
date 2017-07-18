package com.sergey.prykhodko.example.shop;

/**
 * Created by Sergey on 10.07.2017.
 */
public class Account {
    private long number;
    private String pin;
    private volatile long balance;

    public Account(long number, String pin, int balance) {
        this.number = number;
        this.pin = pin;
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public  void setBalance(long balance) {
        this.balance = balance;
    }

    public String getPin() {

        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public long getNumber() {

        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
