package com.lxl.qq.vo;

import lombok.Data;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 刘晓亮
 * @date 2020/8/17 16:19
 */
@Data
public class Account implements Serializable {

    private String userName;
    private String passWord;
}
