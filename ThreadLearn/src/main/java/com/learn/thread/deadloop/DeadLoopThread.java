package com.learn.thread.deadloop;

/**
 * @author 刘晓亮
 * @date 2020/7/24 11:59
 */
public class DeadLoopThread implements Runnable {
    @Override
    public void run() {
        // 这是一个死循环线程
        while (true) {

            System.out.println("这是一个死循环线程");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
