package com.learn.thread.deadloop;

/**
 * @author 刘晓亮
 * @date 2020/7/24 12:01
 */
public class NormalThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            System.out.println("正常线程======================================================" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
