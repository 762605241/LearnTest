package com.learn.thread.ticket;

public class Test {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        ticket.num = 5;
        CaleTicket caleTicket = new CaleTicket(ticket);
        Thread t1 = new Thread(caleTicket);
        Thread t2 = new Thread(caleTicket);
        Thread t3 = new Thread(caleTicket);
        Thread t4 = new Thread(caleTicket);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
