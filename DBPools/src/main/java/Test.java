import c3p0.C3p0Test;
import common.CommonTest;
import dbcp.DBCPTest;

import java.sql.Connection;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws Exception {

        long d1 = System.currentTimeMillis();
// 插入每条数据，都获取一个连接
//        for (int i = 0; i < 1000; i++) {
//            Connection connection = CommonTest.getConnection();
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("insert into Student values('" + i + "','" + i + "','" + i + "','" + i + "')");
//        }// 66699

        // 使用dbcp连接池插入1000调数据
//        for (int i = 0; i <= 1000; i++) {
//            Connection connection = DBCPTest.getConnection();
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("insert into Student values('" + i + "','" + i + "','" + i + "','" + i + "')");
//            connection.commit();
//            connection.close();
//        }// 28811
        // 使用连接池插入数据1000调数据后 一起提交
//        Connection connection = CommonTest.getConnection();
//        for (int i = 0; i <= 1000; i++) {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("insert into Student values('" + i + "','" + i + "','" + i + "','" + i + "')");
//        }
//        connection.commit();//5871
        // 使用c3p0插入1000条数据
//        for (int i = 0; i <= 1000; i++) {
//            Connection connection = C3p0Test.getConnection();
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("insert into Student values('" + i + "','" + i + "','" + i + "','" + i + "')");
//            connection.commit();
//            statement.close();
//            connection.close();
//        }//31271
        long d2 = System.currentTimeMillis();
        System.out.println(d2 - d1);
    }
}
