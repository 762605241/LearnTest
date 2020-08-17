package com.lxl.chat;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author 刘晓亮
 * @date 2020/8/17 10:46
 */
public class ReceiveMsgService implements Runnable{

    private Socket socket;

    public ReceiveMsgService(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String msg = dataInputStream.readUTF();
                System.out.println("客户端：" + socket.getPort() + "发送：" + msg);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
