package com.lxl.chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘晓亮
 * @date 2020/8/17 9:23
 */
public class ChatServer {
    private Map<String, Socket> accountSocketMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        Socket socket = null;
        // 建立连接
        serverSocket = new ServerSocket(8888);
        while (true) {
            socket = serverSocket.accept();
            new Thread(new ServerService(socket)).start();
        }
    }
}
