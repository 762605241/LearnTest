package com.lxl.chat;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @author 刘晓亮
 * @date 2020/8/17 9:23
 */
public class ChatClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8888);
        new Thread(new SendMsgService(socket)).start();
        new Thread(new ReceiveMsgService(socket)).start();
    }
}
