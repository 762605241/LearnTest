package com.lxl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest {
    public static void main(String[] args) throws Exception {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://39.97.174.6:3306/tran", "root", "Liuliang+8023");
        // 创建sql
        String sql = "select * from psn;";
        // 创建执行对象
        Statement statement = connection.createStatement();
        // 执行SQL 并 获取结果集
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("id\t\tname");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + "\t\t" + resultSet.getString("name"));
        }
        // 关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
