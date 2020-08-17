package com.reptiles.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 刘晓亮
 * @date 2020/8/7 18:03
 */
public class WeatherTest {
    public static void main(String[] args) {
        try {

            URL getnuwUrl = new URL("http://www.weather.com.cn/");

            // 根据拼凑的URL，打开连接，URL.openConnection()函数会根据 URL的类型，返回不同的URLConnection子类的对象，在这里我们的URL是一个http，因此它实际上返回的是HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) getnuwUrl.openConnection();
            // 建立与服务器的连接，并未发送数据
            connection.connect();
            // 发送数据到服务器并使用Reader读取返回的数据
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines = null;
            while ((lines = reader.readLine()) != null) {
                System.out.println(lines);
            }
            reader.close();
            // 断开连接
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
