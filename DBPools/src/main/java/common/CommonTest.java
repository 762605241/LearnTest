package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class CommonTest {
    private static Connection conn = null;

    //获取一个数据库连接
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String dbUrl = "jdbc:mysql://39.97.174.6:3306/problems";
            conn = DriverManager.getConnection(dbUrl, "root", "Liuliang+8023");
            conn.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }
}
