package com.learn.thread.ticket;

/**
 * @author 刘晓亮
 * @date 2020/7/24 10:47
 */
public class TicketCaleTest1 implements Runnable {
    int ticket = 5;

    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "购买了第" + ticket-- + "张票");
                } else {
                    System.out.println(Thread.currentThread().getName() + "票卖完了");
                    return;
                }
            }

        }
    }

    public static void main(String[] args) {
        TicketCaleTest1 ticketCaleTest1 = new TicketCaleTest1();
        Thread t1 = new Thread(ticketCaleTest1, "A");
        Thread t2 = new Thread(ticketCaleTest1, "B");
        Thread t3 = new Thread(ticketCaleTest1, "C");
        Thread t4 = new Thread(ticketCaleTest1, "D");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
