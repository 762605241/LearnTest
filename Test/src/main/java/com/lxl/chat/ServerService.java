package com.lxl.chat;

import java.net.Socket;

/**
 * @author 刘晓亮
 * @date 2020/8/17 14:20
 */
public class ServerService implements Runnable{
    private Socket socket;

    public ServerService(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 开启多线程 接收 or 发送 数据
            new Thread(new SendMsgService(socket)).start();
            new Thread(new ReceiveMsgService(socket)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
