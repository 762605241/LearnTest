package com.learn.thread.ticket;

public class Test implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            while (true) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "购买了第" + ticket-- + "张票");
                } else {
                    return;
                }
            }
        }
    }

    private int ticket = 5;

    public static void main(String[] args) {
        Test test = new Test();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        Thread t3 = new Thread(test);
        Thread t4 = new Thread(test);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
