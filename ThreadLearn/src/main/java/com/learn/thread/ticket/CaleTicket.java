package com.learn.thread.ticket;

public class CaleTicket implements Runnable{

    private Ticket ticket;

    public CaleTicket() {
    }

    public CaleTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void run() {

        getTicket();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getTicket() {
        while (true) {
            synchronized(this.ticket.getNum()) {
                if (this.ticket.getNum() > 0) {
                    System.out.println(Thread.currentThread().getName() + "购买了第" + this.ticket.getNum() + "张票");
                    this.ticket.setNum(this.ticket.getNum() - 1);
                } else {
                    System.out.println("票卖完了");
                    return;
                }
            }
        }
    }
}
