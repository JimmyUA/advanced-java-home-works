package com.sergey.prykhodko;

import static java.lang.Thread.sleep;

/**
 * Created by Sergey on 10.07.2017.
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread slave = new Thread(() -> {
            Thread current = Thread.currentThread();
            System.out.println(current.getName() + " " + current.getState());

            try {
                sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e + "" + Thread.currentThread().getState());
            }
            System.out.println(current.getName() + "finished");


        });
        slave.setDaemon(true);
        System.out.println(slave.getState());
        slave.start();

//        slave.join();


        sleep(100);

        System.out.println("main finished");



    }
}
