package com.lxl.chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Scanner;

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
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Scanner scanner = new Scanner(System.in);
                    while (true) {
                        try {
                            String msg = scanner.nextLine();
                            String[] split = msg.split(":");
                            Socket socket = ChatServer.accountSocketMap.get(split[0]);
                            System.err.println("向客户端" + socket.getPort() + "发送");
                            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                            dataOutputStream.writeUTF(split[1]);
                            dataOutputStream.flush();
                            scanner = new Scanner(System.in);
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }).start();
            new Thread(new ReceiveMsgService(socket)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
