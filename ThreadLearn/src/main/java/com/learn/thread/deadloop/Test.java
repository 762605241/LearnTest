package com.learn.thread.deadloop;

/**
 * @author 刘晓亮
 * @date 2020/7/24 12:02
 */
public class Test {
    public static void main(String[] args) {
        DeadLoopThread deadLoopThread = new DeadLoopThread();
        Thread t1 = new Thread(deadLoopThread);
        NormalThread normalThread = new NormalThread();
        Thread t2 = new Thread(normalThread);
        t1.start();
        t2.start();
    }
    // 死循环只是线程体中的任务，并不影响 cpu的轮换，时间片的抢占，所有就绪状态的线程都有机会执行
}
