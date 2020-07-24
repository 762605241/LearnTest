package com.learn.thread.ticket;

public class CaleTicket implements Runnable{

    static Ticket ticket;

    public CaleTicket() {
    }

    public CaleTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void run() {

        getTicket();

    }

    private void getTicket() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(ticket) {
                if (ticket.num > 0) {
                    System.out.println(Thread.currentThread().getName() + "购买了第" + ticket.num-- + "张票");
                } else {
                    System.out.println(Thread.currentThread().getName() + "票卖完了");
                    return;
                }
            }
        }
    }
}
